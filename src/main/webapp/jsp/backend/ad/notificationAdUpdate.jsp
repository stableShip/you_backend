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
		<form id="successForm" action="<%=request.getContextPath()%>/backend/ad/notificationAdController/notificationAdList.do" method="post">
			<fieldset>
				<p>
					<strong><spring:message code="backend.notificationAd.update.label.name" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultNotificationAdName" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.notificationAd.update.label.appname" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultNotificationAdAppName" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.notificationAd.update.label.promotionWord" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultNotificationAdPromotionWord" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.notificationAd.update.label.iconUrl" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultNotificationAdIconUrl" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.notificationAd.update.label.dowmloadUrl" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultNotificationAdDownloadUrl" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.notificationAd.update.label.appkey" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultNotificationAdCpaAppKey" class="text-input medium-input" readonly="readonly" /><br /> 
				</p>
			</fieldset>
		</form>
	</div>
	<div id="failureDialog">
		<form id="failureForm" action="<%=request.getContextPath()%>/backend/ad/notificationAdController/notificationAdList.do" method="post">
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
			<div class="content-box">
				<div class="content-box-header">
					<h3>添加通知栏广告</h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div>添加通知栏广告</div>
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
						<form name="notificationAd" id="form" method="post">
							<fieldset>
								<input type="hidden" name="id" value="${notificationAd.id}" />
								<p>
									<label><spring:message code="backend.notificationAd.update.label.name" /><b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="name" value="${notificationAd.name}" 
										data-validation="required" data-validation-error-msg="<spring:message code="backend.notificationAd.add.err-message.name" />"/> <br />
								</p>
								<p>
									<label><spring:message code="backend.notificationAd.update.label.appname" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="appName" value="${notificationAd.appName}" 
										data-validation="required" data-validation-error-msg="<spring:message code="backend.notificationAd.add.err-message.appname" />"/> <br />
								</p>
								<p>
									<label><spring:message code="backend.notificationAd.update.label.promotionWord" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="promotionWord" value="${notificationAd.promotionWord}" 
										data-validation="required" data-validation-error-msg="<spring:message code="backend.notificationAd.add.err-message.promotionWord" />"/> <br />
								</p>
								<p>
									<label><spring:message code="backend.notificationAd.update.label.iconUrl" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="iconUrl" value="${notificationAd.iconUrl}" 
										data-validation="required" data-validation-error-msg="<spring:message code="backend.notificationAd.add.err-message.iconUrl" />"/> <br />
								</p>
								<p>
									<label><spring:message code="backend.notificationAd.update.label.dowmloadUrl" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="downloadUrl" value="${notificationAd.downloadUrl}" 
										data-validation="required" data-validation-error-msg="<spring:message code="backend.notificationAd.add.err-message.dowmloadUrl" />"/> <br />
								</p>
								<p>
									<label><spring:message code="backend.notificationAd.update.label.appkey" /></label>
									<input class="text-input small-input" type="text" name="cpaAppkey" value="${notificationAd.cpaAppKey}"
									 data-validation-error-msg="<spring:message code="backend.notificationAd.add.err-message.appkey" />"/> <br />
								</p>
								<p>
									<input class="button" type="button" onclick="updateNotifivationAd()" value="<spring:message code="backend.form.button.add" />" />
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
			
			$('#noChannelDialog').dialog({
		        width: 460,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.noChannel" />',
		        buttons: {
		            '<spring:message code="backend.dialog.button.confirm" />': function() { 
		            	$(this).dialog("close"); 
		            } 
		         }
		      });
		});
		
		function updateNotifivationAd() {
			var data = $('#form').serialize();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/ad/notificationAdController/notificationAdUpdate.do",
				type : "post",
				data : data,
				datatype : "json",
				error:function(){alert('发生错误')},  
				success : function(data) {
					if (data.errors != null) {
						var errorMessage = '';
						for(var i=0; i< data.errors.length; i++) {
							errorMessage = errorMessage + data.errors[i].defaultMessage + '<br/>';
						}
						
						$("#theErrorMessage").html(errorMessage);
						$('#failureDialog').dialog('open');
					} else if (data.notificationAd.id == null) {
						
						$('#failureDialog').dialog('open');                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
						
					} else {
						$('#resultNotificationAdName').attr('value',
								data.notificationAd.name);
						$('#resultNotificationAdAppName').attr('value',
								data.notificationAd.appName);
						$('#resultNotificationAdPromotionWord').attr('value',
								data.notificationAd.promotionWord);
						$('#resultNotificationAdIconUrl').attr('value',
								data.notificationAd.iconUrl);
						$('#resultNotificationAdDownloadUrl').attr('value',
								data.notificationAd.downloadUrl);
						$('#resultNotificationAdCpaAppKey').attr('value',
								data.notificationAd.cpaAppkey);
						$('#successDialog').dialog('open');
					}
				}
			})
		}
	</script>
</body>
</html>