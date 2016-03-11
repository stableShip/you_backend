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
		<form id="successForm" action="<%=request.getContextPath()%>/backend/glaze/sampleGlazeController/findSampleGlaze.do" method="post">
			<fieldset>
				<p>
					<strong><spring:message code="backend.sample_glaze.add.label.name" />&nbsp;&nbsp;&nbsp; </strong><input type="text" id="resultglazeName" class="text-input medium-input" readonly="readonly" /><br />
					<strong><spring:message code="backend.sample_glaze.add.label.fineness" /> </strong><input type="text" id="resultFineness" class="text-input medium-input" readonly="readonly" /><br />
					<strong><spring:message code="backend.glaze.add.label.comment" /> </strong><input type="text" id="resultComment" class="text-input medium-input" readonly="readonly" />
				</p>
			</fieldset>
		</form>
	</div>
	<div id="failureDialog" style="display: none">
		<form id="failureForm" action="<%=request.getContextPath()%>/backend/glaze/sampleGlazeController/findSampleGlaze.do" method="post">
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
					<h3><spring:message code="backend.sample_glaze.add.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.sample_glaze.add.alert" /></div>
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
						<form name="sampleGlaze" id="form" method="post">
							<fieldset id="base" style="float: left; width: 30%" >
								<input type="hidden" name="id" value="${glaze.id}" />
								<p>
									<label><spring:message code="backend.sample_glaze.add.label.name" /> <b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<input class="text-input small-input" type="text" name="name" value="${glaze.name}"
										 data-validation="required" data-validation-error-msg="<spring:message code="backend.sample_glaze.add.err-message.name" />"/> <br />
								</p>

								<p>
									<label><spring:message code="backend.company.list.column.name" /><b style="color:#FF0000"><spring:message code="backend.form.label.required" /></b></label>
									<select name="customer_id" class="small-input">
										<option value="0">--</option>
										<c:forEach var="customer" items="${customerList}">
											<option value="${customer.id}">${customer.name}</option>
										</c:forEach>
									</select> <br />
								</p>
								<p>
									<label><spring:message code="backend.sample_glaze.add.label.fineness" /> </label>
									<input class="text-input small-input" type="text" name="fineness" value="${glaze.fineness}"
                                           data-validation="number" data-validation="required" data-validation-error-msg="<spring:message code="backend.glaze.add.err-message.fineness" />"/> <br />
								</p>
							</fieldset>
							<fieldset id="toners" style="float: left; width: 33%;">
								<p>
									<div style="float: left; width: 55%">
									<label>色料名称</label>

									<select id="toner_id" style="width: 100%">
										<option value="0">--</option>
										<c:forEach var="toner" items="${tonerList}">
											<option value="${toner.id}">${toner.name}</option>
										</c:forEach>
									</select>
									</div>
									<div style="float: right; width: 45%">
									<label>配方（%）</label>
									<input class="text-input small-input" type="text"  id="toner_content"
										   data-validation="number"  data-validation="required" data-validation-error-msg="<spring:message code="backend.sample_glaze.add.err-message.name" />"/>
									<input class="button" type="button" onclick="addToner()" value="添加" />
									</div>
								</p>
								<p>
								<table>
									<thead>
									<tr>
										<th>色料</th>
										<th>配方</th>
										<th><spring:message code="backend.channel.list.column.operation" /></th>
									</tr>
									</thead>
									<tbody id="toner"></tbody>
								</table>
								</p>
							</fieldset>
							<fieldset id="baseGlazes" style="float: right; width: 33%;">
								<p>
									<div style="float: left; width: 55%">
									<label>基础釉名称</label>
									<select  name="base_glaze_id" id="base_glaze_id" style="width: 100%">
										<option value="0">--</option>
										<c:forEach var="baseGlaze" items="${baseGlazeList}">
											<option value="${baseGlaze.id}">${baseGlaze.name}</option>
										</c:forEach>
									</select>
									</div>
									<div style="float: left; width: 45%">
										<label>含量（%）</label>
										<input class="text-input small-input" type="text" id="base_glaze_content"
											   data-validation="number"  data-validation="required" data-validation-error-msg="<spring:message code="backend.sample_glaze.add.err-message.name" />"/>
										<input class="button" type="button" onclick="addBaseGlaze()" value="添加" />
									</div>
								</p>

								<p>
								<table>
									<thead>
									<tr>
										<th>基础釉</th>
										<th>含量</th>
										<th><spring:message code="backend.channel.list.column.operation" /></th>
									</tr>
									</thead>
									<tbody id="base_glaze"></tbody>
								</table>
								</p>
							</fieldset>
							<fieldset style="float:left; width: 100%;">
							<p>
								<input class="button" type="button" onclick="addSampleGlaze()" value="<spring:message code="backend.form.button.add" />" />
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
		            '<spring:message code="backend.dialog.button.backToList" />': function() { 
		            	$('#failureForm').submit();
		            },
		            '<spring:message code="backend.dialog.button.confirm" />': function() {
		            	$(this).dialog("close"); 
		            } 
		         }
		      });
			
			$('#noglazeDialog').dialog({
		        width: 460,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.no_sample_glaze" />',
		        buttons: {
		            '<spring:message code="backend.dialog.button.confirm" />': function() { 
		            	$(this).dialog("close"); 
		            } 
		         }
		      });
		});
		
		function addSampleGlaze() {
			var data = $('#form').serialize();
			var toners = $('#toner:input,:hidden').serialize();
			console.log(data,toners)
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/glaze/sampleGlazeController/sampleGlazeAdd.do",
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
								data.sampleGlaze.name);
						$('#resultFineness').attr('value',
								data.sampleGlaze.fineness);
						$('#successDialog').dialog('open');
					}
				}
			})
		}

		function addToner() {
			var id = $('#toner_id').val();
			var content = $('#toner_content').val();
			var tag = "#toner_"+id;
			if(!$('#toner_content').val()){
				return;
			}
			if ($(tag).length>0){
				$("#theErrorMessage").html("不能添加相同的色料");
				$('#failureDialog').dialog('open');
				return;
			}
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/toner/tonerController/getTonerById.do",
				type : "post",
				data : {id:id},
				datatype : "json",
				success : function(data) {
					$('#toner').append(
							'<tr id="' +"toner_" + data.id + '">' +
							'<input type="hidden" name="toners['+ data.id+'].id" value='+data.id+' />' +
							'<input type="hidden" name="toners['+ data.id+'].content" value='+content+' />' +
							'<td>' + data.name + '</td>' +
							'<td>' + content + '</td>' +
							'<td><a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="removeRecord('+"'"+'toner_'+ data.id +"'"+ ')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />" /></a></td>' +
							'</tr>'
					);
				}
			})
		}

		function addBaseGlaze() {
			var id = $('#base_glaze_id').val();
			var content = $('#base_glaze_content').val();
			if(!$('#base_glaze_content').val()){
				return;
			}
			var tag = "#base_glaze_"+id;
			if ($(tag).length>0){
				$("#theErrorMessage").html("不能添加相同的基础釉");
				$('#failureDialog').dialog('open');
				return;
			}

			$.ajax({
				url:"<%=request.getContextPath()%>/backend/glaze/baseGlazeController/getBaseGlazeById.do",
				type : "post",
				data : {id:id},
				datatype : "json",
				success : function(data) {
					$('#base_glaze').append(
							'<tr id="' +"baseGlaze_" + data.id + '">' +
							'<input type="hidden" name="baseGlazes['+ data.id+'].id" value='+data.id+' />' +
							'<input type="hidden" name="baseGlazes['+ data.id+'].content" value='+content+' />' +
							'<td>' + data.name + '</td>' +
							'<td>' + content + '</td>' +
							'<td><a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="removeRecord('+"'"+'baseGlaze_'+ data.id +"'"+ ')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />" /></a></td>' +
							'</tr>'
					);
				}
			})
		}

		function removeRecord(id) {
			$('#'+id).remove();
		}
	</script>
</body>
</html>