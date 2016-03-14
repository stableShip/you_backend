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
	<div id="informationDialog" style="display: none">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.admin.list.column.account" /></strong> <input class="text-input medium-input" type="text" id="mAdminAccount" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.admin.list.column.name" /></strong> <input class="text-input medium-input" type="text" id="mAdminName" readonly="readonly" /><br />
				    <strong><spring:message code="backend.admin.list.column.type" /></strong> <input class="text-input medium-input" type="text" id="mAdminType" readonly="readonly" /><br />
					<strong><spring:message code="backend.admin.list.column.gender" /></strong> <input class="text-input medium-input" type="text" id="mAdminGender" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.admin.list.column.email" /></strong> <input class="text-input medium-input" type="text" id="mAdminEmail" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.admin.list.column.qq" />&nbsp;&nbsp;</strong> <input class="text-input medium-input" type="text" id="mAdminQQNumber" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.admin.list.column.phone" /></strong> <input class="text-input medium-input" type="text" id="mAdminMobilePhone" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.admin.list.column.company" /></strong> <input class="text-input medium-input" type="text" id="mAdminCompanyName" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.admin.list.column.remarks" /></strong> <input class="text-input medium-input" type="text" id="mAdminRemarks" readonly="readonly" /><br />
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
					<h3><spring:message code="backend.role.list.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<form>
							<fieldset>
								<p>
									<c:if test="${rolePermission == 2}">
										<a class="button" href="<%=request.getContextPath()%>/backend/general/roleController/rolePermissionAddPage.do">添加角色</a>
									</c:if>
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<th><spring:message code="backend.role.list.column.name" /></th>
									<th><spring:message code="backend.role.list.column.type" /></th>
									<th><spring:message code="backend.role.list.column.operation" /></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="3">
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="r" items="${roleList}">
									<tr>
										<td>${r.name}</td>
										<td>
											<c:if test="${r.internal == true}">
												<spring:message code="backend.role.list.label.type.internal" />
											</c:if>
											<c:if test="${r.internal == false}">
												<spring:message code="backend.role.list.label.type.external" />
											</c:if>
										</td>
										<td><a href="#" title="<spring:message code="backend.operation.button.viewDetail" />" onclick="viewInfomation(${r.id})"><img src="<%=request.getContextPath()%>/images/icons/text.png" alt="<spring:message code="backend.operation.button.viewDetail" />" /></a>
											<c:if test="${rolePermission == 2}">
												<a href="<%=request.getContextPath()%>/backend/general/roleController/rolePermissionUpdatePage.do?id=${r.id}" title="<spring:message code="backend.operation.button.modify" />"><img src="<%=request.getContextPath()%>/images/icons/pencil.png" alt="<spring:message code="backend.operation.button.modify" />" /></a> 
											 </c:if>
										</td>
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
			$('#informationDialog').dialog({
		        width: 500,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.information" />',
		        buttons: {
		        	'<spring:message code="backend.dialog.button.confirm" />':function(){ 
	        			$(this).dialog("close"); 
	        		} 
		         }
		      });
		});
	
		function viewInfomation(recordId) {
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/general/adminController/viewDetail.do",
				type:"post",
				data:{id:recordId},
				datatype:"json",
				success:function(data){
					if(data.account == null) {
						location.reload();
					}
	 		 		$('#mAdminAccount').attr("value", data.account);
					$('#mAdminName').attr("value", data.name);
					if(data.isInternal == true) {
						$('#mAdminType').attr("value", '内部人员');
					}
					else {
						$('#mAdminType').attr("value", '外部人员');
					}
					if(data.gender == true) {
						$('#mAdminGender').attr("value", '女');
					}
					else {
						$('#mAdminGender').attr("value", '男');
					}
					$('#mAdminEmail').attr("value", data.email);
					$('#mAdminQQNumber').attr("value", data.qqNumber);
					$('#mAdminMobilePhone').attr("value", data.mobilePhone);
					$('#mAdminCompanyName').attr("value", data.companyName);
					$('#mAdminRemarks').attr("value", data.remarks);
					$('#informationDialog').dialog('open');
				}
			});
		} 
	</script>
</body>
</html>