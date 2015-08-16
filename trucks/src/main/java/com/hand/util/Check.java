package com.hand.util;

import java.sql.Connection;



public class Check {

	public static void main(String[] args) throws Exception{
		ConnectionFactory cf = ConnectionFactory.getInstance();

		Connection conn = cf.makeConnextion();

		System.out.println(conn.getAutoCommit());
	}

}