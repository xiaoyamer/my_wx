package com.my.demo1.service.imp;

import com.my.demo1.common.ResultResponse;
import com.my.demo1.common.enums.ResultEnums;
import com.my.demo1.dto.ProductCategoryDto;
import com.my.demo1.dto.ProductInfoDto;
import com.my.demo1.entity.ProductInfo;
import com.my.demo1.repository.ProductInfoRepository;
import com.my.demo1.service.ProductCategoryService;
import com.my.demo1.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductInfoServiceimp implements ProductInfoService {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ResultResponse queryList() {
        ResultResponse<List<ProductCategoryDto>> categoryAll = productCategoryService.findAll();
        List<ProductCategoryDto> categoryDtos = categoryAll.getData();
        //判断分类列表
        if (CollectionUtils.isEmpty(categoryDtos)){
            return categoryAll;
        }
        //类目编号集合
        List<Integer> categoryTypeList = categoryDtos.stream()
                .map(productCategoryDto -> productCategoryDto.getCategoryType())
                .collect(Collectors.toList());
        //查询商品列表
        //商品上下架使用枚举方便扩展?
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStausAndCategoryTypeIn
                (ResultEnums.PRODUCT_UP.getCode(), categoryTypeList);
        //目前为止所有正常商品都在productInfoList集合中
        //多线程遍历
        //取出每个类目的素有商品，装入对应类目中
        List<ProductCategoryDto> collect = categoryDtos.parallelStream().map(productCategoryDto -> {
            //把返回的分类完的一种类目的的商品设置进productCategoryDto，完成分类装入类目操作
            productCategoryDto.setProductInfoDtoList(
                    //先把所有商品数据转换成流
                    productInfoList.stream()
                            //按类目过滤成对应的单独一类的类目的商品信息
                            .filter(productInfo -> productInfo.getCategoryType() == productCategoryDto.getCategoryType())
                            //由于还是productInfo类型的数据,所以要转换成dto
                            .map(productInfo -> ProductInfoDto.build(productInfo))
                            //最后再把流转回来
                            .collect(Collectors.toList()));
            //返回单独一种类目的所有商品信息，以便完成封装
            return productCategoryDto;
        }).collect(Collectors.toList());
        return ResultResponse.success(collect);
    }
}
