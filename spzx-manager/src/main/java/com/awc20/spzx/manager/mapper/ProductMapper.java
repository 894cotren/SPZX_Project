package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.dto.product.ProductDto;
import com.awc20.spzx.model.entity.product.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> selectProductByPage(ProductDto productDto);

    int insertProduct(Product product);

    Product selectById(Long productId);

    void updateById(Product product);

    void updateStatus(Long productId, Integer status);

    void updateAuditStatus(Long productId, Integer auditStatus, String message);
}
