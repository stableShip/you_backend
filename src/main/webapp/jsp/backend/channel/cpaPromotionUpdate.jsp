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
					<strong>合作方式&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" id="resultType" class="text-input medium-input" readonly="readonly" /><br />
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
					<h3><spring:message code="backend.promotion.update.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img
								src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png"
								title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.promotion.update.alert" /></div>
						</div>
						<form name="promotion" id="form" method="post">
							<fieldset>
								<input type="hidden" name="id" value="${promotion.id}"></input>
								<p>
									<label><spring:message code="backend.promotion.update.label.channel" /></label> 
									<input class="text-input small-input" type="text" value="${promotion.code} : ${promotion.channelName}" readonly="readonly"/><br />
								</p>
								<p>
									<label><spring:message code="backend.promotion.update.label.app.name" /></label> 
									<input class="text-input small-input" type="text" value="${promotion.appName}" readonly="readonly"/><br />
								</p>
								<p>
									 <label><spring:message code="backend.promotion.update.label.app.nickname" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									 <input class="text-input small-input" type="text" name="appNickName"
										data-validation="required" value="${promotion.appNickName}"
										data-validation-error-msg="应用别名不能为空" /><br />
								</p>
								<p>
									<label><spring:message code="backend.promotion.update.label.price" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
										<spring:message code="backend.promotion.update.label.sameday.time" /> &nbsp;
										<select name="sameDayTime" class="small-input">
											<option value="0" <c:if test="${promotion.sameDayTime == 0}">selected="selected"</c:if>>5分钟</option>
											<option value="1" <c:if test="${promotion.sameDayTime == 1}">selected="selected"</c:if>>10分钟</option>
											<option value="2" <c:if test="${promotion.sameDayTime == 2}">selected="selected"</c:if>>15分钟</option>
											<option value="3" <c:if test="${promotion.sameDayTime == 3}">selected="selected"</c:if>>20分钟</option>
											<option value="4" <c:if test="${promotion.sameDayTime == 4}">selected="selected"</c:if>>25分钟</option>
											<option value="5" <c:if test="${promotion.sameDayTime == 5}">selected="selected"</c:if>>30分钟</option>
										</select><br/>
										<spring:message code="backend.promotion.update.label.sameday.price" /> <input class="text-input small-input" type="text"
											name="sameDayPrice" data-validation="number" data-validation-optional="true"
										data-validation-error-msg="请输入数字" value="${promotion.sameDayPrice}"/>&nbsp;元<br/>
										<spring:message code="backend.promotion.update.label.nextday.time" /> &nbsp;<select name="nextDayTime"
										class="small-input">
											<option value="0" <c:if test="${promotion.nextDayTime == 0}">selected="selected"</c:if>>5分钟</option>
											<option value="1" <c:if test="${promotion.nextDayTime == 1}">selected="selected"</c:if>>10分钟</option>
											<option value="2" <c:if test="${promotion.nextDayTime == 2}">selected="selected"</c:if>>15分钟</option>
											<option value="3" <c:if test="${promotion.nextDayTime == 3}">selected="selected"</c:if>>20分钟</option>
											<option value="4" <c:if test="${promotion.nextDayTime == 4}">selected="selected"</c:if>>25分钟</option>
											<option value="5" <c:if test="${promotion.nextDayTime == 5}">selected="selected"</c:if>>30分钟</option>
										</select><br/>
										<spring:message code="backend.promotion.update.label.nextday.price" /> 
										<input class="text-input small-input" type="text" name="nextDayPrice"
											 data-validation="number" data-validation-optional="true" value="${promotion.nextDayPrice}"
										data-validation-error-msg="请输入数字" />&nbsp;元
								</p>
								<p>
									<label>显示</label> 
									<input type="radio" name="used" <c:if test="${promotion.used == false}">checked="checked"</c:if> value="0" />否
									<input type="radio" name="used" <c:if test="${promotion.used == true}">checked="checked"</c:if> value="1" />是 
								</p>
							</fieldset>
							<p>
								<input class="button" type="button" value="<spring:message code="backend.form.button.update" />" onclick="modifyPromotion()"/>
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
		        title: '修改成功',
		        buttons: {
		            '返回列表': function() { 
		            	$('#successForm').submit();
		            } 
		         }
		      });
			
			$('#failureDialog').dialog({
		        width: 460,
		        autoOpen: false,
		        modal: true,
		        title: '修改失败',
		        buttons: {
		            '返回列表': function() { 
		            	$('#failureForm').submit();
		            },
		            '确定': function() { 
		            	$(this).dialog("close"); 
		            } 
		         }
		      });
			
			$(':radio[name="type"]').eq(${promotion.type}).attr(
					"checked", true);
		});

		function modifyPromotion() {
			var data = $('#form').serialize();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/channel/cpaPromotionController/cpaPromotionUpdate.do",
				type : "post",
				data : data,
				datatype : "json",
				success : function(data) {
					if (data.errors != null) {
						$('#failureDialog').dialog('open');
					} else if (data.promotion == null) {
						$('#failureDialog').dialog('open');
					} else {
						$('#resultChannelCode').attr('value',
								data.promotion.code);
						$('#resultChannelName').attr('value',
								data.promotion.channelName);
						$('#resultKey').attr('value',
								data.promotion.key);
						$('#resultAppName').attr('value',
								data.promotion.appName);
						$('#resultAppNickName').attr('value',
								data.promotion.appNickName);
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
