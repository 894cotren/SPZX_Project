package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.ProductService;
import com.awc20.spzx.model.dto.product.ProductDto;
import com.awc20.spzx.model.entity.product.Product;
import com.awc20.spzx.model.vo.common.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/admin/product/product")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{pageNum}/{pageSize}")
    public Result<PageInfo<Product>> findProductByPage(@PathVariable int pageNum,@PathVariable int pageSize
            ,ProductDto productDto){
        PageInfo<Product> pageInfo =  productService.findProductByPage(pageNum,pageSize,productDto);
        return Result.ok(pageInfo);
    }



    @PostMapping("/save")
    public Result saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return  Result.ok(null);
    }

    @GetMapping("/getById/{productId}")
    public Result<Product> getProductById(@PathVariable Long productId){
        Product product= productService.getProductById(productId);
        return Result.ok(product);
    }

    @PutMapping("updateById")
    public Result updateById(@RequestBody Product product){
        productService.updateById(product);
        return Result.ok(null);
    }


    /***
     * 修改商品的上下架
     * @param productId
     * @param status
     * @return
     */
    @GetMapping("updateStatus/{productId}/{status}")
    public Result updateStatus(@PathVariable Long productId, @PathVariable Integer status) {
        productService.updateStatus(productId, status);
        return Result.ok(null);
    }

    /***
     * 修改商品的审批
     * @param productId
     * @param auditStatus
     * @return
     */
    @GetMapping("updateAuditStatus/{productId}/{auditStatus}")
    public Result updateAuditStatus(@PathVariable Long productId, @PathVariable Integer auditStatus) {
        productService.updateAuditStatus(productId, auditStatus);
        return Result.ok(null);
    }

}