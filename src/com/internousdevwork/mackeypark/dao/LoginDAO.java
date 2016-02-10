package com.internousdevwork.mackeypark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdevwork.mackeypark.util.DBConnector;

//データベースとやり取りしてユーザーが登録されているか確認するクラス
public class LoginDAO {

	public boolean isRegister(String mail_adress, String password){

		try{
			Connection con = DBConnector.getConnection();	//DBに接続
			String sql = "SELECT * FROM user WHERE mail_adress = ? AND password = ? ";  //テーブル(user)から入力されたmail_adressとpasswordを検索

			PreparedStatement ps = con.prepareStatement(sql);		//DBにSQL文を送信する
			ps.setString(1, mail_adress);		//取ってきたデータを1にmail_adressとしてセット
			ps.setString(2, password);			//取ってきたデータを2にpasswordとしてセット

			ResultSet rs = ps.executeQuery(); //結果を受け取る

			if(rs.next()){		//結果を確認して登録があれば
				return true;	//トゥルー
			}
		}						//それ以外はフォルス
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
}