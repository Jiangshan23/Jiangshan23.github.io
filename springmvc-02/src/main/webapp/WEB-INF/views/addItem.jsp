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
		$.post("<%=request.getContextPath()%>/itemType/getItemType.do",
			function(map) {
				var list = map.itemTypeList;
				for (var i = 0; i < list.length; i++) {
					$("[name='type']").append("<option value='"+list[i].id+"'>"+ list[i].name + "</option>");
				}
			}, "json");
	});
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/item/additem.do" method="post">
		商品名称：<input type="text" name="name" /><br /> 
		商品价格：<input type="text" name="price" /><br /> 
		上架时间：<input type="text" name="ondate" /><br />
		下架时间：<input type="text" name="downdate" /><br /> 
		商品类别：<select name="type">
			<option value="0">--请选择--</option>
		</select><br /> 
		<input type="submit" value="添加" />
	</form>
</body>
</html>