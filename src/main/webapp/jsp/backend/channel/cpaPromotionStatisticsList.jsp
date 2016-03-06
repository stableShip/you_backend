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
	<div id="searchDialog">
		<form name="criteria" id="form" action="<%=request.getContextPath()%>/backend/channel/cpaPromotionStatisticsController/cpaPromotionStatisticsList.do" method="post">
			<fieldset>
				<p>
					<input type="radio" name="searchDataType" checked="checked" onclick="onClickCheckBox(0)" value="0" <c:if test="${criteria.searchDataType == 0}">checked="checked"</c:if> />
					<spring:message code="backend.promotionStatistics.list.search.type.day" />
					<input type="radio" name="searchDataType" onclick="onClickCheckBox(1)" value="1" <c:if test="${criteria.searchDataType == 1}">checked="checked"</c:if> />
					<spring:message code="backend.promotionStatistics.list.search.type.month" /><br />
					<span id="dayTypeOption1">
						<spring:message code="backend.promotionStatistics.list.search.date.from" /> 
						<input class="text-input small-input" type="text" id="searchStartDay" name="searchStartDay" onclick="WdatePicker()" readonly="readonly" value="${criteria.searchStartDay}" /> 
						<spring:message code="backend.promotionStatistics.list.search.date.to" />  
						<input class="text-input small-input" type="text" id="searchEndDay" name="searchEndDay" onclick="WdatePicker()" readonly="readonly" value="${criteria.searchEndDay}" />
					</span>
					<span id="monthTypeOption1">
						<spring:message code="backend.promotionStatistics.list.search.date.from" /> 
						<input class="text-input small-input" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM'})" id="searchStartMonth" readonly="readonly" name="searchStartMonth" value="${criteria.searchStartMonth}" />
						<spring:message code="backend.promotionStatistics.list.search.date.to" />  
						<input class="text-input small-input" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM'})" id="searchEndMonth" readonly="readonly" name="searchEndMonth" value="${criteria.searchEndMonth}" />
					</span>
				</p>
				<p>
					<c:if test="${account.internal == true}">
						<spring:message code="backend.promotionStatistics.list.search.channel.name" /> 
						<input class="text-input small-input" type="text" name="searchChannelName" value="${criteria.searchChannelName}" /> <br />
						<spring:message code="backend.promotionStatistics.list.search.app.name" /> 
						<input class="text-input small-input" type="text" name="searchAppName" value="${criteria.searchAppName}" /> <br />
						<spring:message code="backend.promotionStatistics.list.search.app.nickname" /> 
						<input class="text-input small-input" type="text" name="searchAppNickName" value="${criteria.searchAppNickName}" /> <br />
						<spring:message code="backend.promotionStatistics.list.search.sort.type" />&nbsp;&nbsp;&nbsp;
						<select name="searchOrderByColumn" class="small-input">
							<option value="0" <c:if test="${criteria.searchOrderByColumn == 0}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.sameday.five" /></option>
							<option value="1" <c:if test="${criteria.searchOrderByColumn == 1}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.sameday.ten" /></option>
							<option value="2" <c:if test="${criteria.searchOrderByColumn == 2}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.sameday.fifteen" /></option>
							<option value="3" <c:if test="${criteria.searchOrderByColumn == 3}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.sameday.twenty" /></option>
							<option value="4" <c:if test="${criteria.searchOrderByColumn == 4}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.sameday.twentyFive" /></option>
							<option value="5" <c:if test="${criteria.searchOrderByColumn == 5}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.sameday.thirty" /></option>
							<option value="6" <c:if test="${criteria.searchOrderByColumn == 6}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.nextday.five" /></option>
							<option value="7" <c:if test="${criteria.searchOrderByColumn == 7}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.nextday.ten" /></option>
							<option value="8" <c:if test="${criteria.searchOrderByColumn == 8}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.nextday.fifteen" /></option>
							<option value="9" <c:if test="${criteria.searchOrderByColumn == 9}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.nextday.twenty" /></option>
							<option value="10" <c:if test="${criteria.searchOrderByColumn == 10}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.nextday.twentyFive" /></option>
							<option value="11" <c:if test="${criteria.searchOrderByColumn == 11}">selected="selected"</c:if>><spring:message code="backend.promotionStatistics.list.column.time.nextday.thirty" /></option>
						</select>
					</c:if>
					<c:if test="${account.internal == false}">
						<spring:message code="backend.promotionStatistics.list.search.app.name" />  
						<input class="text-input small-input" type="text" name="searchAppNickName" value="${criteria.searchAppNickName}" />
					</c:if>
					<input name="pagination.pageSize" type="hidden" id="pageSize" value="${criteria.pagination.pageSize}" />
					<input name="pagination.currentPage" type="hidden" id="page" value="${criteria.pagination.currentPage}" />
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
					<h3><spring:message code="backend.promotionStatistics.list.title" /></h3>
					<div class="clear"></div>
				</div>
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<div class="notification attention png_bg">
							<a href="#" class="close"><img
								src="<%=request.getContextPath()%>/images/icons/cross_grey_small.png"
								title="Close this notification" alt="close" /></a>
							<div><spring:message code="backend.promotionStatistics.list.alert" /></div>
						</div>
						<form>
							<fieldset>
								<p>
									<a class="button" href="#" onclick="javascript:$('#searchDialog').dialog('open');">搜索条件</a>
								</p>
								<p>
									<span id="dayTypeOption2">
										<spring:message code="backend.promotionStatistics.list.search.date.from" /> 
										<input class="text-input small-input" type="text"  name="searchStartDay" readonly="readonly" value="${criteria.searchStartDay}" /> 
										<spring:message code="backend.promotionStatistics.list.search.date.to" />  
										<input class="text-input small-input" type="text" name="searchEndDay" readonly="readonly" value="${criteria.searchEndDay}" />
									</span>
									<span id="monthTypeOption2">
										<spring:message code="backend.promotionStatistics.list.search.date.from" /> 
										<input class="text-input small-input" type="text"  readonly="readonly" name="searchStartMonth" value="${criteria.searchStartMonth}" />
										<spring:message code="backend.promotionStatistics.list.search.date.to" />  
										<input class="text-input small-input" type="text"  readonly="readonly" name="searchEndMonth" value="${criteria.searchEndMonth}" />
									</span>
								</p>
							</fieldset>
						</form>
						<table>
							<thead>
								<tr>
									<c:if test="${account.internal == true}">
										<th><spring:message code="backend.promotionStatistics.list.column.channel.name" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.price.sameday" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.price.nextday" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.app.name" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.app.nickname" /></th>
										<th>启动游戏</th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.sameday.five" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.sameday.ten" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.sameday.fifteen" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.sameday.twenty" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.sameday.twentyFive" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.sameday.thirty" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.nextday.five" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.nextday.ten" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.nextday.fifteen" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.nextday.twenty" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.nextday.twentyFive" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.time.nextday.thirty" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.cost" /></th>
									</c:if>
									<c:if test="${account.internal == false}">
										<th><spring:message code="backend.promotionStatistics.list.column.channel.name" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.app.name" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.count.active" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.count.nextday.active" /></th>
										<th><spring:message code="backend.promotionStatistics.list.column.income" /></th>
									</c:if>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="19">
										<div class="bulk-actions align-left">
											<%-- <c:if test="${administrator.internal == true}"> <a class="button" onclick="showReport()" href="#">导出EXCEL</a> </c:if> --%>
										</div>
										<div class="pagination">
											<%@include file="../common/page.jsp"%>
										</div>
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="p" items="${promotionStatisticsList}">
									<tr>
										<c:if test="${account.internal == true}">
											<td>${p.channelName}</td>
											<td>${p.sameDayPrice}<spring:message code="backend.promotionStatistics.list.unit" /></td>
											<td>${p.nextDayPrice}<spring:message code="backend.promotionStatistics.list.unit" /></td>
											<td>${p.appName}</td>
											<td>${p.appNickName}</td>
											<td>${p.sameZero}</td>
											<td>
												<c:if test="${p.sameDayTime == 0}"><p style="color:#FF0000">${p.sameFive}</p></c:if>
												<c:if test="${p.sameDayTime != 0}">${p.sameFive}</c:if>
											</td>
											<td>
												<c:if test="${p.sameDayTime == 1}"><p style="color:#FF0000">${p.sameTen}</p></c:if>
												<c:if test="${p.sameDayTime != 1}">${p.sameTen}</c:if>
											</td>
											<td>
												<c:if test="${p.sameDayTime == 2}"><p style="color:#FF0000">${p.sameFifteen}</p></c:if>
												<c:if test="${p.sameDayTime != 2}">${p.sameFifteen}</c:if>
											</td>
											<td>
												<c:if test="${p.sameDayTime == 3}"><p style="color:#FF0000">${p.sameTwenty}</p></c:if>
												<c:if test="${p.sameDayTime != 3}">${p.sameTwenty}</c:if>
											</td>
											<td>
												<c:if test="${p.sameDayTime == 4}"><p style="color:#FF0000">${p.sameTwentyFive}</p></c:if>
												<c:if test="${p.sameDayTime != 4}">${p.sameTwentyFive}</c:if>
											</td>
											<td>
												<c:if test="${p.sameDayTime == 5}"><p style="color:#FF0000">${p.sameThirty}</p></c:if>
												<c:if test="${p.sameDayTime != 5}">${p.sameThirty}</c:if>
											</td>
											<td>
												<c:if test="${p.nextDayTime == 0}"><p style="color:#FF0000">${p.nextFive}</p></c:if>
												<c:if test="${p.nextDayTime != 0}">${p.nextFive}</c:if>
											</td>
											<td>
												<c:if test="${p.nextDayTime == 1}"><p style="color:#FF0000">${p.nextTen}</p></c:if>
												<c:if test="${p.nextDayTime != 1}">${p.nextTen}</c:if>
											</td>
											<td>
												<c:if test="${p.nextDayTime == 2}"><p style="color:#FF0000">${p.nextFifteen}</p></c:if>
												<c:if test="${p.nextDayTime != 2}">${p.nextFifteen}</c:if>
											</td>
											<td>
												<c:if test="${p.nextDayTime == 3}"><p style="color:#FF0000">${p.nextTwenty}</p></c:if>
												<c:if test="${p.nextDayTime != 3}">${p.nextTwenty}</c:if>
											</td>
											<td>
												<c:if test="${p.nextDayTime == 4}"><p style="color:#FF0000">${p.nextTwentyFive}</p></c:if>
												<c:if test="${p.nextDayTime != 4}">${p.nextTwentyFive}</c:if>
											</td>
											<td>
												<c:if test="${p.nextDayTime == 5}"><p style="color:#FF0000">${p.nextThirty}</p></c:if>
												<c:if test="${p.nextDayTime != 5}">${p.nextThirty}</c:if>
											</td>
											<td>
												<c:if test="${p.sameDayTime == 0}">${p.sameFive*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 1}">${p.sameTen*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 2}">${p.sameFifteen*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 3}">${p.sameTwenty*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 4}">${p.sameTwentyFive*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 5}">${p.sameThirty*p.sameDayPrice}</c:if>
												 + 
												<c:if test="${p.nextDayTime == 0}">${p.nextFive*p.nextDayPrice}</c:if>
												<c:if test="${p.nextDayTime == 1}">${p.nextTen*p.nextDayPrice}</c:if>
												<c:if test="${p.nextDayTime == 2}">${p.nextFifteen*p.nextDayPrice}</c:if>
												<c:if test="${p.nextDayTime == 3}">${p.nextTwenty*p.nextDayPrice}</c:if>
												<c:if test="${p.nextDayTime == 4}">${p.nextTwentyFive*p.nextDayPrice}</c:if>
												<c:if test="${p.nextDayTime == 5}">${p.nextThirty*p.nextDayPrice}</c:if>
												<spring:message code="backend.promotionStatistics.list.unit" />
											</td>
										</c:if>
										<c:if test="${account.internal == false}">
											<td>${p.channelName}</td>
											<td>${p.appNickName}</td>
											<td>
												<c:if test="${p.sameDayTime == 0}">${p.sameFive}</c:if>
												<c:if test="${p.sameDayTime == 1}">${p.sameTen}</c:if>
												<c:if test="${p.sameDayTime == 2}">${p.sameFifteen}</c:if>
												<c:if test="${p.sameDayTime == 3}">${p.sameTwenty}</c:if>
												<c:if test="${p.sameDayTime == 4}">${p.sameTwentyFive}</c:if>
												<c:if test="${p.sameDayTime == 5}">${p.sameThirty}</c:if>
											</td>
											<td>
												<c:if test="${p.nextDayPrice > 0}">
													<c:if test="${p.nextDayTime == 0}">${p.nextFive}</c:if>
													<c:if test="${p.nextDayTime == 1}">${p.nextTen}</c:if>
													<c:if test="${p.nextDayTime == 2}">${p.nextFifteen}</c:if>
													<c:if test="${p.nextDayTime == 3}">${p.nextTwenty}</c:if>
													<c:if test="${p.nextDayTime == 4}">${p.nextTwentyFive}</c:if>
													<c:if test="${p.nextDayTime == 5}">${p.nextThirty}</c:if>
												</c:if>
											</td>
											<td>
												<c:if test="${p.sameDayTime == 0}">${p.sameFive*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 1}">${p.sameTen*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 2}">${p.sameFifteen*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 3}">${p.sameTwenty*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 4}">${p.sameTwentyFive*p.sameDayPrice}</c:if>
												<c:if test="${p.sameDayTime == 5}">${p.sameThirty*p.sameDayPrice}</c:if>
												<c:if test="${p.nextDayPrice > 0}">
													 + 
													<c:if test="${p.nextDayTime == 0}">${p.nextFive*p.nextDayPrice}</c:if>
													<c:if test="${p.nextDayTime == 1}">${p.nextTen*p.nextDayPrice}</c:if>
													<c:if test="${p.nextDayTime == 2}">${p.nextFifteen*p.nextDayPrice}</c:if>
													<c:if test="${p.nextDayTime == 3}">${p.nextTwenty*p.nextDayPrice}</c:if>
													<c:if test="${p.nextDayTime == 4}">${p.nextTwentyFive*p.nextDayPrice}</c:if>
													<c:if test="${p.nextDayTime == 5}">${p.nextThirty*p.nextDayPrice}</c:if>
												</c:if>
												<spring:message code="backend.promotionStatistics.list.unit" />
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
		$().ready(function() {
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
			
		 	onClickCheckBox(${criteria.searchDataType}); 
		 	
		 	if(${criteria.searchStartDay == null}) {
			 	setDefaultDayType();
		 	}
		 	if(${criteria.searchStartMonth == null}) {
			 	setDefaultMonthType();
		 	}
		});
		
		function onClickCheckBox(index) {
			if (index == 0) {
				$('#dayTypeOption1').show();
				$('#monthTypeOption1').hide();
				$('#dayTypeOption2').show();
				$('#monthTypeOption2').hide();
			} else if (index == 1) {
				$('#dayTypeOption1').hide();
				$('#monthTypeOption1').show();
				$('#dayTypeOption2').hide();
				$('#monthTypeOption2').show();
			}
		}
		
		function setDefaultDayType() {
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			if(month < 10){
				month = "0" + month;
			}
			$('#searchStartDay').attr("value", year + "-" + month + "-01");
			$('#searchEndDay').attr("value", year + "-" + month + "-" + date.getDate());
		}
		
		function setDefaultMonthType() {
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			if(month < 10){
				month = "0" + month;
			}
			$('#searchStartMonth').attr("value", year + "-" + month);
			$('#searchEndMonth').attr("value", year + "-" + month);
		}
		
		function showReport() {
			$('#form').attr("action", '<%=request.getContextPath()%>/backend/channel/cpaPromotionStatisticsController/showReport.do');
			$('#form').submit();
			$('#form').attr("action", '<%=request.getContextPath()%>/backend/channel/cpaPromotionStatisticsController/cpaPromotionStatisticsList.do');
		}
	</script>
</body>
</html>