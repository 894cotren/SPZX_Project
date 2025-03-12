package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.dto.product.ProductDto;
import com.awc20.spzx.model.entity.product.Product;
import com.github.pagehelper.PageInfo;

public interface ProductService {
    PageInfo<Product> findProductByPage(int pageNum, int pageSize, ProductDto productDto);

    void saveProduct(Product product);

    Product getProductById(Long productId);

    void updateById(Product product);

    void updateStatus(Long productId, Integer status);

    void updateAuditStatus(Long productId, Integer auditStatus);
}
