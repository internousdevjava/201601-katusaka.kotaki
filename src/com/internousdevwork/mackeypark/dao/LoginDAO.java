package com.internousdevwork.mackeypark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdevwork.mackeypark.dto.LoginDTO;
import com.internousdevwork.mackeypark.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

//データベースとやり取りしてユーザーが登録されているか確認するクラス
public class LoginDAO  extends ActionSupport{

	LoginDTO dto = new LoginDTO();

	public boolean select(String mail_address, String password){

		boolean result = false;
		Connection con = DBConnector.getConnection("openconnect");	//DBに接続
		String sql = "SELECT * FROM user WHERE mail_address=? AND password=?";  //テーブル(user)から入力されたmail_adressとpasswordを検索

		try{
			PreparedStatement ps = con.prepareStatement(sql);		//DBにSQL文を送信する

			ps.setString(1, mail_address);		//取ってきたデータを1にmail_adressとしてセット
			ps.setString(2, password);			//取ってきたデータを2にpasswordとしてセット
			ResultSet rs = ps.executeQuery(); //結果を受け取る

			if(rs.next()){
				//結果を確認して登録があればトゥルー
				int user_id = rs.getInt("user_id");
				String  user_name= rs.getString("user_name"); //レコードの値
				String name_kana = rs.getString("name_kana");
				String credit_number = rs.getString("credit_number");
				String token = rs.getString("token");

				dto.setUser_id(user_id);
				dto.setUser_name(user_name);
				dto.setName_kana(name_kana);
				dto.setCredit_number(credit_number);
				dto.setToken(token);

				result = true;
			}
		}catch(SQLException e){			//それ以外はフォルス
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
		return result;
	}

	public LoginDTO getDto() {
		return dto;
	}
}