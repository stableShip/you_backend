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
	<div id="successDialog">
		<form id="successForm" action="<%=request.getContextPath()%>/backend/glaze/baseGlazeController/findBaseGlaze.do" method="post">
			<fieldset>
				<p>
					<strong><spring:message code="backend.sample_glaze.add.label.name" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultglazeName" class="text-input medium-input" readonly="readonly" /><br />
					<strong><spring:message code="backend.sample_glaze.add.label.fineness" /> </strong><input type="text" id="resultWaterContent" class="text-input medium-input" readonly="readonly" /><br />
					<strong><spring:message code="backend.glaze.add.label.comment" /> </strong><input type="text" id="resultComment" class="text-input medium-input" readonly="readonly" />
				</p>
			</fieldset>
		</form>
	</div>
	<div id="failureDialog">
		<form id="failureForm" action="<%=request.getContextPath()%>/backend/glaze/baseGlazeController/findBaseGlaze.do" method="post">
			<fieldset>
				<p>
					<strong id="theErrorMessage"></strong>
				</p>
			</fieldset>
		</form>
	</div>
	<div id="body-wrapper">
		<div id="sidebar">
			<div id="sidebar-wrapper">
				<%@include file="../common/leftmenu.jsp"%>
			</div>
		</div>
		<div id="main-content">
			<div class="clear"></div>
			<div class="content-box" style="float: left; width: 100%">
				<div class="content-box-header">
					<h3><spring:message code="backend.sample_glaze.add.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.sample_glaze.add.alert" /></div>
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
						<form name="glaze" id="form" method="post">
							<fieldset style="float: left; width: 30%" >
								<input type="hidden" name="id" value="${glaze.id}" />
								<p>
									<label><spring:message code="backend.sample_glaze.add.label.name" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="name" value="${glaze.name}"
										 data-validation="required" data-validation-error-msg="<spring:message code="backend.sample_glaze.add.err-message.name" />"/> <br />
								</p>

								<p>
									<label><spring:message code="backend.company.list.column.name" /><b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<select name="customer_id" class="small-input">
										<option value="0">--</option>
										<c:forEach var="customer" items="${customerList}">
											<option value="${customer.id}">${customer.name}</option>
										</c:forEach>
									</select> <br />
								</p>
								<p>
									<label><spring:message code="backend.sample_glaze.add.label.fineness" /> </label>
									<input class="text-input small-input" type="text" name="water_content" value="${glaze.water_content}"
                                           data-validation="number" data-validation="required" data-validation-error-msg="<spring:message code="backend.glaze.add.err-message.water_content" />"/> <br />
								</p>
								<p>
									<label><spring:message code="backend.glaze.add.label.comment" /></label>
									<input class="text-input small-input" type="text" name="comment" value="${glaze.comment}"
										   <%--data-validation="required" data-validation-error-msg="<spring:message code="backend.glaze.add.err-message.water_content" />"--%>
                                    /> <br />
									 <br />
								</p>
								<p>
									<input class="button" type="button" onclick="addglaze()" value="<spring:message code="backend.form.button.add" />" />
								</p>
							</fieldset>
							<fieldset style="float: left; width: 35%;">
								<p>
									<label>色料名称</label>
									<select name="toner_id" class="small-input">
										<option value="0">--</option>
										<c:forEach var="toner" items="${tonerList}">
											<option value="${toner.id}">${toner.name}</option>
										</c:forEach>
									</select> <br />
								</p>
							</fieldset>
							<fieldset style="float: left; width: 35%;">
								<p>
									<label>基础釉名称</label>
									<select name="base_glaze_id" class="small-input">
										<option value="0">--</option>
										<c:forEach var="baseGlaze" items="${baseGlazeList}">
											<option value="${baseGlaze.id}">${baseGlaze.name}</option>
										</c:forEach>
									</select> <br />
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
			scrollToTopOnError : true,
			onError : function() {
				$("body").scrollTop(0);
	        },
			modules : 'date, security'
		});
		
		$(function() {
			$('#successDialog').dialog({
		        width: 500,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.addSuccess" />',
		        buttons: {
		            '<spring:message code="backend.dialog.button.backToList" />': function() { 
		            	$('#successForm').submit();
		            } 
		         }
		      });
			
			$('#failureDialog').dialog({
		        width: 460,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.addFailure" />',
		        buttons: {
		            '<spring:message code="backend.dialog.button.backToList" />': function() { 
		            	$('#failureForm').submit();
		            },
		            '<spring:message code="backend.dialog.button.confirm" />': function() { 
		            	$(this).dialog("close"); 
		            } 
		         }
		      });
			
			$('#noglazeDialog').dialog({
		        width: 460,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.no_sample_glaze" />',
		        buttons: {
		            '<spring:message code="backend.dialog.button.confirm" />': function() { 
		            	$(this).dialog("close"); 
		            } 
		         }
		      });
		});
		
		function addglaze() {
			var data = $('#form').serialize();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/glaze/baseGlazeController/baseGlazeAdd.do",
				type : "post",
				data : data,
				datatype : "json",
				success : function(data) {
					if (data.errors != null) {
						var errorMessage = '';
						for(var i=0; i< data.errors.length; i++) {
							errorMessage = errorMessage + data.errors[i].defaultMessage + '<br/>';
						}
						$("#theErrorMessage").html(errorMessage);
						$('#failureDialog').dialog('open');
					} else {
						$('#resultglazeName').attr('value',
								data.baseGlaze.name);
						$('#resultWaterContent').attr('value',
										+ data.baseGlaze.water_content);
                        $('#resultComment').attr('value',
                                 data.baseGlaze.comment);
						$('#successDialog').dialog('open');
					}
				}
			})
		}
	</script>
</body>
</html>