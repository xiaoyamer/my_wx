package com.my.demo1.repository;

import com.google.common.collect.Lists;
import com.my.demo1.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducCategorytRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    //添加目录测试
    @Test
    public void insert(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("手机");
        productCategory.setCategoryType(1);
        productCategoryRepository.save(productCategory);
    }

    //查询单个目录
    @Test
    public void findOne(){
        Optional<ProductCategory> byId=productCategoryRepository.findById(1);
        ProductCategory productCategory=null;
        if (byId.isPresent()){ //判断是否有
            productCategory=byId.get();
            System.out.println(productCategory);
        }
        productCategory.setCategoryName("锅底");
        productCategoryRepository.save(productCategory);
    }

    @Test //自定义命名规范查询
    public void findByTypeIn(){
        //List<ProductCategory> byCategoryTypeIn = productCategoryRepository
                //.findByCategoryTypeIn(Lists.newArrayList(1, 2, 3));
        //byCategoryTypeIn.stream().forEach(System.out::println);
    }



}
