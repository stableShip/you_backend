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
		<form id="successForm" action="<%=request.getContextPath()%>/backend/channel/cpaPromotionController/cpaPromotionList.do" method="post">
			<fieldset>
				<p>
					<strong>渠道代码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" id="resultChannelCode" class="text-input medium-input" readonly="readonly" /><br />
					<strong>渠道名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" id="resultChannelName" class="text-input medium-input" readonly="readonly" /><br />
					<strong>推广KEY&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" id="resultKey" class="text-input medium-input" readonly="readonly" /><br />
					<strong>应用名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" id="resultAppName" class="text-input medium-input" readonly="readonly" /><br />
					<strong>应用别名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" id="resultAppNickName" class="text-input medium-input" readonly="readonly" /><br />
					<strong>激活价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" id="resultSameDayPrice" class="text-input medium-input" readonly="readonly" /><br />
					<strong>激活有效时间</strong><input type="text" id="resultSameDayTime" class="text-input medium-input" readonly="readonly" /><br />
					<strong>次日留存价格</strong><input type="text" id="resultNextDayPrice" class="text-input medium-input" readonly="readonly" /><br /> 
					<strong>留存有效时间</strong><input type="text" id="resultNextDayTime" class="text-input medium-input" readonly="readonly" />
				</p>
			</fieldset>
		</form>
	</div>
	<div id="failureDialog">
		<form id="failureForm" action="<%=request.getContextPath()%>/backend/channel/cpaPromotionController/cpaPromotionList.do" method="post">
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
					<h3><spring:message code="backend.promotion.add.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.promotion.add.alert" /></div>
						</div>
						<form name="promotion" id="form" method="post">
							<fieldset>
								<p>
									<label><spring:message code="backend.promotion.add.label.channel" /></label>
									<select name="channelId" class="small-input">
										<c:forEach var="c" items="${channelList}">
											<option value="${c.id}">${c.code}-${c.name}</option>
										</c:forEach>
									</select> <br />
								</p>
								<p>
									<label><spring:message code="backend.promotion.add.label.app.name" /></label> 
									<select name="appId" class="small-input">
										<c:forEach var="a" items="${appList}">
											<option value="${a.id}">${a.name}</option>
										</c:forEach>
									</select>
								</p>
								<p>
									 <label><spring:message code="backend.promotion.add.label.app.nickname" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									 <input class="text-input small-input" type="text" name="appNickname" data-validation="required" data-validation-error-msg="应用别名不能为空" /><br />
								</p>
								<p>
									<label><spring:message code="backend.promotion.add.label.price" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
										<spring:message code="backend.promotion.add.label.sameday.time" /> &nbsp;
										<select name=activeSameDayTime class="small-input">
											<option value="0">5分钟</option>
											<option value="1">10分钟</option>
											<option value="2">15分钟</option>
											<option value="3">20分钟</option>
											<option value="4">25分钟</option>
											<option value="5">30分钟</option>
										</select><br/>
										<spring:message code="backend.promotion.add.label.sameday.price" /> <input class="text-input small-input" type="text"
											name="sameDayPrice" data-validation="number" data-validation-optional="true"
										data-validation-error-msg="请输入数字" />&nbsp;<spring:message code="backend.promotion.add.label.yuan" /><br/>
										<spring:message code="backend.promotion.add.label.nextday.time" /> &nbsp;<select name="activeNextDayTime"
										class="small-input">
											<option value="0">5分钟</option>
											<option value="1">10分钟</option>
											<option value="2">15分钟</option>
											<option value="3">20分钟</option>
											<option value="4">25分钟</option>
											<option value="5">30分钟</option>
										</select><br/>
										<spring:message code="backend.promotion.add.label.nextday.price" />
										<input class="text-input small-input" type="text" name="nextDayPrice"
											 data-validation="number" data-validation-optional="true"
										data-validation-error-msg="请输入数字" />&nbsp;<spring:message code="backend.promotion.add.label.yuan" />
								</p>
								<p>
									<label>显示</label> 
									<input type="radio" name="isused" checked="checked" value="0" />否
									<input type="radio" name="isused" value="1" />是 
								</p>
							</fieldset>
							<p>
								<input class="button" type="button" value="<spring:message code="backend.form.button.add" />" onclick="addPromotion()" />
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
		
		$().ready(function() {
			$('#successDialog').dialog({
		        width: 400,
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
		});

		function addPromotion() {
			var data = $('#form').serialize();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/channel/cpaPromotionController/cpaPromotionAdd.do",
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
					} else if (data.promotion == null) {
						$('#failureDialog').dialog('open');
					} else {
						$('#resultChannelCode').attr('value',
								data.promotion.code);
						$('#resultChannelName')
								.attr('value',
										data.promotion.channelName);
						$('#resultKey').attr('value',
								data.promotion.appKey);
						$('#resultAppName').attr('value',
								data.promotion.appName);
						$('#resultAppNickName').attr('value',
								data.promotion.appNickname);
						$('#resultSameDayPrice').attr('value', 
								data.promotion.sameDayPrice);
						$('#resultSameDayTime').attr('value',
								getTypeTime(data.promotion.sameDayTime));
						$('#resultNextDayPrice').attr('value',
								data.promotion.nextDayPrice);
						$('#resultNextDayTime').attr('value',
								getTypeTime(data.promotion.nextDayTime));
						$('#successDialog').dialog('open');
					}
				}
			})
		}
		
		function getTypeTime(type) {
			if (type == 0) {
				return 5;
			} else if (type == 1) {
				return 10;
			} else if (type == 2) {
				return 15;
			} else if (type == 3) {
				return 20;
			} else if (type == 4) {
				return 25;
			} else if (type == 5) {
				 return 30;
			}
		}
	</script>
</body>
</html>