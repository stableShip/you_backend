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
	<div id="searchDialog" style="display: none">
		<form name="criteria" id="form" action="<%=request.getContextPath()%>/backend/general/companyController/companyList.do" method="post">
			<fieldset>
				<p>
					<spring:message code="backend.company.list.search.label.companyName" /> <input class="text-input max-input" type="text" name="searchName" value="${criteria.searchName}" />
					<input name="pagination.pageSize" type="hidden" id="pageSize" value="${criteria.pagination.pageSize}" />
					<input name="pagination.currentPage" type="hidden" id="page" value="${criteria.pagination.currentPage}" />
				</p>
			</fieldset>
		</form>
	</div>
	<div id="informationDialog" style="display: none">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.company.list.column.name" /></strong> <input class="text-input medium-input" type="text" id="mCompanyName" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.company.list.column.phone" /></strong> <input class="text-input medium-input" type="text"id="mCompanyTelephone" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.company.list.column.fex" /></strong> <input class="text-input medium-input" type="text" id="mCompanyFax" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.company.list.column.address" /></strong> <input class="text-input medium-input" type="text" id="mCompanyAddress" readonly="readonly" /><br /> 
					<strong><spring:message code="backend.company.list.column.homepage" /></strong> <input class="text-input medium-input" type="text" id="mCompanyHomepage" readonly="readonly" /><br /> 
				</p>
			</fieldset>
		</form>
	</div>
	<div id="deleteConfirmDialog" style="display: none">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.company.list.column.name" /></strong>
					<input class="text-input medium-input" type="text" id="dCompanyName" readonly="readonly" /> 
				</p>
				<p>
					<strong><spring:message code="backend.dialog.message.deleteAlert" /></strong> <br /> 
				</p>
			</fieldset>
		</form>
	</div>
	<div id="successDeleteDialog" style="display: none">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.dialog.message.deleteSuccess" /></strong> <br /> 
				</p>
			</fieldset>
		</form>
	</div>
	<div id="failureDeleteDialog" style="display: none">
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
					<h3><spring:message code="backend.company.list.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.company.list.alert" /></div>
						</div>
						<form>
							<fieldset>
								<p>
									<a class="button" href="#" onclick="javascript:$('#searchDialog').dialog('open');">搜索条件</a>
									<c:if test="${companyPermission == 2}">
										<a class="button" href="<%=request.getContextPath()%>/backend/general/companyController/companyAddPage.do"><spring:message code="backend.company.list.button.addCompany" /></a>
									</c:if>
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<th><spring:message code="backend.company.list.column.name" /></th>
									<th><spring:message code="backend.company.list.column.phone" /></th>
									<th><spring:message code="backend.company.list.column.fex" /></th>
									<th><spring:message code="backend.company.list.column.address" /></th>
									<th><spring:message code="backend.company.list.column.homepage" /></th>
									<th><spring:message code="backend.company.list.column.operation" /></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="5">
										<div class="pagination">
											<%@include file="../common/page.jsp"%>
										</div>
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
							<input type="hidden" id="chooseId" value="0"></input>
							<tbody>
								<c:forEach var="c" items="${companyList}">
									<tr>
										<td><c:out value="${c.name}" /></td>
                                        <td><c:out value="${c.telephone}" /></td>
                                        <td><c:out value="${c.fax}" /></td>
										<td><c:out value="${c.address}" /></td>
										<td><c:out value="${c.homepage}" /></td>
										<td><a href="#" title="<spring:message code="backend.operation.button.viewDetail" />" onclick="viewInfomation(${c.id})"><img src="<%=request.getContextPath()%>/images/icons/text.png" alt="<spring:message code="backend.operation.button.viewDetail" />" /></a> 
											<c:if test="${companyPermission == 2}">
												<a href="<%=request.getContextPath()%>/backend/general/companyController/companyUpdatePage.do?id=${c.id}" title="<spring:message code="backend.operation.button.modify" />"><img src="<%=request.getContextPath()%>/images/icons/pencil.png" alt="<spring:message code="backend.operation.button.modify" />"></img></a> 
												<a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="showDeleteConfirm('${c.name}','${c.id}')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />"></img></a> 
												<a href="<%=request.getContextPath()%>/backend/general/accountController/accountAddPage.do?companyId=${c.id}" title="<spring:message code="backend.operation.button.addAdmin" />"><img src="<%=request.getContextPath()%>/images/icons/people.png" alt="<spring:message code="backend.operation.button.addAdmin" />" /></a>
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
			<%@ include file="../common/footer.jsp"%>
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
	
		function viewInfomation(recordId) {
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/general/companyController/viewDetail.do",
				type:"post",
				data:{id:recordId},
				datatype:"json",
				success:function(data){
					if(data.name == null) {
						location.reload();
					}
					$('#mCompanyName').attr("value", data.name);
					$('#mCompanyTelephone').attr("value", data.telephone);
					$('#mCompanyFax').attr("value", data.fax);
					$('#mCompanyAddress').attr("value", data.address);
					$('#mCompanyHomepage').attr("value", data.homepage);
					$('#mCompanyDescription').attr("value", data.description);
					$('#informationDialog').dialog('open');
				}
			});
		} 
		
		function showDeleteConfirm(name, id) {
			$('#dCompanyName').attr("value", name);
			$('#chooseId').attr("value", id);
			$('#deleteConfirmDialog').dialog('open');
		}
		
		function confirmDelete() {
			$('#deleteConfirmDialog').dialog('close');
			var recordId = $('#chooseId').val();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/general/companyController/companyDelete.do",
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