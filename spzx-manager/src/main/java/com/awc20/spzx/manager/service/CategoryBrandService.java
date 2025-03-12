package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.dto.product.CategoryBrandDto;
import com.awc20.spzx.model.entity.product.Brand;
import com.awc20.spzx.model.entity.product.CategoryBrand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CategoryBrandService {
    PageInfo<CategoryBrand> findCategoryBrandByPage(int pageNum, int pageSize, CategoryBrandDto categoryBrandDto);

    void saveCategoryBrand(CategoryBrand categoryBrand);

    List<Brand> findBrandByCategoryId(Long categoryId);
}
