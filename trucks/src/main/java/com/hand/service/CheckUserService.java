package com.hand.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Dao.filmDao.UserDao;
import com.hand.Dao.imp.UserDaoImp;
import com.hand.entity.User;
import com.hand.util.ConnectionFactory;

public class CheckUserService {
	private UserDao userDao = new UserDaoImp();

	public boolean check(User user) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		System.out.println("CheckUserService 1");
		try {
			
			System.out.println(conn.getAutoCommit());
			System.out.println("CheckUserService 2");
			
			while(userDao.get(conn, user).next()){
				return true;
			};

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}