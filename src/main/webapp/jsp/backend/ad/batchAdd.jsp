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
					<strong><spring:message code="backend.channel.add.label.code" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultChannelCode" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.channel.add.label.name" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultChannelName" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.channel.add.label.linkman" /> </strong><input type="text" id="resultLinkman" class="text-input medium-input" readonly="readonly" />
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
					<h3>添加批次</h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div>添加批次</div>
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
						<form id="form" method="post">
							<fieldset>
								<input type="hidden" name="id" value="${channel.id}" />
								<p>
									<label>批次别名 <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" 
										data-validation="required" data-validation-error-msg="<spring:message code="backend.channel.add.err-message.name" />"/> <br />
								</p>
								<p>
									<select name="channelId" class="small-input" id="channel_selection" onchange="channel_change()">
										<c:forEach var="c" items="${channelList}">
											<option value="${c.id}">${c.name}</option>
										</c:forEach>
									</select>
									<select name="appId" class="small-input" id="app_selection" onchange="app_change()"></select>
									<select name="cpaId" class="small-input" id="cpa_selection"></select> 
									<input class="button" type="button" onclick="addCpaPromotion()" value="添加应用" />
									<br />
								</p>
								<p>
									<table>
										<thead>
											<tr>
												<th>渠道</th>
												<th>应用</th>
												<th>别名</th>
												<th><spring:message code="backend.channel.list.column.operation" /></th>
											</tr>
										</thead>
										<tbody id="tableColoum"></tbody>
									</table>
								</p>
								<p>
									<input class="button" type="button" value="<spring:message code="backend.form.button.add" />" />
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
			
			channel_change();
		});
		
		function channel_change() {
			var id = $('#channel_selection').val();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/ad/batchController/getAppOptions.do",
				type : "post",
				data : {channelId:id},
				datatype : "json",
				success : function(data) {
					var str = "";
					for (var i=0; i<data.length; i++) {
						str = str + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
					}
					$('#app_selection').html(str);
					app_change();
				}
			})
		}
		
		function app_change() {
			var channel_id = $('#channel_selection').val();
			var id = $('#app_selection').val();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/ad/batchController/getCpaAppOptions.do",
				type : "post",
				data : {appId:id,channelId:channel_id},
				datatype : "json",
				success : function(data) {
					var str = "";
					for (var i=0; i<data.length; i++) {
						str = str + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
					}
					$('#cpa_selection').html(str);
				}
			})
		}
		
		function addCpaPromotion() {
			var id = $('#cpa_selection').val();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/ad/batchController/getCpaPromotionRecord.do",
				type : "post",
				data : {cpaId:id},
				datatype : "json",
				success : function(data) {
					$('#tableColoum').append(
						'<tr id="' + data.id + '">' +
							'<td>' + data.channelName + '</td>' +
							'<td>' + data.appName + '</td>' +
							'<td>' + data.name + '</td>' +
							'<td><a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="removeRecord(' + data.id + ')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />" /></a></td>' +
						'</tr>'
					);
				}
			})
		}
		
		function removeRecord(id) {
			$('#'+id).remove();
		}
	</script>
</body>
</html>