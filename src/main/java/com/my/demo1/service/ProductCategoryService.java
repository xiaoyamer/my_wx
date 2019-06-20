package com.my.demo1.service;

import com.my.demo1.common.ResultResponse;
import com.my.demo1.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {
    ResultResponse<List<ProductCategoryDto>> findAll();
}
