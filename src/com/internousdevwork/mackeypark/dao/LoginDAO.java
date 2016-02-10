package com.internousdevwork.mackeypark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdevwork.mackeypark.util.DBConnector;

public class LoginDAO {

	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	public boolean select(String id, String password){ //DAOのselectの戻りはboolean

		try{
			con = (Connection)DBConnector.getConnection();
			sql = "SELECT * FROM user WHERE user_id = ? AND password = ? ";  //userがテーブル名

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);

			rs = ps.executeQuery(); //更新した件数、アップデートした件数

			if(rs.next()){
				return true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
}