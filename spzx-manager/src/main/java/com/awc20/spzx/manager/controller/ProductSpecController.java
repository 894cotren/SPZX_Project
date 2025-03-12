package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.ProductSpecService;
import com.awc20.spzx.model.entity.product.ProductSpec;
import com.awc20.spzx.model.vo.common.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.SocketHandler;


@RestController
@RequestMapping(value="/admin/product/productSpec")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class ProductSpecController {

    @Autowired
    ProductSpecService productSpecService;

    @GetMapping("/{pageNum}/{pageSize}")
    public Result<PageInfo<ProductSpec>> findByPage(@PathVariable int pageNum,@PathVariable int pageSize){
        PageInfo<ProductSpec> pageInfo = productSpecService.findProductSpecByPage(pageNum,pageSize);
        return Result.ok(pageInfo);
    }


    @PostMapping("/save")
    public Result save(@RequestBody ProductSpec productSpec){
        productSpecService.save(productSpec);
        return Result.ok(null);
    }


    @PutMapping("/updateById")
    public Result updateById(@RequestBody ProductSpec productSpec){
        productSpecService.updateById(productSpec);
        return Result.ok(null);
    }

    @GetMapping("/findAllProductSpec")
    public Result<List<ProductSpec>> findAllProductSpec(){
        List<ProductSpec> productSpecList = productSpecService.findAllProductSpec();
        return  Result.ok(productSpecList);
    }
}
