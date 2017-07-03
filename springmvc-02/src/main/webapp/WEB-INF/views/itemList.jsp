<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		//跳转到商品添加界面
		$("#addItemPage").click(function(){
			location.href="<%=request.getContextPath()%>/item/addItemPage.do";
		});
		//批量删除
		$("#delAll").click(function() {
			var ids = "";
			var a = $("input[name=check]:checked");
			a.each(function() {
				ids += "," + $(this).val();
				//  ,1,2,3
			});
			location.href = "deleteAllItem.do?id=" + ids.substring(1);//ids.substring(1) 可以把,1,2,3 变成   1,2,3
		});
	});
	//模糊查询功能和分页
	function fenye(page){
        document.getElementById("page").value = page;
        document.forms[0].submit();
	}
</script>
</head>
<body>
	<!-- 模糊查询 需要用post请求 传递中文才不会乱码  模糊查询和分页连用需要包模糊查询的内容全部传递到后台 -->
	<form action="<%=request.getContextPath()%>/item/selectAll.do" method="post">
		<input type="hidden" id="page" name="currentPage" /> 按姓名查询:<input
			type="text" name="mohu" value="${mohu}" /> <input type="submit"
			value="查询" />
	</form>
	<table>
		<tr>
			<td></td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品类别</td>
			<td>商品上架时间</td>
			<td>商品下架时间</td>
			<td><button id="addItemPage">添加商品</button></td>
		</tr>
		<c:forEach items="${itemList}" var="li">
			<tr>
				<td><input type="checkbox" value="${li.id}" name="check" /></td>
				<td>${li.name}</td>
				<td>${li.price}</td>
				<td>${li.type}</td>
				<td>${li.ondate}</td>
				<td>${li.downdate}</td>
				<td><button
						onclick="location.href='updItemById.do?id=${li.id}'">修改</button>
					<button onclick="location.href='delItemById.do?id=${li.id}'">删除</button></td>
			</tr>
		</c:forEach>
	</table>
	<button id="delAll">批量删除</button>
	<table>
    <tr>
    	<td >
    		第${page.currentPage}/${page.pageCount}页
  			<a href="javaScript:void(0)" onclick="fenye(1)">首页</a>
  			<a href="javaScript:void(0)" onclick="fenye(${page.previousPage})">上一页</a>
  			<a href="javaScript:void(0)" onclick="fenye(${page.nextPage})">下一页</a>
  			<a href="javaScript:void(0)" onclick="fenye(${page.pageCount})">尾页</a>
		</td>
    </tr>
</table>
</body>
</html>