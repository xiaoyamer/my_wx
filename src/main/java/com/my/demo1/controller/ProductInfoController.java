package com.my.demo1.controller;

import com.my.demo1.common.ResultResponse;
import com.my.demo1.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buyer/product")
//对类的描述
@Api(description = "商品信息接口")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("list")
    //对方法接口进行描述
    @ApiOperation(value = "查询商品信息列表")
    public ResultResponse list(){
        return productInfoService.queryList();
    }

}
