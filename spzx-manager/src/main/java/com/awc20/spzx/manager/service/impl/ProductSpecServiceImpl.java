package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.ProductSpecMapper;
import com.awc20.spzx.manager.service.ProductSpecService;
import com.awc20.spzx.model.entity.product.ProductSpec;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSpecServiceImpl implements ProductSpecService {

    @Autowired
    ProductSpecMapper productSpecMapper;

    @Override
    public PageInfo<ProductSpec> findProductSpecByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductSpec> productSpecList = productSpecMapper.selectProductSpecByPage();
        PageInfo<ProductSpec> pageInfo = new PageInfo<>(productSpecList);
        return pageInfo;
    }

    @Override
    public void save(ProductSpec productSpec) {
        productSpecMapper.insertProductSpec(productSpec);
    }

    @Override
    public void updateById(ProductSpec productSpec) {
        productSpecMapper.updateProductSpecById(productSpec);
    }

    @Override
    public List<ProductSpec> findAllProductSpec() {
        List<ProductSpec> productSpecList = productSpecMapper.selectAllProductSpec();
        return productSpecList;
    }
}
