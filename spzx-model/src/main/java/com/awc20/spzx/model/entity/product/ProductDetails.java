package com.awc20.spzx.model.entity.product;

import com.awc20.spzx.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class ProductDetails extends BaseEntity {

	private Long productId;
	private String imageUrls;

}