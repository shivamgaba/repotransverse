package com.transverse.rbac.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 749353865700647054L;
	private String username;
    private String password;
    private List<RoleDto> roleDtoList = new ArrayList<>();
    private List<ModuleDto> moduleList = new ArrayList<>();
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	

	public List<RoleDto> getRoleDtoList() {
		return roleDtoList;
	}

	public void setRoleDtoList(List<RoleDto> roleDtoList) {
		this.roleDtoList = roleDtoList;
	}

	public List<ModuleDto> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<ModuleDto> moduleList) {
		this.moduleList = moduleList;
	}

   
}
