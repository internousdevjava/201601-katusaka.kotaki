package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;
import util.DBConnector;

 /**
 * LoginDAO ログインに必要な情報を取得する為のクラス
 * @author 堅田 一成
 * @since 1.0
 * @version 1.0
 */
public class LoginDAO {
     /**
	 * LoginのDTO
	 */
	private LoginDTO logindto = new LoginDTO();

	 /**

	 /**
	 * Connection
	 */
	private Connection con = null;

	 /**
	 * 入力された情報とDBの顧客情報にある情報を照合し情報を取得するメソッド
	 * @param email ログイン認証用メールアドレス
	 * @param password ログインパスワード
	 * @param dto LoginDTO ユーザー情報の格納用DTO
	 * @return result
	 */
	public boolean select(String email,String password,LoginDTO dto){
	    con = DBConnector.getConnection();
		String sql = "SELECT * FROM user WHERE email=? AND password =? AND delete_flag = 0";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,email);
			stmt.setString(2,password);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()){
				dto.setUserName(resultSet.getString("name"));
				dto.setLoginId(resultSet.getInt("id"));
				return true;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * LoginDTOを取得するメソッド
	 * @return logindto
	 */
	public LoginDTO getLogindto(){
		return logindto;
	}
}