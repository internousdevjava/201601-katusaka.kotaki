package com.internousdevwork.mackeypark.dto;

 /**
 * OAuthでユーザー情報を格納する為のDTOクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */
public class LoginOauthDTO{

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * 名前
	 */
	private String user_Name;

	/**
	 * メールアドレス
	 */
	private String mail_address;

	/**
	 * ユニークID
	 */
	private String unique_Id;


	/**
	 * ユーザーID取得メソッド
	 * @return user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * ユーザーID格納メソッド
	 * @param user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * ユーザー名取得メソッド
	 * @return user_Name
	 */
	public String getUser_Name() {
		return user_Name;
	}

	/**
	 * ユーザー名格納メソッド
	 * @param user_Name 名前
	 */
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	/**
	 * メールアドレス取得メソッド
	 * @return mail_address
	 */
	public String getMail_address() {
		return mail_address;
	}

	/**
	 * メールアドレス格納メソッド
	 * @param mail_address
	 */
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	/**
	 * ユニークID取得メソッド
	 * @return unique_Id
	 */
	public String getUnique_Id() {
		return unique_Id;
	}

	/**
	 * ユニークID格納メソッド
	 * @param unique_Id
	 */
	public void setUnique_Id(String unique_Id) {
		this.unique_Id = unique_Id;
	}
}