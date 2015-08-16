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
<title>修改</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/UpdateServelt"
		method="post">
		<table border="1">
			<tr>
				<td>title</td>
				<td>description</td>
				<td>language</td>
			</tr>

			<tr>
				<td><input type="text" name="title"
					value="<%=request.getParameter("tit").toString()%>" /></td>
				<td><input style="width: 900px" type="text" name="dis"
					value="<%=request.getParameter("dis").toString()%>" /></td>
				<td><select name="language">
						<%
							Connection conn = ConnectionFactory.getInstance().makeConnextion();
							FilmDaoImp imp = new FilmDaoImp();
							ResultSet rs = imp.getAllLan(conn);
							while (rs.next()) {
								int i = 1;
								
						%>
						<option  ><%=rs.getString(1)%></option>
							
						<%
						
							i++;
							}
						%>
						
				</select></td>
				
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="添加" /> <input
					type="reset" value="reste" /></td>
			</tr>
		</table>

	</form>
</body>
</html>