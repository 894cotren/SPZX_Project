package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.BrandService;
import com.awc20.spzx.model.entity.product.Brand;
import com.awc20.spzx.model.vo.common.Result;
import com.github.pagehelper.PageInfo;
import org.ehcache.spi.resilience.ResilienceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/product/brand")
@RestController
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class BrandController {

    @Autowired
    BrandService brandService;


    @GetMapping("/{pageNum}/{pageSize}")
    public Result<PageInfo<Brand>> findBrandByPage(@PathVariable int pageNum,@PathVariable int pageSize){
        PageInfo<Brand> pageInfo=  brandService.findBrandByPage(pageNum,pageSize);
        return  Result.ok(pageInfo);
    }


    @PostMapping("save")
    public Result save(@RequestBody Brand brand) {
        brandService.save(brand);
        return Result.ok(null);
    }

    @PutMapping("updateById")
    public Result updateById(@RequestBody Brand brand){
        brandService.updateById(brand);
        return Result.ok(null);
    }

    @GetMapping("/findAll")
    public Result<List<Brand>> findAllBrand(){
        List<Brand> list= brandService.findAllBrand();
        return Result.ok(list);
    }


}
