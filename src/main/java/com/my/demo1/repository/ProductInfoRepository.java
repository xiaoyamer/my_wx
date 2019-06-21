package com.my.demo1.repository;

import com.my.demo1.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    //根据类目编号查询正常上架的商品
    List<ProductInfo> findByProductStatusAndAndCategoryTypeIn(Integer status,
                                                          List<Integer> categoryList);

}
