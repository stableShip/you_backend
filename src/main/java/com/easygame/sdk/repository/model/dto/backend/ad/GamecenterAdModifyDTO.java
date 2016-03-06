package com.easygame.sdk.repository.model.dto.backend.ad;

import com.easygame.sdk.repository.model.po.GamecenterAd;

public class GamecenterAdModifyDTO extends GamecenterAd {
    /**
     * 保存未更改前的showIndex属性
     */
    private Integer originalIndex;

    public Integer getOriginalIndex() {
        return originalIndex;
    }

    public void setOriginalIndex(Integer originalIndex) {
        this.originalIndex = originalIndex;
    }



  
}
