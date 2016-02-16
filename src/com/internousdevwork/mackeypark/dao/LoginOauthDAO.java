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
 * @author 堅田 一成
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
	 * @param  OAuthのサービス先のユニークID
	 * @param oauth_Name OAuthのサービス名
	 * @return result
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
	 * ユニークIDが無かったら作成
	 * @param unique_Id OAuthのサービス先のユニークID
	 * @param user_Name OAuthのサービス先のユーザー名
	 * @param oauth_Name OAuthのサービス名
	 * @param oauth_Name OAuthのmail_adress
	 * @return result 結果
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
	 * ユニークIDが無かったら作成
	 * @param unique_Id OAuthのサービス先のユニークID
	 * @param user_Name OAuthのサービス先のユーザー名
	 * @param oauth_Name OAuthのサービス名
	 * @return result 結果
	 */

//	public boolean insert(String unique_Id, String user_Name, String oauth_Name) {
//		Connection con = null;
//		boolean result = false;
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		String now = sdf.format(cal.getTime());
//		con = DBConnector.getConnection("openconnect");
//		String sql = "INSERT INTO user(user_name, , oauth_name, user_registration_date) values (?,?,?,?)";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			ps.setString(1, user_Name);
//			ps.setString(2, unique_Id);
//			ps.setString(3, oauth_Name);
//
//			if(isFirst()){
//			ps.setString(4, now);
//			}
//
//			int insertCount = ps.executeUpdate();
//			if (insertCount > 0) {
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}

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
	 * @param dto ログインユーザDTO
	 */
	public void setLoginOauthDTO(LoginOauthDTO dto) {
		this.dto = dto;
	}
}