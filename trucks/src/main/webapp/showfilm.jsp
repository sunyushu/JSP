<%@page import="com.hand.Dao.imp.FilmDaoImp"%>
<%@page import="com.hand.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影列表</title>



</head>
<body>


	<form action="" method="post">

		<table border="1">

			<tr>
				<td>film_id</td>
				<td>title</td>
				<td>description</td>
				<td>language</td>
				<td colspan="3">操作</td>
			</tr>
			<%
				Connection conn = ConnectionFactory.getInstance().makeConnextion();
				FilmDaoImp imp = new FilmDaoImp();
				ResultSet rs = imp.show(conn);
				while (rs.next()) {
			%>

			<tr>
				<td><input style="width: 50px" type="text" readonly name="id"
					value="<%=rs.getString(1)%>" /></td>
				<td><input type="text" readonly name="title"
					value="<%=rs.getString(2)%>" /></td>
				<td><input style="width: 900px" type="text" name="dis"
					value="<%=rs.getString(3)%> readonly"></td>
				<td><input type="text" name="lan"
					value="<%=rs.getString(4)%> readonly"></td>
				<td><a href="add.jsp">增加</a></td>
				<td><a href="del.jsp">删除</a></td>
				<td>
					<a href="update.jsp?tit=<%=rs.getString(2)%>&dis=<%=rs.getString(3)%>">修改</a>
			</tr>

			<%
				}
			%>
		</table>

	</form>
	
	
	<%
	session.setAttribute("isLogin", " ");
	
	%>
</body>
</html>