package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.CategoryMapper;
import com.awc20.spzx.manager.service.CategoryService;
import com.awc20.spzx.model.entity.product.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> findByParentId(Long parentId) {
        List<Category> categoryList = categoryMapper.selectCategoryByParentId(parentId);
        //private Boolean hasChildren; 属性里有条是否有子节点，所以我们这里需要查询并赋值上去，
        // 方便前端设置，以便前端为有孩子节点的节点设置二次查询。
        for (Category category : categoryList) {
            Long count= categoryMapper.countChildren(category.getId());
            if (count>0){
                category.setHasChildren(true);
            }else {
                category.setHasChildren(false);
            }
        }
        return categoryList;
    }


}
