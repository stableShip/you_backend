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
					<h3><spring:message code="backend.admin.update.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.admin.update.alert" /></div>
						</div>
						<c:if test="${errors != null}">
							<div class="notification error png_bg">
								<div>
									<c:forEach var="e" items="${errors}">
										<c:out value="${e.defaultMessage}" /><br />
									</c:forEach>
								</div>
							</div>
						</c:if>
						<form name="dto" action="<%=request.getContextPath()%>/backend/general/accountController/accountUpdate.do" method="post">
							<fieldset>
								<input type="hidden" name="id" value="${dto.id}" />
								<p>
									<label><spring:message code="backend.admin.update.label.account" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input max-input" type="text" name="account" value="${dto.account}" readonly="readonly"/><br />
								</p>
								<p>
									<label><spring:message code="backend.admin.update.label.password" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input max-input" type="text" name="password"/> <br />
								</p>
								<p>
									<label><spring:message code="backend.admin.update.label.name" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input max-input" type="text" name="name" value="${dto.name}"
										data-validation="required" data-validation-error-msg="<spring:message code="backend.admin.update.err-message.name" />" />
									<br />
								</p>
								<p>
									<label><spring:message code="backend.admin.update.label.type" /></label>
									<select name="roleId" class="max-input">
										<c:forEach var="r" items="${roleList}">
											<option value="${r.id}" <c:if test="${r.id == dto.roleId}">selected="selected"</c:if>>${r.name}</option>
										</c:forEach>
									</select>
								</p>
								<p>
									<label><spring:message code="backend.admin.update.label.companyName" /></label>
									<select name="accountInformation.companyId" class="max-input">
										<option value="0" <c:if test="${dto.accountInformation.companyId == 0}">selected="selected"</c:if>>--</option>
										<c:forEach var="c" items="${companyList}">
											<option value="${c.id}"
												<c:if test="${c.id == dto.accountInformation.companyId}">selected="selected"</c:if>>${c.name}</option>
										</c:forEach>
									</select>
								</p>
								<p>
									<label><spring:message code="backend.admin.update.label.email" /></label><input class="text-input max-input"
										type="text" name="accountInformation.email" value="${dto.accountInformation.email}" data-validation-optional="true"
										data-validation="email" data-validation-error-msg="<spring:message code="backend.admin.update.err-message.email" />" />
									<br />
								</p>
								<p>
									<label><spring:message code="backend.admin.update.label.qq" /></label><input class="text-input max-input"
										type="text" name="accountInformation.qqNumber" value="${dto.accountInformation.qqNumber}"
										data-validation="number" data-validation-optional="true"
										data-validation-error-msg="<spring:message code="backend.admin.update.err-message.qq" />" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.admin.update.label.mobilePhone" /></label><input class="text-input max-input"
										type="text" name="accountInformation.mobilePhone" value="${dto.accountInformation.mobilePhone}"
										data-validation="number" data-validation-error-msg="<spring:message code="backend.admin.update.err-message.mobilePhone" />"
										data-validation-optional="true" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.admin.update.label.remarks" /></label>
									<input class="text-input max-input" type="text" name="accountInformation.remarks" value="${dto.accountInformation.remarks}" /> <br />
								</p>
							</fieldset>
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
	<script>
		$.validationSetup({
			onError : function() {
				$("body").scrollTop(0);
	        },
			modules : 'date, security'
		});
	</script>
</body>
</html>