package com.transverse.rbac.model;

import java.io.Serializable;

public class ModuleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3372687821307445657L;
	private String moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
}
