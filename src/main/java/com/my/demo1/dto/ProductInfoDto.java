package com.my.demo1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.my.demo1.entity.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto implements Serializable {

    //返回的json属性名与属性名不一致时，转换属性名
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;

    public static ProductInfoDto build(ProductInfo productInfo){
        ProductInfoDto productInfoDto=new ProductInfoDto();
        BeanUtils.copyProperties(productInfo,productInfoDto);
        return productInfoDto;
    }
}
