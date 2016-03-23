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
					<h3><spring:message code="backend.company.add.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.company.add.alert" /></div>
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
						<form name="company" action="<%=request.getContextPath()%>/backend/general/companyController/companyAdd.do" method="post">
							<fieldset>
								<p>
									<label><spring:message code="backend.company.add.label.name" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input max-input" type="text" name="name" value="${company.name}" data-validation="required"
										data-validation-error-msg="<spring:message code="backend.company.add.err-message.name" />" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.company.add.label.phone" /></label><input class="text-input max-input"
										type="text" name="telephone" value="${company.telephone}"
										data-validation="number" data-validation-optional="true"
										data-validation-error-msg="<spring:message code="backend.company.add.err-message.phone" />" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.company.add.label.fex" /></label><input class="text-input max-input"
										type="text" name="fax" value="${company.fax}"
										data-validation="number" data-validation-optional="true"
										data-validation-error-msg="<spring:message code="backend.company.add.err-message.fex" />" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.company.add.label.address" /></label><input class="text-input max-input"
										type="text" name="address" value="${company.address}" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.company.add.label.homepage" /></label><input class="text-input max-input"
										type="text" name="homepage" value="${company.homepage}"
										data-validation="url" data-validation-optional="true"
										data-validation-error-msg="<spring:message code="backend.company.add.err-message.homepage" />" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.company.add.label.description" /></label>
									<textarea class="text-input textarea"
										name="description" cols="79" rows="15">${company.description}</textarea>
								</p>
								<p>
									<input class="button" type="submit" value="<spring:message code="backend.form.button.add" />" />
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
			onError : function() {
				$("body").scrollTop(0);
	        },
			modules : 'date, security'
		});
	</script>
</body>
</html>