package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.ProductUnitMapper;
import com.awc20.spzx.manager.service.ProductUnitService;
import com.awc20.spzx.model.entity.product.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUnitServiceImpl implements ProductUnitService {

    @Autowired
    ProductUnitMapper productUnitMapper;

    @Override
    public List<ProductUnit> findAllProductUnit() {

        List<ProductUnit> productUnitList =  productUnitMapper.selectAllProductUnit();
        return productUnitList;
    }
}
