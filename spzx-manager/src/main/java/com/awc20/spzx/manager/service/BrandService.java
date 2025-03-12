package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.entity.product.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {
    PageInfo<Brand> findBrandByPage(int pageNum, int pageSize);

    void save(Brand brand);

    void updateById(Brand brand);

    List<Brand> findAllBrand();
}
