package com.awc20.spzx.model.entity.product;

import com.awc20.spzx.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class Brand extends BaseEntity {

	private String name;
	private String logo;

}