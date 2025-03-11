package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.entity.product.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {
    List<Category> findByParentId(Long parentId);

}
