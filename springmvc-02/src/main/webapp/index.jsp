<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#login").click(function(){
			$.post("<%=request.getContextPath()%>/login/login.do",{
				userName : $("[name='userName']").val(),
				passWord : $("[name='passWord']").val()
			},function(map){
				location.href="<%=request.getContextPath()%>/item/selectAll.do";
			},"json");
		});
		$("#addUser").click(function(){
			location.href="<%=request.getContextPath()%>/user/addUserPage.do";
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td>用户名：<input type="text" name="userName"/></td>
		</tr>
		<tr>
			<td>密码：<input type="text" name="passWord"/></td>
		</tr>
		<tr>
			<td><button id="login">登录</button><button id="addUser">注册</button></td>
		</tr>
	</table>
</body>
</html>