package com.my.demo1.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
//@Table(name="product_info") 默认规则：去掉下划线首字母大写可不用指定
public class ProductInfo {
    @Id
    private String productId;

    private String productName; //商品名称
    private BigDecimal productPrice; //单价
    private Integer productStock; //库存
    private String productDescription; //描述
    private String productIcon; //小图
    private Integer productStaus; //商品状态，0：正常，1：下架
    private Integer categoryType;
    private Date categoryTime;
    private Date updateTime;
}
