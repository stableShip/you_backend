<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="taglibs.jsp"%>
<a href="#" title="Previous Page" <c:if test="${pagination.currentPage != 1}">onclick="clickPage(${pagination.prePage})"</c:if>>&laquo;<spring:message code="backend.page.prePage" /></a>
<c:if test="${pagination.currentPage - 2 >= 1}">
	<a href="#" class="number" onclick="clickPage(${pagination.currentPage - 2})">${pagination.currentPage - 2}</a>
</c:if>
<c:if test="${pagination.currentPage - 1 >= 1}">
	<a href="#" class="number" onclick="clickPage(${pagination.currentPage - 1})">${pagination.currentPage-1}</a>
</c:if>
<a href="#" class="number current">${pagination.currentPage}</a>
<c:if test="${pagination.totalPage >= pagination.currentPage+1}">
	<a href="#" class="number" onclick="clickPage(${pagination.currentPage + 1})">${pagination.currentPage+ 1}</a>
</c:if>
<c:if test="${pagination.totalPage >= pagination.currentPage + 2}">
	<a href="#" class="number" onclick="clickPage(${pagination.currentPage + 2})">${pagination.currentPage + 2}</a>
</c:if>
<a href="#" title="Next Page" <c:if test="${pagination.currentPage != pagination.totalPage}"> onclick="clickPage(${pagination.nextPage})"</c:if>><spring:message code="backend.page.nextPage" />&raquo;</a>
<select name="pagination.pageSize" class="small-input" onchange="changePageSize()" id="selectPageSize">
	<option value="20" <c:if test="${20 == pagination.pageSize}">selected="selected"</c:if>>20</option>
	<option value="50" <c:if test="${50 == pagination.pageSize}">selected="selected"</c:if>>50</option>
	<option value="100" <c:if test="${100 == pagination.pageSize}">selected="selected"</c:if>>100</option>
</select>
<spring:message code="backend.page.total" />${pagination.totalPage}<spring:message code="backend.page.page" />

<script>
	function clickPage(pageIndex) {
		$('#page').attr("value", pageIndex);
		$('#form').submit();
	}
	
	function changePageSize() {
		var pageSize = $('#selectPageSize').val();
		$('#pageSize').attr("value", pageSize);
		$('#page').attr("value", 1);
		$('#form').submit();			
	}
</script>