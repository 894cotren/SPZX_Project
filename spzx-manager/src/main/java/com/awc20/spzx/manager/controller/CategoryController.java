package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.CategoryService;
import com.awc20.spzx.model.entity.product.Category;
import com.awc20.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin/product/category")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("findByParentId/{parentId}")
    public Result<List<Category>> findByParentId(@PathVariable Long parentId){
        List<Category> categoryList= categoryService.findByParentId(parentId);
        return Result.ok(categoryList);
    }


}
