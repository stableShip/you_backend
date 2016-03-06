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
		<form name="criteria" id="form" action="<%=request.getContextPath()%>/backend/ad/gamecenterAdController/gamecenterAdList.do" method="post">
			<fieldset>
				<p>
					游戏名称 <input class="text-input small-input" type="text" name="searchGamecenterAdName" value="${criteria.searchGamecenterAdName}" /><br /> 
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
					<strong><spring:message code="backend.gamecenterAd.list.column.name" /></strong>
					<input class="text-input medium-input" type="text" id="dGamecenterAd" readonly="readonly" /><br /> 
				</p>
				<p>
					<strong><spring:message code="backend.dialog.message.deleteAlert" /></strong> <br /> 
				</p>
			</fieldset>
		</form>
	</div>
	<div id="IndexChangeDialog">
		<form id="updateShowIndex">
			<fieldset>
				<p>
					<input type="hidden" name="id" id="id" value="0"></input>
					<strong><spring:message code="backend.gamecenterAd.update.column.originalIndex" /></strong>
					<input class="text-input medium-input" type="text" name="originalIndex" id="originalIndex"  readonly="readonly" /><br /> 
					<strong><spring:message code="backend.gamecenterAd.update.column.newShowIndex" /></strong>
					<input class="text-input medium-input" type="text" id="showIndex" name="showIndex"  /><br /> 
				</p>
				<p>
					<strong><spring:message code="backend.dialog.message.updateAlert" /></strong> <br /> 
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
	
	<div id="successChangeDialog">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.dialog.title.updateSuccess" /></strong> <br /> 
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
	<div id="failureChangeDialog">
		<form>
			<fieldset>
				<p>
					<strong><spring:message code="backend.dialog.title.updateFailure" /></strong> <br /> 
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
					<h3>游戏中心广告设置</h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.gamecenterAd.list.alert" /></div>
						</div>
						<form>
							<fieldset>
								<p>
									<a class="button" href="#" onclick="javascript:$('#searchDialog').dialog('open');">搜索条件</a>
									<c:if test="${gamecenterAdPermission == 2}">
										<a class="button" href="<%=request.getContextPath()%>/backend/ad/gamecenterAdController/gamecenterAdAddPage.do">添加游戏中心广告</a>
									</c:if>
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<th>顺序</th>
									<th>游戏名称</th>
									<th>应用图标</th>
									<th>宣传语</th>
									
									<c:if test="${gamecenterAdPermission == 2}"><th><spring:message code="backend.gamecenterAd.list.column.operation" /></th></c:if>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="7">
										<div class="pagination">
											<%@include file="../common/page.jsp"%>
										</div> 
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
								<input type="hidden" id="chooseId" value="0"></input>
							<tbody>
								<c:forEach var="g" items="${gamecenterAdList}">
									<tr>
									<td>${g.showIndex}</td>
										<td>${g.name}</td>
										<td><img src="${g.iconUrl}" style="width:40px;height:40px"></img></td>
										<td>${g.promotionWord}</td>
										<c:if test="${gamecenterAdPermission == 2}"><td>
											<a href="#" title="<spring:message code="backend.gamecenterAd.update.column.showIndex" />" onclick="showIndexChangeDialog('${g.showIndex}', '${g.id}')"><img src="<%=request.getContextPath()%>/images/icons/pencil.png" alt="<spring:message code="backend.operation.button.delete" />" /></a>
											<a href="<%=request.getContextPath()%>/backend/ad/gamecenterAdController/gamecenterAdUpdatePage.do?id=${g.id}" title="<spring:message code="backend.operation.button.modify" />"><img src="<%=request.getContextPath()%>/images/icons/pencil.png" alt="<spring:message code="backend.operation.button.modify" />" /></a> 
											<a href="#" title="<spring:message code="backend.operation.button.delete" />" onclick="showDeleteConfirm('${g.name}', '${g.id}')"><img src="<%=request.getContextPath()%>/images/icons/cross.png" alt="<spring:message code="backend.operation.button.delete" />" /></a>
										</td></c:if>
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
			
			$('#IndexChangeDialog').dialog({
		        width: 500,
		        autoOpen: false,
		        modal: true,
		        title: '<spring:message code="backend.dialog.title.alert" />',
		        buttons: {
	        		'<spring:message code="backend.dialog.button.confirm" />':function(){
	        			confirmChange();
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
			$('#successChangeDialog').dialog({
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
	
		function showDeleteConfirm(gamecenterAdName, id) {
			$('#dGamecenterAd').attr("value", gamecenterAdName);
			$('#chooseId').attr("value", id);
			$('#deleteConfirmDialog').dialog('open');
		}
		
		function showIndexChangeDialog(originalIndex,id){
			$('#originalIndex').attr("value", originalIndex);
			$('#id').attr("value", id);
			$('#IndexChangeDialog').dialog('open');
			
		}
		
		function confirmDelete() {
			$('#deleteConfirmDialog').dialog('close');
			var recordId = $('#chooseId').val();
		
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/ad/gamecenterAdController/gamecenterAdDelete.do",
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
		
		function confirmChange() {
			$('#IndexChangeDialog').dialog('close');
			var data=$('#updateShowIndex').serialize();
			$.ajax({
				url:"<%=request.getContextPath()%>/backend/ad/gamecenterAdController/changeShowIndex.do",
				type:"post",
				data:data,
				datatype:"json",
				success:function(data){
					if(data == 0) {
						$('#failureDeleteDialog').dialog('open');
					}
					else {
						$('#successChangeDialog').dialog('open');
					}
				}
			});
		}
	</script>
</body>
</html>