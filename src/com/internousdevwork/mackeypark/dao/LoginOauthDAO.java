package com.internousdevwork.mackeypark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.internousdevwork.mackeypark.dto.LoginOauthDTO;
import com.internousdevwork.mackeypark.util.DBConnector;

/**
 * Oauthでログインに必要な情報を取得する為のクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */
public class LoginOauthDAO{

	/**
	 * 取得した情報を格納する為のDTO
	 */
	private LoginOauthDTO dto = new LoginOauthDTO();
	/**
	 * 取得したユニークIDを照合するためのメソッド
	 * @param  unique_id
	 * @param oauth_Name
	 * @return boolean unique_idとoauth_nameを照合できるか
	 */
	public boolean select(String unique_id, String oauth_name){

		Connection con = DBConnector.getConnection("openconnect");
		try{
			String sql = "SELECT * FROM user WHERE  unique_id=? AND oauth_name=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,unique_id);
			ps.setString(2,oauth_name);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setUnique_Id(rs.getString(1));
				dto.setUser_Name(rs.getString(2));
				dto.setMail_address(rs.getString("mail_address"));
				dto.setUser_id(rs.getInt("user_id"));
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * ユーザー情報をデータベースにインサートできるか確認するメソッド
	 * @param unique_Id OAuthのサービス先のユニークID
	 * @param user_Name OAuthのサービス先のユーザー名
	 * @param oauth_Name OAuthのサービス名
	 * @param mail_address OAuthのサービス先で登録しているメールアドレス
	 * @return boolean
	 */
		public boolean insert(String user_name, String mail_adress, String unique_id, String oauth_name ) {
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String now = ldt.format(formatter);
			Connection con = DBConnector.getConnection("openconnect");
			String sql = "INSERT INTO user(user_name, mail_address, unique_id, oauth_name, user_registration_date) values (?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user_name);
				ps.setString(2, mail_adress);
				ps.setString(3, unique_id);
				ps.setString(4, oauth_name);
				if(isFirst()){
				ps.setString(5, now);
				}
				int insertCount = ps.executeUpdate();
				if (insertCount > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}

		/**
		 * 初登録か確認するメソッド
		 * @return boolean nullならtrueを、そうでないならfalseを返します。
		 */
	public boolean isFirst(){

		Connection con = DBConnector.getConnection("openconnect");
		String sql = "SELECT user_registration_date FROM user";

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
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

	/**
	 * DTO取得メソッド
	 * @return dto
	 */
	public LoginOauthDTO getLoginOauthDTO() {
		return dto;
	}

	/**
	 * DTO格納メソッド
	 * @param dto
	 */
	public void setLoginOauthDTO(LoginOauthDTO dto) {
		this.dto = dto;
	}
}