package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.entity.product.Brand;
import com.github.pagehelper.PageInfo;

public interface BrandService {
    PageInfo<Brand> findBrandByPage(int pageNum, int pageSize);

    void save(Brand brand);

    void updateById(Brand brand);
}
