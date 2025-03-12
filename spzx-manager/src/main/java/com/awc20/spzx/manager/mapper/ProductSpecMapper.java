package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.entity.product.ProductSpec;

import java.util.List;

public interface ProductSpecMapper {
    List<ProductSpec> selectProductSpecByPage();

    void insertProductSpec(ProductSpec productSpec);

    void updateProductSpecById(ProductSpec productSpec);

    List<ProductSpec> selectAllProductSpec();

}
