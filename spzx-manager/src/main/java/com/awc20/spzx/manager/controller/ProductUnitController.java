package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.ProductUnitService;
import com.awc20.spzx.model.entity.product.ProductUnit;
import com.awc20.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/admin/product/productUnit/")
@RestController
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class ProductUnitController {

    @Autowired
    ProductUnitService productUnitService;

    @GetMapping("/findAll")
    public Result<List<ProductUnit>> findAllProductUnit(){
        List<ProductUnit> productUnitList = productUnitService.findAllProductUnit();
        return Result.ok(productUnitList);
    }
}
