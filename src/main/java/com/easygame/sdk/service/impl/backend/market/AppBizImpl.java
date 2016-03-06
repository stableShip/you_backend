package com.easygame.sdk.service.impl.backend.market;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.repository.mapper.backend.market.AppMapper;
import com.easygame.sdk.repository.model.dto.backend.market.AppModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.market.AppSearchCriteriaDTO;
import com.easygame.sdk.repository.model.po.App;
import com.easygame.sdk.repository.model.po.AppSequence;
import com.easygame.sdk.repository.model.vo.backend.market.AppShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppTypeShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppVersionShowVO;
import com.easygame.sdk.service.api.backend.market.IAppBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "appBiz")
public class AppBizImpl extends BaseBizImpl implements IAppBiz {

	@Autowired
	private AppMapper appMapper;

	public List<AppTypeShowVO> selectAllAppType() {
		return appMapper.selectAllAppType();
	}

	public int insertApp(AppModifyDTO record) {
		App app = new App();
		app.setName(record.getName());
		app.setType(record.getTypeId());
		app.setStatus((byte) 0);
		app.setCreationDate(new Date());
		app.setLastUpdateDate(new Date());
		appMapper.insertApp(app);

		AppSequence appSequence = new AppSequence();
		appSequence.setAppId(app.getId());
		appSequence.setNextVal(1);
		return appMapper.insertAppSequence(appSequence);
	}

	public List<AppShowVO> selectAppListByCriteria(AppSearchCriteriaDTO criteria) {
		return appMapper.selectAppListByCriteria(criteria);
	}

	public int getAppListTotalCountByCriteria(AppSearchCriteriaDTO criteria) {
		return appMapper.getAppListTotalCountByCriteria(criteria);
	}

	public AppModifyDTO selectAppForUpdate(int id) {
		return appMapper.selectAppByPrimaryKey(id);
	}

	public int updateApp(AppModifyDTO record) {
		App app = new App();
		app.setId(record.getId());
		app.setName(record.getName());
		app.setType(record.getTypeId());
		app.setLastUpdateDate(new Date());
		return appMapper.updateApp(app);
	}

	public int deleteApp(int id) {
		if (appMapper.checkAppDeleteSecurity(id) > 0) {
			return 0;
		}
		return appMapper.deleteApp(id);
	}

	public int checkAppDuplication(String name, Integer id) {
		return appMapper.checkIfAppExist(name, id);
	}

	public List<AppVersionShowVO> selectAppVersionListByAppId(int id,
			Page pagination) {
		return appMapper.selectAppVersionListByAppId(id, pagination);
	}

}
