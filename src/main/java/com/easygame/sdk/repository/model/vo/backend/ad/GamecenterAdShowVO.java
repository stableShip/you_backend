package com.easygame.sdk.repository.model.vo.backend.ad;

public class GamecenterAdShowVO {
    	
	
	private String iconUrl;
	
	private Integer id;
	
	private String name;

	private String promotionWord;
	
	private String showIndex;

	public String getShowIndex() {
	    return showIndex;
	}

	public void setShowIndex(String showIndex) {
	    this.showIndex = showIndex;
	}



	public String getIconUrl() {
	    return iconUrl;
	}

	public Integer getId() {
	    return id;
	}

	public String getName() {
	    return name;
	}

	public String getPromotionWord() {
	    return promotionWord;
	}

	public void setIconUrl(String iconUrl) {
	    this.iconUrl = iconUrl;
	}

	public void setId(Integer id) {
	    this.id = id;
	}

	public void setName(String name) {
	    this.name = name;
	}
		
	public void setPromotionWord(String promotionWord) {
	    this.promotionWord = promotionWord;
	}
	
}
