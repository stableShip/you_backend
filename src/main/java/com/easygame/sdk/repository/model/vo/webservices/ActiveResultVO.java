package com.easygame.sdk.repository.model.vo.webservices;

public class ActiveResultVO {
	
	private boolean success;
	
	private Integer activeTimeType;
	
	/** 时长 */
	private Integer duration;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getActiveTimeType() {
		return activeTimeType;
	}

	public void setActiveTimeType(Integer activeTimeType) {
		this.activeTimeType = activeTimeType;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
