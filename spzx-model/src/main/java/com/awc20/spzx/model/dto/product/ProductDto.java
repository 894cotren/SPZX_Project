package com.awc20.spzx.model.dto.product;

import com.awc20.spzx.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class ProductDto extends BaseEntity {

    private Long brandId;
    private Long category1Id;
    private Long category2Id;
    private Long category3Id;

}