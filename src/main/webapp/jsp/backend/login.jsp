<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="backend.login.title" /></title>
<jsp:include page="common/common.jsp" flush="true" />
</head>
<body id="login">
	<div id="login-wrapper" class="png_bg">
		<div id="login-top">
			<h1><spring:message code="backend.login.alert" /></h1>
			<%-- <img id="logo" src="<%=request.getContextPath()%>/images/logo.png" alt="Simpla Admin logo" /> --%>
		</div>
		<div id="login-content">
			<form name="admin" action="<%=request.getContextPath()%>/backend/loginAndLogoutController/login.do" method="post">
				<div class="notification information png_bg">
					<div><spring:message code="backend.login.alert" /></div>
				</div>
				<p>
					<label><spring:message code="backend.login.label.account" /></label><input class="text-input" type="text" name="account" />
				</p>
				<div class="clear"></div>
				<p>
					<label><spring:message code="backend.login.label.password" /></label><input class="text-input" type="password" name="password" />
				</p>
				<div class="clear"></div>
				<p>
					<input class="button" type="submit" value="<spring:message code="backend.login.button" />" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>