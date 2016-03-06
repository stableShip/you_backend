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
	<div id="searchDialog">
		<form name="criteria" id="form" action="<%=request.getContextPath()%>/backend/market/appController/appList.do" method="post">
			<fieldset>
				<p>
					<spring:message code="backend.app.list.search.name" />&nbsp; 
					<input class="text-input small-input" type="text" name="searchName" value="${criteria.searchName}"/><br /> 
					<spring:message code="backend.app.list.search.type" />&nbsp; 
					<select name="searchTypeId" class="small-input">
						<option value="0">全部</option>
						<c:forEach var="a" items="${appTypeList}">
							<option value="${a.id}" <c:if test="${a.id == criteria.searchTypeId}">selected="selected"</c:if>>${a.name}</option>
						</c:forEach>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="pagination.pageSize" type="hidden" id="pageSize" value="${criteria.pagination.pageSize}" />
					<input name="pagination.currentPage" type="hidden" id="page" value="${criteria.pagination.currentPage}" />
				</p>
			</fieldset>
		</form>
	</div>
	<div id="deleteConfirmDialog">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.app.list.column.name" /></strong> 
					<input class="text-input medium-input" type="text" id="dAppName" readonly="readonly" /><br /> 
				</p>
				<p>
					<strong><spring:message code="backend.dialog.message.deleteAlert" /></strong> <br /> 
				</p>
			</fieldset>
		</form>
	</div>
	<div id="successDeleteDialog">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.dialog.message.deleteSuccess" /></strong> <br /> 
				</p>
			</fieldset>
		</form>
	</div>
	<div id="failureDeleteDialog">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.dialog.message.deleteFailure" /></strong> <br /> 
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
					<h3><spring:message code="backend.app.list.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.app.list.alert" /></div>
						</div>
						<form>
							<fieldset>
								<p>
									<a class="button" href="#" onclick="javascript:$('#searchDialog').dialog('open');">搜索条件</a>
									<c:if test="${appPermission == 2}">
										<a class="button" href="<%=request.getContextPath()%>/backend/market/appController/appAddPage.do"><spring:message code="backend.app.list.button.addApp" /></a>
									</c:if>
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<th><spring:message code="backend.app.list.column.name" /></th>
									<th><spring:message code="backend.app.list.column.status" /></th>
									<th><spring:message code="backend.app.list.column.type" /></th>
									<th>通知栏推荐</th>
									<c:if test="${appPermission == 2}">
										<th><spring:message code="backend.app.list.column.operation" /></th>
									</c:if>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="6">
										<div class="pagination">
											<%@include file="../common/page.jsp"%>
										</div>
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
							<input type="hidden" id="chooseId" value="0"></input>
							<tbody>
								<c:forEach var="a" items="${appList}">
									<tr>
										<td><a href="<%=request.getContextPath()%>/backend/market/appController/appUpdatePage.do?id=${a.id}">${a.name}</a></td>
										<td><c:if test="${a.status == 0}"><a href="#">未完善资料</a></c:if></td>
										<td>${a.appTypeName}</td>
										<td>
											<c:if test="${a.hasNotification != 0}">
												<c:if test="${a.notificationSelected != null}">
													<a href="<%=request.getContextPath()%>/backend/market/notificationController/appNotificationSelectedCancel.do">取消推荐</a>
												</c:if>
												<c:if test="${a.notificationSelected == null}">
													<a href="<%=request.getContextPath()%>/backend/market/notificationController/appNotificationSelected.do?appId=${a.id}">设为推荐</a>
												</c:if>
											</c:if>
										</td>
										<c:if test="${appPermission == 2}">
											<td>
												<%-- <a href="<%=request.getContextPath()%>/backend/market/appController/appUpdatePage.do?id=${a.id}" title="修改"><img src="<%=request.getContextPath()%>/images/icons/pencil.png" alt="修改" /></a> --%> 
												<a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="showDeleteConfirm('${a.name}', '${a.id}')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />" /></a>
												<a href="<%=request.getContextPath()%>/backend/market/notificationController/appNotificationForModify.do?id=${a.id}" title="通知栏推荐"><img src="<%=request.getContextPath()%>/images/icons/bullet_black.png" alt="通知栏推荐" /></a>
											</td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<%@include file="../common/footer.jsp"%>
		</div>
	</div>
	<script>
		$(function() {
			$('#searchDialog').dialog({
		        width: 500,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.information" />',
		        buttons: {
		        	'<spring:message code="backend.dialog.button.cancel" />':function(){ 
	        			$(this).dialog("close"); 
	        		},
	        		'<spring:message code="backend.form.button.search" />':function(){
						$('#form').submit();
	        		}
		         }
		      });
			$('#deleteConfirmDialog').dialog({
		        width: 500,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.alert" />',
		        buttons: {
	        		'<spring:message code="backend.dialog.button.confirm" />':function(){
	        			confirmDelete();
	        		}, 
	        		'<spring:message code="backend.dialog.button.cancel" />':function(){ 
	        			$(this).dialog("close"); 
	        		} 
		         }
		      });
			$('#successDeleteDialog').dialog({
		        width: 300,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.alert" />',
		        buttons: {
		        	'<spring:message code="backend.dialog.button.confirm" />':function(){ 
		        		location.reload();
	        		} 
		         }
		      });
			$('#failureDeleteDialog').dialog({
		        width: 300,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.alert" />',
		        buttons: {
		        	'<spring:message code="backend.dialog.button.confirm" />':function(){ 
	        			$(this).dialog("close"); 
	        		} 
		         }
		      });
		});
	
		function showDeleteConfirm(name, id) {
			$('#dAppName').attr("value", name);
			$('#chooseId').attr("value", id);
			$('#deleteConfirmDialog').dialog('open');
		}
		
		function confirmDelete() {
			$('#deleteConfirmDialog').dialog('close');
			var recordId = $('#chooseId').val();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/market/appController/appDelete.do",
				type:"post",
				data:{id:recordId},
				datatype:"json",
				success:function(data){
					if(data == 0) {
						$('#failureDeleteDialog').dialog('open');
					}
					else {
						$('#successDeleteDialog').dialog('open');
					}
				}
			});
		}
	</script>
</body>
</html>