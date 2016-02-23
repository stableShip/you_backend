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
					<h3><spring:message code="backend.editProfile.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<c:if test="${success != null}">
							<div class="notification attention png_bg">
								<a href="#" class="close"><img
									src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png"
									title="Close this notification" alt="close" /></a>
								<div>修改成功</div>
							</div>
						</c:if>
						<c:if test="${errors != null}">
							<div class="notification error png_bg">
								<div>
									<c:forEach var="e" items="${errors}">
										<c:out value="${e.defaultMessage}" />
										<br />
									</c:forEach>
								</div>
							</div>
						</c:if>
						<form bean="information"
							action="<%=request.getContextPath()%>/backend/general/passwordController/changePassword.do"
							method="post">
							<fieldset>
								<p>
									<label><spring:message code="backend.editProfile.newPassword" /></label><input class="text-input small-input"
										type="password" name="password" 
										data-validation-error-msg="新密码不能为空" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.editProfile.confirmPassword" /></label><input class="text-input small-input"
										type="password" name="confirmPassword"
										
										data-validation-error-msg="确认密码不能为空" /> <br />
								</p>
								<p>
									<input class="button" type="submit" value="<spring:message code="backend.editProfile.button" />" />
								</p>
							</fieldset>
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