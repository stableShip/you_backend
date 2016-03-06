package com.easygame.sdk.repository.model.dto.webservices;

import java.io.Serializable;

public class ActiveCountInOneDayResultDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String today;

	private Integer activeCount;

	private Integer secondActiveCount;

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public Integer getActiveCount() {
		return activeCount;
	}

	public void setActiveCount(Integer activeCount) {
		this.activeCount = activeCount;
	}

	public Integer getSecondActiveCount() {
		return secondActiveCount;
	}

	public void setSecondActiveCount(Integer secondActiveCount) {
		this.secondActiveCount = secondActiveCount;
	}

}
