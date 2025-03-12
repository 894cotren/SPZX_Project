package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.CategoryBrandService;
import com.awc20.spzx.model.dto.product.CategoryBrandDto;
import com.awc20.spzx.model.entity.product.Brand;
import com.awc20.spzx.model.entity.product.CategoryBrand;
import com.awc20.spzx.model.vo.common.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product/categoryBrand")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService;

    @GetMapping("/{pageNum}/{pageSize}")
    public Result<PageInfo<CategoryBrand>> findCategoryBrandByPage(@PathVariable int pageNum, @PathVariable int pageSize,
                                                                   CategoryBrandDto categoryBrandDto){
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findCategoryBrandByPage(pageNum,pageSize,categoryBrandDto);
        return Result.ok(pageInfo);
    }

    @PostMapping("/save")
    public Result save(@RequestBody CategoryBrand categoryBrand){
        categoryBrandService.saveCategoryBrand(categoryBrand);
        return Result.ok(null);
    }


    @GetMapping("/findBrandByCategoryId/{categoryId}")
    public Result<List<Brand>> findBrandByCategoryId(@PathVariable Long categoryId){
        List<Brand> brandList = categoryBrandService.findBrandByCategoryId(categoryId);
        return  Result.ok(brandList);
    }

/*    @PutMapping("updateById")
    public Result updateById(@RequestBody CategoryBrand categoryBrand) {
        System.out.println("updateById被调用了");
        System.out.println(categoryBrand);
        return Result.ok(null);
    }*/


}
