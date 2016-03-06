package com.easygame.sdk.repository.mapper.backend.market;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.repository.model.dto.backend.market.AppModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.market.AppSearchCriteriaDTO;
import com.easygame.sdk.repository.model.po.App;
import com.easygame.sdk.repository.model.po.AppSequence;
import com.easygame.sdk.repository.model.vo.backend.market.AppShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppTypeShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppVersionShowVO;

/** 应用业务DAO接口 */
public interface AppMapper {

	/** 获取所有应用类型 */
	List<AppTypeShowVO> selectAllAppType();

	/** 检测应用是否重复 */
	int checkIfAppExist(@Param("name") String name, @Param("id") Integer id);

	/** 添加应用 */
	int insertApp(App record);

	/** 根据条件查找应用 */
	List<AppShowVO> selectAppListByCriteria(AppSearchCriteriaDTO criteria);

	/** 返回根据条件查找应用的总数 */
	int getAppListTotalCountByCriteria(AppSearchCriteriaDTO criteria);

	/** 根据ID查找应用 */
	AppModifyDTO selectAppByPrimaryKey(int id);

	/** 更新应用 */
	int updateApp(App record);

	/** 删除检测 */
	int checkAppDeleteSecurity(Integer id);

	/** 删除应用 */
	int deleteApp(int id);

	int deleteAppInformation(int appId);

	int deleteAppImages(int appId);

	/** 添加序列 */
	int insertAppSequence(AppSequence record);

	List<AppVersionShowVO> selectAppVersionListByAppId(@Param("id")int id, @Param("pagination")Page pagination);

}