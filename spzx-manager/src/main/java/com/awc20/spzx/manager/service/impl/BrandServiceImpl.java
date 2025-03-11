package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.BrandMapper;
import com.awc20.spzx.manager.service.BrandService;
import com.awc20.spzx.model.entity.product.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageInfo<Brand> findBrandByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Brand> brandList = brandMapper.selectBrandByPage();
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return pageInfo;
    }

    @Override
    public void save(Brand brand) {
        //此处不考虑查重
        brandMapper.insertBrand(brand);
    }

    @Override
    public void updateById(Brand brand) {
        brandMapper.updateById(brand);
    }
}
