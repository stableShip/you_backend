<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>轻松游戏后台</title>
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
					<h3>编辑应用信息</h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img
								src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png"
								title="Close this notification" alt="close" /></a>
							<div>修改应用信息</div>
						</div>
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
						<form name="app"
							action="<%=request.getContextPath()%>/backend/ads/appController/appUpdate.do"
							method="post">
							<fieldset>
								<input type="hidden" name="id" value="${app.id}" />
								<p>
									<label>应用名称</label><input class="text-input small-input"
										type="text" name="name" value="${app.name}" /> <br />
								</p>
								<p>
									<label>应用类型</label><select name="typeId" class="small-input">
										<c:forEach var="a" items="${appTypeList}">
											<option value="${a.id}"
												<c:if test="${a.id == app.typeId}">selected="selected"</c:if>>${a.name}</option>
										</c:forEach>
									</select> <br />
								</p>
								<p>
									<label>语言</label><select name="companyId" class="small-input">
										<option value="0">中文</option>
										<option value="1">英文</option>
									</select>
								</p>
								<p>
									<img id="displayImg" width="60px" height="60px"/><input type="file" onchange="showIcon(this)"/>
								</p>
								<p>
									<label>包名</label><input class="text-input small-input"
										type="text" name="name" value="${app.name}" 
										/> <br />
								</p>
								<p>
									<label>显示平台</label>
									<input type="checkbox">平板</input>
									<input type="checkbox">手机</input>
									<input type="checkbox">电视</input>
								</p>
								<p>
									<label>关键字</label><input class="text-input small-input"
										type="text" name="name" value="${app.name}" 
										/> <br />
								</p>
								<p>
									<label>应用权限</label>
									<textarea class="text-input textarea"
									 name="description" cols="50" rows="12" >${app.description}</textarea>
								</p>
								<p>
									<label>应用介绍</label>
									<textarea class="text-input textarea"
									 name="description" cols="50" rows="12" >${app.description}</textarea>
								</p>
								<p>
									<input type="file" onchange="showScreenshot(this, 1)"/><img id="screenshotImg1" width="60px" height="60px"/>
									<input type="file" id="f"/><img  width="60px" height="60px" onclick="onclick()"/>
								</p>
							</fieldset>
							<p>
								<input class="button" type="submit" value="确定" />
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

			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#displayImg').removeAttr('src');
					$('#displayImg').attr('src', e.target.result);
					var api = $('#displayImg').Jcrop({
						setSelect : [ 20, 20, 200, 200 ],
						aspectRatio : 1,
					});
				}
				reader.readAsDataURL(input.files[0]);
			}

		}
		
		function showScreenshot(input, num) {

			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					if(num == 1) {
						var img = $('#screenshotImg1');
					}
					else if(num == 2) {
						var img = $('#screenshotImg2');
					}
					else if(num == 3) {
						var img = $('#screenshotImg3');
					}
					else if(num == 4) {
						var img = $('#screenshotImg4');
					}
					else if(num == 5) {
						var img = $('#screenshotImg5');
					}
					img.removeAttr('src');
					img.attr('src', e.target.result);
					var api = img.Jcrop({
						setSelect : [ 20, 20, 200, 200 ],
						aspectRatio : 1,
					});
				}
				reader.readAsDataURL(input.files[0]);
			}

		}
		
		function onclick() {
			$('#f').click();
		}
	</script>
</body>
</html>