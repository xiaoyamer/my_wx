package com.my.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@DynamicUpdate //设置为true，表示update对象的时候，生成动态的update语句，
                    // 如果这个字段的值是null，就不会加到update语句中
@Data  //相当于set、get、toString方法
@Table(name = "product_category") //表名
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 表示自增identity
    private Integer categoryId;
    //类目名字
    private String categoryName;
    //类目编号
    private Integer categoryType;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

}
