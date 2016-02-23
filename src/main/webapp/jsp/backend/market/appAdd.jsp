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
					<h3><spring:message code="backend.app.add.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.app.add.alert" /></div>
						</div>
						<c:if test="${errors != null}">
							<div class="notification error png_bg">
								<div>
									<c:forEach var="e" items="${errors}">
										<c:out value="${e.defaultMessage}" /> <br />
									</c:forEach>
								</div>
							</div>
						</c:if>
						<form name="app" action="<%=request.getContextPath()%>/backend/market/appController/appAdd.do" method="post" enctype="multipart/form-data">
							<fieldset>
								<p>
									<label><spring:message code="backend.app.add.label.name" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="name" value="${app.name}" data-validation="required" data-validation-error-msg="应用名称不能为空"/> <br />
								</p>
								<p>
									<label><spring:message code="backend.app.add.label.type" /></label>
									<select name="typeId" class="small-input">
										<c:forEach var="a" items="${appTypeList}">
											<option value="${a.id}" <c:if test="${a.id == app.typeId}">selected="selected"</c:if>>${a.name}</option>
										</c:forEach>
									</select> <br />
								</p>
							</fieldset>
							<p>
								<input class="button" type="submit" value="<spring:message code="backend.form.button.add" />" />
							</p>
						</form>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<%@include file="../common/footer.jsp"%>
		</div>
	</div>
	<script>
		$.validationSetup({
			modules : 'date, security'
		});
	</script>
</body>
</html>