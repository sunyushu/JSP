package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String returnUri=request.getParameter("return_uri");

    		RequestDispatcher rd=null;
    		if(uname==null){
    			request.setAttribute("msg", "用户名为空！");
    			rd=request.getRequestDispatcher("/error.jsp");
    			rd.forward(request, response);
    		}else{
    			
    			String sql="SELECT * FROM Customer where first_name='"+uname+"'";
    			Connection conn=null;//当前数据库连接
    	    	Statement st=null;//用于向数据库发送数据
    	    	ResultSet rs=null;//结果集，封装了从数据库查询到的数据 
    	    	
    	    	try {
    	    		Class.forName("com.mysql.jdbc.Driver");//注册驱动程序
    	    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","123456");//获取数据库连接
    	    		st=conn.createStatement();
    	    		rs=st.executeQuery(sql);
    	    
    			if(rs.next()){
    				request.getSession().setAttribute("flag", "login_success");
    				if(returnUri !=null){
    					rd=request.getRequestDispatcher(returnUri);
    					rd.forward(request, response);
    				}else{
    					rd=request.getRequestDispatcher("/index.jsp");
    					rd.forward(request, response);
    				}
    			}else{
    				request.getSession().setAttribute("flag", "login_error");
    				request.setAttribute("msg", "用户名错误！");
    				rd=request.getRequestDispatcher("/login.jsp");
    				rd.forward(request, response);
    			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				st.close();
			} catch (Exception e3) {
			}
			try {
				conn.close();
			} catch (Exception e4) {
			}
		}	
		}
	}

}
