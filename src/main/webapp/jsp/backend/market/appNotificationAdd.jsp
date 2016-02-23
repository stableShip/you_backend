<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="backend.login.title" /></title>
<jsp:include page="../common/common.jsp" flush="true" />
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/common/ajaxfileupload.js"></script>
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
					<h3>通知栏推荐设置</h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.app.add.alert" /></div>
						</div>
						<c:if test="${errors != null}">
							<div class="notification error png_bg">
								<div>
									<c:forEach var="e" items="${errors}">
										<c:out value="${e.defaultMessage}" /> <br />
									</c:forEach>
								</div>
							</div>
						</c:if>
						<form name="appNotification" action="<%=request.getContextPath()%>/backend/market/notificationController/appNotificationAdd.do" method="post" enctype="multipart/form-data">
							<fieldset>
								<p>
									<input type="hidden" name="appId" value="${appId}"/>
									<label>应用图标</label>
									<img src="" id="displayIcon" height="48" width="48" />
									<input type="hidden" name="iconUrl" id="iconUrl" value="${appNotification.iconUrl}"/>
									<input class="button" type="file" name="file"  id="uploadFile" onchange="showIcon(this);" /><br />
								</p>
								<p>
									<label>应用包名</label>
									<input class="text-input small-input" type="text" name="packageName" value="${appNotification.packageName}" data-validation-error-msg="应用名称不能为空"/> <br />
								</p>
								<p>
									<label>宣传语</label>
									<input class="text-input small-input" type="text" name="promotionWord" value="${appNotification.promotionWord}" data-validation-error-msg="应用名称不能为空"/> <br />
								</p>
								<p>
									<label>下载地址</label>
									<input class="text-input small-input" type="text" name="downloadUrl" value="${appNotification.downloadUrl}" data-validation-error-msg="应用名称不能为空"/> <br />
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
			modules : 'date, security'
		});
		
		function showIcon(input) {
			var file = $("#uploadFile").val();  
			if(!/\.(gif|jpg|jpeg|png|JPG|PNG)$/.test(file))  
			{  
			    alert("不支持的图片格式.图片类型必须是.jpeg,jpg,png,gif格式.");  
			    return false; 
			}
			
			$.ajaxFileUpload({  
				url : "<%=request.getContextPath()%>/fileController/singlefileUpload.do",
		        secureuri : false,  
		        fileElementId : 'uploadFile',
		        dataType : 'text',
		        success : function(data, status) { 
		        	$("#iconUrl").attr("value", data);
		        	if (input.files && input.files[0]) {
						var reader = new FileReader();
						reader.onload = function(e) {
							$('#displayIcon').removeAttr('src');
							$('#displayIcon').attr('src', e.target.result);
							var api = $('#displayIcon').Jcrop({
								setSelect : [ 20, 20, 200, 200 ],
								aspectRatio : 1,
							});
						}
						reader.readAsDataURL(input.files[0]);
					} 
		        },  
		        error : function(data, status, e) {
		        }  
			});
			
		}
	</script>
</body>
</html>