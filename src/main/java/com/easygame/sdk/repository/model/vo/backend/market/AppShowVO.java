package com.easygame.sdk.repository.model.vo.backend.market;

import java.io.Serializable;

public class AppShowVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Integer status;

	private String appTypeName;
	
	private Integer hasNotification;

	private Integer notificationSelected;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAppTypeName() {
		return appTypeName;
	}

	public void setAppTypeName(String appTypeName) {
		this.appTypeName = appTypeName;
	}

	public Integer getHasNotification() {
		return hasNotification;
	}

	public void setHasNotification(Integer hasNotification) {
		this.hasNotification = hasNotification;
	}

	public Integer getNotificationSelected() {
		return notificationSelected;
	}

	public void setNotificationSelected(Integer notificationSelected) {
		this.notificationSelected = notificationSelected;
	}
	
}
