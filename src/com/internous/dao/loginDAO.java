package com.internous.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internous.dto.loginDTO;

public class loginDAO {

	loginDTO dto = new loginDTO();

	public boolean select(int id, String password){

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/logintest", "root", "mysql");

			String sql ="select * from user where id=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setPassword(rs.getString("password"));
				return true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public loginDTO getDto() {
		return dto;
	}
}
