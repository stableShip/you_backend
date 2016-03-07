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
		<form name="criteria" id="form" action="<%=request.getContextPath()%>/backend/glaze/sampleGlazeController/findSampleGlaze.do" method="post">
			<fieldset>
				<p>
					<spring:message code="backend.sample_glaze.list.column.name" /> <input class="text-input small-input" type="text" name="searchName" value="${criteria.searchName}" /><br />
					<spring:message code="backend.company.add.label.name" /> <input class="text-input small-input" type="text" name="searchName" value="${criteria.searchName}" /><br />

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
					<strong><spring:message code="backend.base_glaze.list.column.name" /></strong>
					<input class="text-input medium-input" type="text" id="dglaze" readonly="readonly" /><br /> 
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
					<h3><spring:message code="backend.glaze.list.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.glaze.list.alert" /></div>
						</div>
						<form>
							<fieldset>
								<p>
									<a class="button" href="#" onclick="javascript:$('#searchDialog').dialog('open');">搜索条件</a>
									<%--<c:if test="${glazePermission == 2}">--%>
										<a class="button" href="<%=request.getContextPath()%>/backend/glaze/sampleGlazeController/sampleGlazeAddPage.do"><spring:message code="backend.sample_glaze.add.title" /></a>
									<%--</c:if>--%>
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<th><spring:message code="backend.sample_glaze.list.column.id" /></th>
									<th><spring:message code="backend.company.add.label.name" /></th>
									<th><spring:message code="backend.sample_glaze.list.column.name" /></th>
									<th><spring:message code="backend.sample_glaze.list.column.fineness" /></th>
									<th><spring:message code="backend.sample_glaze.list.column.creation_date" /></th>
									<%--<c:if test="${glazePermission == 2}">--%>
										<th><spring:message code="backend.glaze.list.column.operation" /></th>
									<%--</c:if>--%>
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
							<input type="hidden" id="chooseId" value="0"/>
							<tbody>
								<c:forEach var="sampleGlaze" items="${sampleGlazeList}">
									<tr>
										<td>${sampleGlaze.id}</td>
										<td>${sampleGlaze.customer_name}</td>
										<td>${sampleGlaze.sample_glaze_name}</td>
										<td>${sampleGlaze.fineness}</td>
										<td>${sampleGlaze.creation_date}</td>
										<%--<c:if test="${glazePermission == 2}">--%>
										<td>
											<a href="<%=request.getContextPath()%>/backend/glaze/sampleGlazeController/sampleGlazeUpdatePage.do?id=${sampleGlaze.id}" title="<spring:message code="backend.operation.button.modify" />"><img src="<%=request.getContextPath()%>/images/icons/pencil.png" alt="<spring:message code="backend.operation.button.modify" />" /></a>
											<a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="showDeleteConfirm('${sampleGlaze.sample_glaze_name}', '${sampleGlaze.id}')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />" /></a>
										</td>
										<%--</c:if>--%>
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
	
		function showDeleteConfirm(glazeName, id) {
			$('#dglaze').attr("value" , glazeName);
			$('#chooseId').attr("value", id);
			$('#deleteConfirmDialog').dialog('open');
		}
		
		function confirmDelete() {
			$('#deleteConfirmDialog').dialog('close');
			var recordId = $('#chooseId').val();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/glaze/sampleGlazeController/sampleGlazeDelete.do",
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