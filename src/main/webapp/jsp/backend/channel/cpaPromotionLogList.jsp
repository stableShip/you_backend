<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="backend.login.title" /></title>
<jsp:include page="../common/common.jsp" flush="true" />
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/common/My97DatePicker/WdatePicker.js"></script>
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
					<h3><spring:message code="backend.promotionLog.list.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.promotionLog.list.alert" /></div>
						</div>
						<form name="criteria" id="form" action="<%=request.getContextPath()%>/backend/channel/cpaPromotionLogController/cpaPromotionLogList.do" method="post">
							<fieldset>
								<p>
									<spring:message code="backend.promotionLog.list.search.date.from" />&nbsp;
									<input class="text-input small-input" type="text" onclick="WdatePicker()" readonly="readonly" name="searchStartTime" id="searchStartTime" value="${criteria.searchStartTime}"/>
									<spring:message code="backend.promotionLog.list.search.date.to" />&nbsp;
									<input class="text-input small-input" type="text" onclick="WdatePicker()" readonly="readonly" name="searchEndTime" id="searchEndTime" value="${criteria.searchEndTime}"/> <br />
									<spring:message code="backend.promotionLog.list.search.app.name" /> 
									<input class="text-input small-input" type="text" name="searchAppName" value="${criteria.searchAppName}"/> <br />
									<spring:message code="backend.promotionLog.list.search.app.nickname" /> 
									<input class="text-input small-input" type="text" name="searchAppNickName" value="${criteria.searchAppNickName}"/>
									<input class="button" type="submit" value="<spring:message code="backend.form.button.search" />" /><br /> 
									<input name="pagination.pageSize" type="hidden" id="pageSize" value="${criteria.pagination.pageSize}" />
									<input name="pagination.currentPage" type="hidden" id="page" value="${criteria.pagination.currentPage}" />
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<th><spring:message code="backend.promotionLog.list.column.time" /></th>
									<th><spring:message code="backend.promotionLog.list.channel.name" /></th>
									<th><spring:message code="backend.promotionLog.list.app.name" /></th>
									<th><spring:message code="backend.promotionLog.list.app.nickname" /></th>
									<!-- <th>CPS百分比</th> -->
									<th><spring:message code="backend.promotionLog.list.price.cpa.sameday" /></th>
									<th><spring:message code="backend.promotionLog.list.price.cpa.nextday" /></th>
									<!-- <th>CPT价格</th> -->
									<th><spring:message code="backend.promotionLog.list.operator" /></th>
									<th><spring:message code="backend.promotionLog.list.operation" /></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="8">
										<div class="pagination">
											<%@include file="../common/page.jsp"%>
										</div>
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="p" items="${promotionLogList}">
									<tr>
										<td>${p.date}</td>
										<td>${p.channelName}</td>
										<td>${p.appName}</td>
										<td><span style="color:red">${p.appNickName}</span> (${p.beforeAppNickName})</td>
										<td><span style="color:red">${p.sameDayPrice}</span> (${p.beforeSameDayPrice})</td>
										<td><span style="color:red">${p.nextDayPrice}</span> (${p.beforeNextDayPrice})</td>
										<td>${p.operaterName}</td>
										<td><c:if test="${p.operaterType == 0}"><spring:message code="backend.promotionLog.list.operation.insert" /></c:if>
										<c:if test="${p.operaterType == 1}"><spring:message code="backend.promotionLog.list.operation.update" /></c:if>
										<c:if test="${p.operaterType == 2}"><spring:message code="backend.promotionLog.list.operation.delete" /></c:if></td>
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
		$().ready(function() {
		 	if(${criteria.searchStartTime == null}) {
		 		setDefaultDay();
		 	}
		});
	
		function setDefaultDay() {
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			if(month < 10){
				month = "0" + month;
			}
			var day = date.getDate();
			if(day < 10){
				day = "0" + day;
			}
			$('#searchStartTime').attr("value", year + "-" + month + "-" + day);
			$('#searchEndTime').attr("value", year + "-" + month + "-" + day);
		}
	</script>
</body>
</html>