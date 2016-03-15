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
	<li><a href="#" class="nav-top-item <c:if test="${currentPage eq 'accountPermission' || currentPage eq 'passwordPermission' || currentPage eq 'informationPermission' || currentPage eq 'rolePermission'}">current</c:if>"><spring:message code="backend.leftmenu.settings.general" /></a>
		<ul>

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

	<c:if test="${baseGlazePermission != 0 || sampleGlazePermission != 0 || productOrderPermission != 0 }">
		<li>
			<a href="#" class="nav-top-item <c:if test="${currentPage eq 'baseGlazePermission' || currentPage eq 'sampleGlazePermission' || currentPage eq 'productOrderPermission'}">current</c:if>"><spring:message code="backend.leftmenu.settings.glaze" /></a>
			<ul>
				<c:if test="${glazePermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/glaze/baseGlazeController/findBaseGlaze.do?pagination.currentPage=1" <c:if test="${currentPage eq 'baseGlazePermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.glaze.base_glaze" /></a></li>
				</c:if>
				<c:if test="${glazePermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/glaze/sampleGlazeController/findSampleGlaze.do?pagination.currentPage=1" <c:if test="${currentPage eq 'sampleGlazePermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.glaze.sample_glaze" /></a></li>
				</c:if>
				<c:if test="${glazePermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/glaze/productOrderController/findProductOrder.do?pagination.currentPage=1" <c:if test="${currentPage eq 'productOrderPermission'}">class="current"</c:if>>投料单管理</a></li>
				</c:if>
			</ul>
		</li>
	</c:if>

    <c:if test="${companyPermission != 0}">
        <li>
            <a href="#" class="nav-top-item <c:if test="${currentPage eq 'companyPermission'}">current</c:if>">客户管理</a>
            <ul>
                <c:if test="${companyPermission != 0}">
                    <li><a href="<%=request.getContextPath()%>/backend/general/companyController/companyList.do?pagination.currentPage=1" <c:if test="${currentPage eq 'companyPermission'}">class="current"</c:if>><spring:message code="backend.leftmenu.settings.general.company" /></a></li>
                </c:if>
            </ul>
        </li>
    </c:if>

	<c:if test="${tonerPermission != 0}">
		<li>
			<a href="#" class="nav-top-item <c:if test="${currentPage eq 'tonerPermission'}">current</c:if>">色料管理</a>
			<ul>
				<c:if test="${tonerPermission != 0}">
					<li><a href="<%=request.getContextPath()%>/backend/toner/tonerController/findToner.do?pagination.currentPage=1" <c:if test="${currentPage eq 'tonerPermission'}">class="current"</c:if>>色料设置</a></li>
				</c:if>
			</ul>
		</li>
	</c:if>

</ul>