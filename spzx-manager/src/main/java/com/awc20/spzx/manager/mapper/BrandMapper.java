package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.entity.product.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectBrandByPage();

    void insertBrand(Brand brand);

    void updateById(Brand brand);
}
