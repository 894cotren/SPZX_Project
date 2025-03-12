package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.CategoryBrandMapper;
import com.awc20.spzx.manager.service.CategoryBrandService;
import com.awc20.spzx.model.dto.product.CategoryBrandDto;
import com.awc20.spzx.model.entity.product.Brand;
import com.awc20.spzx.model.entity.product.CategoryBrand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Autowired
    CategoryBrandMapper categoryBrandMapper;

    @Override
    public PageInfo<CategoryBrand> findCategoryBrandByPage(int pageNum, int pageSize, CategoryBrandDto categoryBrandDto) {
        PageHelper.startPage(pageNum,pageSize);
        List<CategoryBrand> categoryBrandList = categoryBrandMapper.selectCategoryBrandByPage(categoryBrandDto);
        PageInfo<CategoryBrand> pageInfo = new PageInfo<>(categoryBrandList);
        return pageInfo;
    }

    @Override
    public void saveCategoryBrand(CategoryBrand categoryBrand) {
        categoryBrandMapper.insertCategoryBrand(categoryBrand);
    }

    @Override
    public List<Brand> findBrandByCategoryId(Long categoryId) {
        List<Brand>  brandList=  categoryBrandMapper.selectBrandByCategoryId(categoryId);
        return brandList;
    }
}
