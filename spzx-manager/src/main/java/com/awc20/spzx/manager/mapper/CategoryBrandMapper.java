package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.dto.product.CategoryBrandDto;
import com.awc20.spzx.model.entity.product.Brand;
import com.awc20.spzx.model.entity.product.CategoryBrand;

import java.util.List;

public interface CategoryBrandMapper {
    List<CategoryBrand> selectCategoryBrandByPage(CategoryBrandDto categoryBrandDto);

    void insertCategoryBrand(CategoryBrand categoryBrand);

    List<Brand> selectBrandByCategoryId(Long categoryId);
}
