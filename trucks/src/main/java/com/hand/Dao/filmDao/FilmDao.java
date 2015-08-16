package com.hand.Dao.filmDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.entity.Film;

public interface FilmDao {

	public void save(Connection conn, Film film) throws SQLException;

	public void update(Connection conn, Film film) throws SQLException;

	public void delete(Connection conn, Film film) throws SQLException;

	public ResultSet get(Connection conn, Film film) throws SQLException;
}
