package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.entity.product.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> selectCategoryByParentId(Long parentId);

    Long countChildren(Long parentId);
}
