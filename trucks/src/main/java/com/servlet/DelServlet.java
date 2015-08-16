package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.util.ConnectionFactory;
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE  FROM film WHERE film_id = ?");
			System.out.println(request.getParameter("id"));
			int a = Integer.parseInt(request.getParameter("id").toString());
			ps.setInt(1,a );
			System.out.println(ps.toString());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("film.jsp");
		rd.forward(request, response);
	}

}