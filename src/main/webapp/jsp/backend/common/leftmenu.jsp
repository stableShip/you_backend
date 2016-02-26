<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="taglibs.jsp"%>
&nbsp;<br /><br /><br /><br /><br /><br /><br /><br /><br />
<div id="profile-links" >
	<spring:message code="backend.index.hello" />, 
	<a href="<%=request.getContextPath()%>/backend/general/informationController/informationUpdatePage.do" title="<spring:message code="backend.index.editProfile" />">${account.name}</a><br /><br />
	<a href="<%=request.getContextPath()%>/backend/loginAndLogoutController/logout.do" title="<spring:message code="backend.index.logout" />"><spring:message code="backend.index.logout" /></a>
</div>
<ul id="main-nav">
	<c:if test="${adStatisticsPermission != 0 || adConsolePermission != 0 || batchPermission != 0 || notificationAdPermission != 0 || bannerAdPermission != 0 || screenAdPermission != 0 || gamecenterAdPermission != 0}">
		<li><a href="#" class="nav-top-item <c:if test="${currentPage eq 'batchPermission' || currentPage eq 'notificationAdPermission' || currentPage eq 'bannerAdPermission' || currentPage eq 'screenAdPermission' || currentPage eq 'gamecenterAdPermission' || currentPage eq 'adStatisticsPermission' || currentPage eq 'adConsolePermission'}">current</c:if>" >广告管理</a>
			<ul>
				<c:if test="${adStatisticsPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/ad/adStatisticsController/adStatisticsList.do" <c:if test="${currentPage eq 'adStatisticsPermission'}">class="current"</c:if>>广告统计</a></li>
				</c:if>
				<c:if test="${adConsolePermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/ad/adConsoleController/adConsole.do" <c:if test="${currentPage eq 'adConsolePermission'}">class="current"</c:if>>总台设置</a></li>
				</c:if>
				<c:if test="${batchPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/ad/batchController/batchList.do" <c:if test="${currentPage eq 'batchPermission'}">class="current"</c:if>>批次设置</a></li>
				</c:if>
				<c:if test="${notificationAdPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/ad/notificationAdController/notificationAdList.do" <c:if test="${currentPage eq 'notificationAdPermission'}">class="current"</c:if>>通知栏广告设置</a></li>
				</c:if>
				<c:if test="${bannerAdPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/ad/bannerAdController/bannerAdList.do" <c:if test="${currentPage eq 'bannerAdPermission'}">class="current"</c:if>>Banner广告设置</a></li>
				</c:if>
				<c:if test="${screenAdPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/ad/screenAdController/screenAdList.do" <c:if test="${currentPage eq 'screenAdPermission'}">class="current"</c:if>>插屏广告设置</a></li>
				</c:if>
				<c:if test="${gamecenterAdPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/ad/gamecenterAdController/gamecenterAdList.do" <c:if test="${currentPage eq 'gamecenterAdPermission'}">class="current"</c:if>>游戏中心广告设置</a></li>
				</c:if>
			</ul>
		</li>
	</c:if>
	<c:if test="${appPermission != 0}">
		<li>
			<a href="#" class="nav-top-item <c:if test="${currentPage eq 'appPermission'}">current</c:if>"><spring:message code="backend.leftmenu.settings.app" /></a>
			<ul>
				<c:if test="${appPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/market/appController/appList.do?pagination.currentPage=1" <c:if test="${currentPage eq 'appPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.app.app" /></a></li>
				</c:if>
			</ul>
		</li>
	</c:if>
	<c:if test="${rolePermission != 0 || cpaPromotionPermission != 0 || cpaPromotionLogPermission != 0 || channelPermission != 0 || cpaPromotionStatisticsPermission != 0}">
		<li><a href="#" class="nav-top-item <c:if test="${currentPage eq 'cpaPromotionPermission' || currentPage eq 'cpaPromotionLogPermission' || currentPage eq 'channelPermission' || currentPage eq 'cpaPromotionStatisticsPermission'}">current</c:if>"><spring:message code="backend.leftmenu.settings.statistics" /></a>
			<ul>
				<c:if test="${cpaPromotionStatisticsPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/channel/cpaPromotionStatisticsController/cpaPromotionStatisticsList.do?pagination.currentPage=1" <c:if test="${currentPage eq 'cpaPromotionStatisticsPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.statistics.promotionStatistics" /></a></li>
				</c:if>
				<c:if test="${channelPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/channel/channelController/findChannel.do?pagination.currentPage=1" <c:if test="${currentPage eq 'channelPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.statistics.channel" /></a></li>
				</c:if>
				<c:if test="${cpaPromotionPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/channel/cpaPromotionController/cpaPromotionList.do?pagination.currentPage=1" <c:if test="${currentPage eq 'cpaPromotionPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.statistics.promotion" /></a></li>
				</c:if>
				<c:if test="${cpaPromotionLogPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/channel/cpaPromotionLogController/cpaPromotionLogList.do?pagination.currentPage=1" <c:if test="${currentPage eq 'cpaPromotionLogPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.statistics.promotionLog" /></a></li>
				</c:if>
			</ul>
		</li>
	</c:if>
	<li><a href="#" class="nav-top-item <c:if test="${currentPage eq 'companyPermission' || currentPage eq 'accountPermission' || currentPage eq 'passwordPermission' || currentPage eq 'informationPermission' || currentPage eq 'rolePermission'}">current</c:if>"><spring:message code="backend.leftmenu.settings.general" /></a>
		<ul>
			<c:if test="${companyPermission != 0}">
				<li><a href="<%=request.getContextPath()%>/backend/general/companyController/companyList.do?pagination.currentPage=1" <c:if test="${currentPage eq 'companyPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.general.company" /></a></li>
			</c:if>
			<c:if test="${rolePermission != 0}">
				<li><a href="<%=request.getContextPath()%>/backend/general/roleController/roleList.do" <c:if test="${currentPage eq 'rolePermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.general.role" /></a></li>
			</c:if>
			<c:if test="${accountPermission != 0}">
				<li><a href="<%=request.getContextPath()%>/backend/general/accountController/accountList.do?pagination.currentPage=1" <c:if test="${currentPage eq 'accountPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.general.account" /></a></li>
			</c:if>
			<li>
				<a href="<%=request.getContextPath()%>/backend/general/passwordController/passwordUpdatePage.do" <c:if test="${currentPage eq 'passwordPermission'}">class="current"</c:if>>修改密码</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/backend/general/informationController/informationUpdatePage.do" <c:if test="${currentPage eq 'informationPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.general.editProfile" /></a>
			</li>
		</ul>
	</li>

	<c:if test="${glazePermission != 0}">
		<li>
			<a href="#" class="nav-top-item <c:if test="${currentPage eq 'glazePermission'}">current</c:if>"><spring:message code="backend.leftmenu.settings.glaze" /></a>
			<ul>
				<c:if test="${glazePermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/glaze/baseGlazeController/findBaseGlaze.do?pagination.currentPage=1" <c:if test="${currentPage eq 'glazePermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.glaze.base_glaze" /></a></li>
				</c:if>
				<c:if test="${glazePermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/market/appController/appList.do?pagination.currentPage=1" <c:if test="${currentPage eq 'glazePermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.glaze.sample_glaze" /></a></li>
				</c:if>
			</ul>
		</li>
	</c:if>

</ul>