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
<div id="successDialog" style="display: none">
	<form id="successForm" action="<%=request.getContextPath()%>/backend/glaze/productOrderController/findProductOrder.do" method="post">
		<fieldset>
			<p>
				<strong>客户</strong><input type="text" id="resultCustomer" class="text-input medium-input" readonly="readonly" /><br />
				<strong>样品釉</strong><input type="text" id="resultglazeName" class="text-input medium-input" readonly="readonly" /><br />
				<strong>干料 </strong><input type="text" id="resultContent" class="text-input medium-input" readonly="readonly" /><br />
				<strong>创建日期</strong><input type="text" id="result_creation_date" class="text-input medium-input" readonly="readonly" />
			</p>
		</fieldset>
	</form>
</div>
<div id="failureDialog" style="display: none">
	<form id="failureForm" action="<%=request.getContextPath()%>/backend/glaze/productOrderController/findProductOrder.do" method="post">
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
		<div class="content-box" style="float: left; width: 100%">
			<div class="content-box-header">
				<h3><spring:message code="backend.product_order.add.title" /></h3>
				<div class="clear"></div>
			</div>
			<div class="content-box-content">
				<div class="tab-content default-tab" id="tab1">
					<div class="notification attention png_bg">
						<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
						<div><spring:message code="backend.product_order.add.alert" /></div>
					</div>
					<c:if test="${errors != null}">
						<div class="notification error png_bg">
							<div>
								<c:forEach var="e" items="${errors}">
									<c:out value="${e.defaultMessage}" /><br />
								</c:forEach>
							</div>
						</div>
					</c:if>
					<form name="productOrder" id="form" method="post">
						<fieldset id="base" style="float: left; width: 30%" >
							<p>
								<label>客户名称 <b style="color:#FF0000"><spring:message code="backend.form.label.required" />--请先选择客户</b></label>
								<select  class="max-input" id="customer_selection" onchange="customer_change()">
									<option value="0">--</option>
									<c:forEach var="customer" items="${customerList}">
										<c:choose>
											<c:when test="${customerId==customer.id}">
												<option value="${customer.id}" selected = "selected">${customer.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${customer.id}">${customer.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</p>
							<p>
								<label>样品釉名称 <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
								<select name="sampleGlazeId" class="max-input" id="product_order_selection" onchange="product_order_change()">
									<c:if test='${sampleGlazes == null}'>
										<option value="0">--</option>
									</c:if>
									<c:if test='${sampleGlazes != null}'>
										<c:forEach var="sampleGlaze" items="${sampleGlazes}">
											<c:choose>
												<c:when test="${sampleGlazeId==sampleGlaze.id}">
													<option value="${sampleGlaze.id}" selected = "selected">${sampleGlaze.name}</option>
												</c:when>
												<c:otherwise>
													<option value="${sampleGlaze.id}">${sampleGlaze.name}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if>
								</select>
							</p>
							<p>
								<label>所需基础釉干料数量:(公斤) <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
								<input class="text-input max-input" type="text" name="content" value="0" onkeyup="product_order_change()" id="content"
									   data-validation="number" data-validation="required" data-validation-error-msg="干料数量必须为数字并且不能为空"/> <br />
							</p>
						</fieldset>
						<fieldset id="toners" style="float: left; width: 33%;">
							<p>
							<table>
								<thead>
								<tr>
									<th>色料</th>
									<th>配方</th>
									<th>实投数量</th>
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
									<th>基础釉</th>
									<th>含量</th>
									<th>实投数量</th>
								</tr>
								</thead>
								<tbody id="base_glaze"></tbody>
							</table>
							</p>
						</fieldset>
						<fieldset style="float:left; width: 100%;">
							<p>
								<input class="button" type="button" onclick="addProductOrder()" value="<spring:message code="backend.form.button.add" />" />
							</p>
						</fieldset>
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
		scrollToTopOnError : true,
		onError : function() {
			$("body").scrollTop(0);
		},
		modules : 'date, security'
	});

	$(function() {
		$('#successDialog').dialog({
			width: 500,
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
				'<spring:message code="backend.dialog.button.confirm" />': function() {
					$(this).dialog("close");
				}
			}
		});

		$('#noglazeDialog').dialog({
			width: 460,
			autoOpen: false,
			modal: true,
			title: '<spring:message code="backend.dialog.title.no_product_order" />',
			buttons: {
				'<spring:message code="backend.dialog.button.confirm" />': function() {
					$(this).dialog("close");
				}
			}
		});
	});

	function addProductOrder() {
		var data = $('#form').serialize();
		$.ajax({
			url:"<%=request.getContextPath()%>/backend/glaze/productOrderController/productOrderAdd.do",
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
				} else {
					$('#resultglazeName').attr('value',
							data.productOrder.sampleGlazeName);
					$('#resultContent').attr('value',
							data.productOrder.content);
					$('#resultCustomer').attr('value',
							data.productOrder.companyName);
					$('#result_creation_date').attr('value',
							new Date(data.productOrder.creation_date).toLocaleString());
					$('#successDialog').dialog('open');
				}
			}
		})
	}

	function customer_change() {
		var id = $('#customer_selection').val();
		$.ajax({
			url:"<%=request.getContextPath()%>/backend/glaze/productOrderController/getSampleGlazeOptions.do",
			type : "post",
			data : {customerId:id},
			datatype : "json",
			success : function(data) {
				var str = '';
				for (var i=0; i<data.length; i++) {
					str = str + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
				}
				$('#product_order_selection').html(str);
				product_order_change();
			}
		})
	}


	function product_order_change() {
		var sampleGlazeId = $('#product_order_selection').val();
		var content = $("#content").val();
		$('#toner').html("");
		$('#base_glaze').html("");
		$.ajax({
			url:"<%=request.getContextPath()%>/backend/glaze/productOrderController/getTonerAndBaseGlaze.do",
			type : "post",
			data : {sampleGlazeId:sampleGlazeId},
			datatype : "json",
			success : function(data) {
				var toners = data.toners;
				for (var i=0; i<toners.length; i++) {
					$('#toner').append(
							'<tr>' +
							'<td>' + toners[i].name + '</td>' +
							'<td>' + toners[i].content + '</td>' +
							'<td>' + (toners[i].content * content *10) + "克"+'</td>' +
							'</tr>'
					);
				}
				var baseGlazes = data.baseGlazes;
				for (var i=0; i<baseGlazes.length; i++) {
					$('#base_glaze').append(
							'<tr>' +
							'<td>' + baseGlazes[i].name + '</td>' +
							'<td>' + baseGlazes[i].content + '</td>' +
							'<td>' + ((content * baseGlazes[i].content/100) / ((100-baseGlazes[i].water_content)/100)).toFixed(3) + "公斤"+'</td>' +
							'</tr>'
					);
				}
			}
		})
	}

	function removeRecord(id) {
		$('#'+id).remove();
	}
</script>
</body>
</html>