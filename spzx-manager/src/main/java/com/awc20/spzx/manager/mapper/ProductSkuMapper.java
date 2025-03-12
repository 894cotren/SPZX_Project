package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.entity.product.ProductSku;

import java.util.List;

public interface ProductSkuMapper {
    void insertProductSku(ProductSku productSku);

    List<ProductSku> selectByProductId(Long productId);

    void updateById(ProductSku productSku);
}
