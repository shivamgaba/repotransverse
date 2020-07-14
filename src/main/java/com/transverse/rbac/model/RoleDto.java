package com.transverse.rbac.model;

import java.io.Serializable;

public class RoleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1529830915219556141L;

	private String name;

    private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    
}
