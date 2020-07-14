package com.transverse.rbac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Module implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6620374149728973616L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long mId;
	
	@Column
	private String moduleName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	public Long getmId() {
		return mId;
	}

	public void setmId(Long mId) {
		this.mId = mId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
