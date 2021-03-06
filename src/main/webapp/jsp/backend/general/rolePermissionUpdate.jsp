<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="backend.login.title" /></title>
<jsp:include page="../common/common.jsp" flush="true" />
</head>
<body>
	<div id="body-wrapper">
		<div id="sidebar">
			<div id="sidebar-wrapper">
				<%@include file="../common/leftmenu.jsp"%>
			</div>
		</div>
		<div id="main-content">
			<div class="clear"></div>
			<div class="content-box">
				<div class="content-box-header">
					<h3><spring:message code="backend.role.update.title" />:${role.name}</h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<form name="role" action="<%=request.getContextPath()%>/backend/general/roleController/rolePermissionUpdate.do" method="post">
							<fieldset>
								<p>
									<label>角色类型</label>
									<input type="hidden" name="id" value="${role.id}" />
									<input type="radio" name="isInternal" value="1" checked="checked" <c:if test="${role.isInternal == true}">checked="checked"</c:if> />
									内部
									<input type="radio" name="isInternal" value="0" <c:if test="${role.isInternal == false}">checked="checked"</c:if> />
									外部
								</p>
							</fieldset>
							<table>
								<thead>
									<tr>
										<th><spring:message code="backend.role.update.label.permission.column.function" /></th>
										<th><spring:message code="backend.role.update.label.permission.column.none" /></th>
										<th><spring:message code="backend.role.update.label.permission.column.readable" /></th>
										<th><spring:message code="backend.role.update.label.permission.column.writable" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="p" items="${role.permissions}" varStatus="status">
										<tr>
											<td><input type="hidden" name="permissions[${status.index}].pageDesc" value="${p.pageDesc}" />${p.pageDesc}</td>
											<td><input type="hidden" name="permissions[${status.index}].id" value="${p.id}" /><input type="radio" name="permissions[${status.index}].permissionLevel" value="0" <c:if test="${p.permissionLevel == 0}">checked="checked"</c:if> /></td>
											<td><input type="radio" name="permissions[${status.index}].permissionLevel" value="1" <c:if test="${p.permissionLevel == 1}">checked="checked"</c:if> /></td>
											<td><input type="radio" name="permissions[${status.index}].permissionLevel" value="2" <c:if test="${p.permissionLevel == 2}">checked="checked"</c:if> /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<p>
								<input class="button" type="submit" value="<spring:message code="backend.form.button.update" />" />
							</p>
						</form>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<%@include file="../common/footer.jsp"%>
		</div>
	</div>
</body>
</html>