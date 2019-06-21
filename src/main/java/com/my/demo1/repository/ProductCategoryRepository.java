package com.my.demo1.repository;

import com.my.demo1.common.ResultResponse;
import com.my.demo1.dto.ProductCategoryDto;
import com.my.demo1.entity.ProductCategory;
import com.my.demo1.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//第一个参数是实体类名称，第二个是主键类型，JpaRepository提供常用的增删查改的方法
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    //根据类型列表查询
    //List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList);

    /*@Query(value = "select category_name " +
            "from produce_category " +
            "where category_id=?1 and category_type=?2",
            nativeQuery = true)*/
    //?1表示第一个参数，?2表示第二个参数，nativeQuery表示用sql查
    //List<String> queryNameByCategoryIdAndCategoryType(Integer id,Integer type);

    /*@Query(value = "select category_name " +
            "from product_category " +
            "where category_id=:ids and category_type=:type",
            nativeQuery = true)
    List<String> queryNameByCategoryIdAndCategoryType(@Param("ids") Integer id,Integer type);*/
    //参数名称相同可以省略@Param注解
    //参数名称相同：前端传来的参数名和方法的参数名相同
    //List<String> queryNameByCategoryIdAndCategoryType(Integer ids,Integer type);

    //由于会默认提供基本增删查改，这里包括findAll（），
    // 所以不用写此方法，在调用此方法时系统会自动找到此方法
    //List<ProductCategory> findAll();
}
