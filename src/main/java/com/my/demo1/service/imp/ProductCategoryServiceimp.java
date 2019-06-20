package com.my.demo1.service.imp;

import com.my.demo1.common.ResultResponse;
import com.my.demo1.dto.ProductCategoryDto;
import com.my.demo1.entity.ProductCategory;
import com.my.demo1.repository.ProductCategoryRepository;
import com.my.demo1.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceimp implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ResultResponse<List<ProductCategoryDto>> findAll() {
        List<ProductCategory> categoryList = productCategoryRepository.findAll();

        //使用流转化为把ProductCategory转化成ProductCategoryDto
        //转化成流后build（）后转化回来
        return ResultResponse.success(categoryList.stream()
                .map(productCategory -> ProductCategoryDto.build(productCategory)).collect(Collectors.toList()));

    }
}
