package com.hand.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.Dao.filmDao.UserDao;
import com.hand.entity.User;

public class UserDaoImp implements UserDao {

	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE first_name = ?");
		ps.setString(1, user.getName());
		
		return ps.executeQuery();
	}
}