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
<title>添加电影</title>
</head>
<body>
	<form action="">
		<table border="1">
			<tr>
				<td>title</td>
				<td>description</td>
				<td>language</td>
			</tr>

			<tr>
				<td><input type="text" /></td>
				<td><input type="text" /></td>
				<td><select name="language">
						<%
							Connection conn = ConnectionFactory.getInstance().makeConnextion();
							FilmDaoImp imp = new FilmDaoImp();
							ResultSet rs = imp.getAllLan(conn);
							while (rs.next()) {
						%>

						<option>
						    <%=rs.getString(1) %>
						</option>

						<%
							}
						%>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="添加" /> 
				<input type="reset" value="reste" /></td>
			</tr>
		</table>

	</form>
</body>
</html>