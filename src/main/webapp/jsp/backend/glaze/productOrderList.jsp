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
		<form name="criteria" id="form" action="<%=request.getContextPath()%>/backend/glaze/productOrderController/findProductOrder.do" method="post">
			<fieldset>
				<p>
					客户<input class="text-input small-input" type="text" name="companyName" value="${criteria.companyName}" /><br />
					样品釉名称 <input class="text-input small-input" type="text" name="sampleGlazeName" value="${criteria.sampleGlazeName}" /><br />
					<input name="pagination.pageSize" type="hidden" id="pageSize" value="${criteria.pagination.pageSize}" />
					<input name="pagination.currentPage" type="hidden" id="page" value="${criteria.pagination.currentPage}" />
					<span id="dayTypeOption1">
						<spring:message code="backend.promotionStatistics.list.search.date.from" />
						<input class="text-input small-input" type="text" id="searchStartDay" name="searchStartDay" onclick="WdatePicker()" readonly="readonly" value="${criteria.searchStartDay}" />
						<spring:message code="backend.promotionStatistics.list.search.date.to" />
						<input class="text-input small-input" type="text" id="searchEndDay" name="searchEndDay" onclick="WdatePicker()" readonly="readonly" value="${criteria.searchEndDay}" />
					</span>
				</p>
			</fieldset>
		</form>
	</div>
	<div id="deleteConfirmDialog" style="display: none">
		<form>
			<fieldset>
				<p>
					<strong>客户名称</strong>
					<input class="text-input medium-input" type="text" id="dcustomer" readonly="readonly" /><br />
				</p>
				<p>
					<strong>样品釉名称</strong>
					<input class="text-input medium-input" type="text" id="dglaze" readonly="readonly" /><br /> 
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
					<h3>投料单管理</h3>
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
										<a class="button" href="<%=request.getContextPath()%>/backend/glaze/productOrderController/productOrderAddPage.do">添加投料单</a>
									<%--</c:if>--%>
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<th><spring:message code="backend.base_glaze.list.column.id" /></th>
									<th>样品釉名称</th>
									<th>客户</th>
									<th>生产日期</th>
									<th>样品釉日期</th>
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
								<c:forEach var="productOrder" items="${productOrderList}">
									<tr>
										<td>${productOrder.id}</td>
										<td>${productOrder.sample_glaze_name}</td>
										<td>${productOrder.company_name}</td>
										<td>${productOrder.product_date}</td>
										<td>${productOrder.creation_date}</td>


									<%--<c:if test="${glazePermission == 2}">--%>
										<td>
											<a href="<%=request.getContextPath()%>/backend/glaze/productOrderController/productOrderUpdatePage.do?id=${productOrder.id}" title="<spring:message code="backend.operation.button.modify" />"><img src="<%=request.getContextPath()%>/images/icons/pencil.png" alt="<spring:message code="backend.operation.button.modify" />" /></a>
											<a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="showDeleteConfirm('${productOrder.company_name}','${productOrder.sample_glaze_name}','${productOrder.id}')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />" /></a>

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
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/common/My97DatePicker/WdatePicker.js"></script>
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
	
		function showDeleteConfirm(customer,glazeName, id) {
			$('#dcustomer').attr("value" , customer);
			$('#dglaze').attr("value" , glazeName);
			$('#chooseId').attr("value", id);
			$('#deleteConfirmDialog').dialog('open');
		}
		
		function confirmDelete() {
			$('#deleteConfirmDialog').dialog('close');
			var recordId = $('#chooseId').val();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/glaze/productOrderController/productOrderDelete.do",
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