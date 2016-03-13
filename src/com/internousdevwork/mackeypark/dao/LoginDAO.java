package com.internousdevwork.mackeypark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdevwork.mackeypark.dto.LoginDTO;
import com.internousdevwork.mackeypark.util.DBConnector;

/**
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */

/**
 * データベースとやり取りしてユーザーが登録されているか確認するクラス
 */
public class LoginDAO {

	LoginDTO dto = new LoginDTO();
	/**
	 * メールアドレスとパスワードからユーザーの登録を確認するメソッド
	 * メールアドレスとパスワードからユーザーを特定できた場合、
	 * そのユーザーのID、氏名、フリガナ、クレジットカードナンバー、トークンを取得しDTOに格納します。
	 * @param mail_address
	 * @param password
	 * @return boolean mail_addressとpasswordが登録されているか
	 */
	public boolean select(String mail_address, String password){
		Connection con = DBConnector.getConnection("openconnect");
		String sql = "SELECT * FROM user WHERE mail_address=? AND password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mail_address);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setUser_id(rs.getInt("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setName_kana(rs.getString("name_kana"));
				dto.setCredit_number(rs.getString("credit_number"));
				dto.setToken(rs.getString("token"));
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public LoginDTO getDto() {
		return dto;
	}

}