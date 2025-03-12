package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.entity.product.ProductSpec;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductSpecService {
    PageInfo<ProductSpec> findProductSpecByPage(int pageNum, int pageSize);

    void save(ProductSpec productSpec);

    void updateById(ProductSpec productSpec);

    List<ProductSpec> findAllProductSpec();
}
