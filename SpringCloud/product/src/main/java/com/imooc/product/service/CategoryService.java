package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
