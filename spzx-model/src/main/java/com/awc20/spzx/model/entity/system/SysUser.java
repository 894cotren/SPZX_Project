package com.awc20.spzx.model.entity.system;

import com.awc20.spzx.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = 1L;
	//如果名称显示不出来，那么这里得改成userName
	private String username;  // 该字段的属性名称和数据表字段不一致
	private String password;
	private String name;
	private String phone;
	private String avatar;
	private String description;
	private Integer status;

}