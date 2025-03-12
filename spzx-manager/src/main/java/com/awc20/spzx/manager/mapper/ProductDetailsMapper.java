package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.entity.product.ProductDetails;

public interface ProductDetailsMapper {
    void insertDetails(ProductDetails productDetails);

    ProductDetails selectByProductId(Long productId);

    void updateById(ProductDetails productDetails);
}
