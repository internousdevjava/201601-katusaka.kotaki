package com.internousdevwork.mackeypark.dto;

 /**
 * OAUTHで顧客情報を格納する為のDTOクラス
 * @author 堅田 一成
 * @since 1.0
 * @version 1.0
 */
public class LoginOauthDTO{

	/**
	 * 名前
	 */
	private String user_Name;

	/**
	 * ユーザーID
	 */
	private String unique_Id;

	private String mail_address;

	private int user_id;

	/**
	 * @return user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id セットする user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	/**
	 * 顧客名取得メソッド
	 * @return user_Name
	 */
	public String getUser_Name() {
		return user_Name;
	}

	/**
	 * 顧客名格納メソッド
	 * @param user_Name 名前
	 */
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	/**
	 * ユーザーID取得メソッド
	 * @return unique_Id
	 */
	public String getUnique_Id() {
		return unique_Id;
	}

	/**
	 * ユーザーID格納メソッド
	 * @param unique_Id ユーザーID
	 */
	public void setUnique_Id(String unique_Id) {
		this.unique_Id = unique_Id;
	}
}