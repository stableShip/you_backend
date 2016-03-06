package com.easygame.sdk.service.api.backend.market;

import java.util.List;

import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.repository.model.dto.backend.market.AppModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.market.AppSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.market.AppShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppTypeShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppVersionShowVO;

/** 应用业务接口 */
public interface IAppBiz {

	/** 重复应用检测 */
	int checkAppDuplication(String name, Integer id);

	/** 获取所有应用类型 */
	public List<AppTypeShowVO> selectAllAppType();

	/** 添加应用 */
	public int insertApp(AppModifyDTO record);

	/** 根据条件查找应用 */
	public List<AppShowVO> selectAppListByCriteria(AppSearchCriteriaDTO criteria);

	/** 返回根据条件查找应用的总数 */
	public int getAppListTotalCountByCriteria(AppSearchCriteriaDTO criteria);

	/** 根据ID查找应用 */
	public AppModifyDTO selectAppForUpdate(int id);

	/** 更新应用 */
	public int updateApp(AppModifyDTO record);

	/** 删除应用 */
	public int deleteApp(int id);
	
	public List<AppVersionShowVO> selectAppVersionListByAppId(int id, Page pagination);
}
