package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.ProductDetailsMapper;
import com.awc20.spzx.manager.mapper.ProductMapper;
import com.awc20.spzx.manager.mapper.ProductSkuMapper;
import com.awc20.spzx.manager.service.ProductService;
import com.awc20.spzx.model.dto.product.ProductDto;
import com.awc20.spzx.model.entity.product.Product;
import com.awc20.spzx.model.entity.product.ProductDetails;
import com.awc20.spzx.model.entity.product.ProductSku;
import com.awc20.spzx.model.entity.product.ProductSpec;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductDetailsMapper productDetailsMapper;

    @Autowired
    ProductSkuMapper productSkuMapper;

    @Override
    public PageInfo<Product> findProductByPage(int pageNum, int pageSize, ProductDto productDto) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productMapper.selectProductByPage(productDto);
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        return pageInfo;
    }

    @Override
    public void saveProduct(Product product) {
        //先保存产品信息，获得自增的主键ID后才能去保存details 和sku
        product.setAuditStatus(0);  //默认待审核
        product.setAuditMessage("商品待审核");  //默认商品待审核
        product.setStatus(0);   //1表示上架


        productMapper.insertProduct(product);
        Long productId=product.getId();
        //组装details对象
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(productId);
        productDetails.setImageUrls(product.getDetailsImageUrls());
        //插入details
        productDetailsMapper.insertDetails(productDetails);
        //插入sku
        List<ProductSku> productSkuList = product.getProductSkuList();
        int i=0;
        for (ProductSku productSku : productSkuList) {
            i++;
            //对一些值进行特殊处理
            productSku.setSkuCode(productId+"_"+i);
            productSku.setSkuName(product.getName()+ " " + productSku.getSkuSpec());
            productSku.setProductId(productId);
            productSkuMapper.insertProductSku(productSku);
        }
    }

    @Override
    public Product getProductById(Long productId) {
        //根据商品ID查询到商品信息
        Product product = productMapper.selectById(productId);
        //根据商品id查询到sku商品规格信息
        List<ProductSku> productSkuList = productSkuMapper.selectByProductId(productId);
        product.setProductSkuList(productSkuList);
        //根据商品id查询到details海报图信息。
        ProductDetails productDetails = productDetailsMapper.selectByProductId(productId);
        product.setDetailsImageUrls(productDetails.getImageUrls());
        return product;
    }

    @Override
    public void updateById(Product product) {
        // 修改商品基本数据
        productMapper.updateById(product);

        // 修改商品的sku数据
        List<ProductSku> productSkuList = product.getProductSkuList();
        for (ProductSku productSku : productSkuList) {
            productSkuMapper.updateById(productSku);
        }

        // 修改商品的详情数据
        ProductDetails productDetails = new ProductDetails();
        productDetails.setImageUrls(product.getDetailsImageUrls());
        productDetails.setProductId(product.getId());
        productDetailsMapper.updateById(productDetails);
    }

    @Override
    public void updateStatus(Long productId, Integer status) {
        productMapper.updateStatus(productId,status);
    }

    @Override
    public void updateAuditStatus(Long productId, Integer auditStatus) {
        String message = auditStatus==1?"审核通过":"审核不通过";
        productMapper.updateAuditStatus(productId,auditStatus,message);
    }
}
