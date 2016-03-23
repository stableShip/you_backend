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
					客户<input class="text-input max-input" type="text" name="companyName" value="${criteria.companyName}" /><br />
					样品釉名称 <input class="text-input max-input" type="text" name="sampleGlazeName" value="${criteria.sampleGlazeName}" /><br />
					<input name="pagination.pageSize" type="hidden" id="pageSize" value="${criteria.pagination.pageSize}" />
					<input name="pagination.currentPage" type="hidden" id="page" value="${criteria.pagination.currentPage}" />
					<span id="dayTypeOption1">
						<spring:message code="backend.promotionStatistics.list.search.date.from" />
						<input class="text-input max-input" type="text" id="searchStartDay" name="searchStartDay" onclick="WdatePicker()" readonly="readonly" value="${criteria.searchStartDay}" />
						<spring:message code="backend.promotionStatistics.list.search.date.to" />
						<input class="text-input max-input" type="text" id="searchEndDay" name="searchEndDay" onclick="WdatePicker()" readonly="readonly" value="${criteria.searchEndDay}" />
					</span>
				</p>
			</fieldset>
		</form>
	</div>
    <div id="informationDialog" style="display: none">
        <form name="productOrder"  method="post">
            <fieldset id="base" style="float: left; width: 30%" >
                <strong>客户</strong><input type="text" id="resultCustomer" class="text-input medium-input" readonly="readonly" /><br />
                <strong>样品釉</strong><input type="text" id="resultglazeName" class="text-input medium-input" readonly="readonly" /><br />
                <strong>干料 </strong><input type="text" id="resultContent" class="text-input medium-input" readonly="readonly" /><br />
                <strong>创建日期</strong><input type="text" id="result_creation_date" class="text-input medium-input" readonly="readonly" />
            </fieldset>
            <fieldset id="toners" style="float: left; width: 33%;">
                <p>
                <table>
                    <thead>
                    <tr>
                        <th>色料&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        <th>配方&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        <th>实投数量&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody id="toner"></tbody>
                </table>
                </p>
            </fieldset>
            <fieldset id="baseGlazes" style="float: right; width: 33%;">
                <p>
                <table>
                    <thead>
                    <tr>
                        <th>基础釉&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        <th>含量&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        <th>实投数量&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody id="base_glaze"></tbody>
                </table>
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
									<c:if test="${productOrderPermission == 2}">
										<a class="button" href="<%=request.getContextPath()%>/backend/glaze/productOrderController/productOrderAddPage.do">添加投料单</a>
									</c:if>
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<th><spring:message code="backend.base_glaze.list.column.id" /></th>
									<th>客户</th>
									<th>样品釉名称</th>
									<th>干料(公斤)</th>
									<th>生产日期</th>
									<th>样品釉日期</th>
								<c:if test="${productOrderPermission == 2}">
										<th><spring:message code="backend.glaze.list.column.operation" /></th>
									</c:if>
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
										<td>${productOrder.company_name}</td>
										<td>${productOrder.sample_glaze_name}</td>
										<td>${productOrder.content}</td>
										<td>${productOrder.product_date}</td>
										<td>${productOrder.creation_date}</td>

									<c:if test="${productOrderPermission == 2}">
										<td>
											<a href="#" title="<spring:message code="backend.operation.button.viewDetail" />" onclick="viewDetail(${productOrder.id})"><img src="<%=request.getContextPath()%>/images/icons/text.png" alt="<spring:message code="backend.operation.button.viewDetail" />" /></a>
											<a href="<%=request.getContextPath()%>/backend/glaze/productOrderController/productOrderUpdatePage.do?id=${productOrder.id}" title="<spring:message code="backend.operation.button.modify" />"><img src="<%=request.getContextPath()%>/images/icons/pencil.png" alt="<spring:message code="backend.operation.button.modify" />" /></a>
											<a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="showDeleteConfirm('${productOrder.company_name}','${productOrder.sample_glaze_name}','${productOrder.id}')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />" /></a>

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
            $('#informationDialog').dialog({
                width: 700,
                autoOpen: false,
                modal: true,
                title: '<spring:message code="backend.dialog.title.information" />',
                buttons: {
                    '<spring:message code="backend.dialog.button.confirm" />':function(){
                        $("#toner").html("");
                        $("#base_glaze").html("");
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
		function viewDetail(recordId) {
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/glaze/productOrderController/viewDetail.do",
				type:"post",
				data:{id:recordId},
				datatype:"json",
				success:function(data){
                    $('#resultglazeName').attr('value',
                            data.productOrder.sampleGlazeName);
                    $('#resultContent').attr('value',
                            data.productOrder.content);
                    $('#resultCustomer').attr('value',
                            data.productOrder.companyName);
                    $('#result_creation_date').attr('value',
                            new Date(data.productOrder.creation_date).toLocaleString());
                    var content = data.productOrder.content;
					var toners = data.sampleGlaze.toners;
					var baseGlazes = data.sampleGlaze.baseGlazes;
					for(var i =0; i< toners.length;i++) {
						if(JSON.stringify(toners[i])!="{}") {
                            $('#toner').append(
                                    '<tr>' +
                                    '<td>' + toners[i].name + '</td>' +
                                    '<td>' + toners[i].content + '</td>' +
                                    '<td>' + (toners[i].content * content *10) + "克"+'</td>' +
                                    '</tr>'
                            );
						}
					}
					for(var i =0; i< baseGlazes.length;i++) {
						if(JSON.stringify(baseGlazes[i])!="{}") {
                            $('#base_glaze').append(
                                    '<tr>' +
                                    '<td>' + baseGlazes[i].name + '</td>' +
                                    '<td>' + baseGlazes[i].content + '</td>' +
                                    '<td>' + ((content * baseGlazes[i].content/100) / ((100-baseGlazes[i].water_content)/100)).toFixed(3) + "公斤"+'</td>' +
                                    '</tr>'
                            );
						}
					}
					$('#informationDialog').dialog('open');
				}
			})}
	</script>
</body>
</html>