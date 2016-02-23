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
		<form id="successForm" action="<%=request.getContextPath()%>/backend/channel/channelController/findChannel.do" method="post">
			<fieldset>
				<p>
					<strong><spring:message code="backend.channel.update.label.code" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultChannelCode" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.channel.update.label.name" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultChannelName" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.channel.update.label.linkman" /> </strong><input type="text" id="resultLinkman" class="text-input medium-input" readonly="readonly" />
				</p>
			</fieldset>
		</form>
	</div>
	<div id="failureDialog">
		<form id="failureForm" action="<%=request.getContextPath()%>/backend/channel/channelController/findChannel.do" method="post">
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
					<h3><spring:message code="backend.channel.update.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.channel.update.alert" /></div>
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
						<form name="channel" id="form" method="post">
							<fieldset>
								<input type="hidden" name="id" value="${channel.id}" />
								<p>
									<label><spring:message code="backend.channel.update.label.name" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="name" value="${channel.name}" /> <br />
								</p>
								<p>
									<label><spring:message code="backend.channel.update.label.linkman" /></label>
									<select name="linkmanId" class="small-input">
										<option value="0">--</option>
										<c:forEach var="a" items="${adminList}">
											<option value="${a.id}" <c:if test="${channel.linkmanId == a.id}">selected="selected"</c:if> >${a.companyName}-${a.name}</option>
										</c:forEach>
									</select> <br />
								</p>
								<p>
									<label>父渠道</label>
									<select name="parentChannelId" class="small-input">
										<option value="0">--</option>
										<c:forEach var="c" items="${channelList}">
											<option value="${c.id}" <c:if test="${channel.parentChannelId == c.id}">selected="selected"</c:if> >${c.name}</option>
										</c:forEach>
									</select> <br />
								</p>
								<p>
									<input class="button" type="button" onclick="updateChannel()" value="<spring:message code="backend.form.button.update" />" />
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
		        title: '<spring:message code="backend.dialog.title.updateSuccess" />',
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
		        title: '<spring:message code="backend.dialog.title.updateFailure" />',
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
		
		function updateChannel() {
			var data = $('#form').serialize();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/channel/channelController/channelUpdate.do",
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
					} else if (data.channel.code == null) {
						$('#failureDialog').dialog('open');
					} else {
						$('#resultChannelCode').attr('value',
								data.channel.code);
						$('#resultChannelName').attr('value',
								data.channel.name);
						$('#resultLinkman').attr(
								'value',
								data.channel.linkmanName + '--'
										+ data.channel.companyName);
						$('#successDialog').dialog('open');
					}
				}
			})
		}
	</script>
</body>
</html>