
package com.internousdevwork.mackeypark.dto;

/**
 * ログインでユーザー情報を格納する為のDTOクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */

public class LoginDTO {

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * メールアドレス
	 */
	private String mail_adress;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 名前
	 */
	private String user_name;

	/**
	 * フリガナ
	 */
	private String name_kana;

	/**
	 * クレジットナンバー
	 */
	private String credit_number;

	/**
	 * トークン
	 */
	private String token;

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
	 * メールアドレス取得メソッド
	 * @return
	 */
	public String getMail_adress() {
		return mail_adress;
	}

	/**
	 * メールアドレス格納メソッド
	 * @param mail_adress
	 */
	public void setMail_adress(String mail_adress) {
		this.mail_adress = mail_adress;
	}

	/**
	 * パスワード取得メソッド
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワード格納メソッド
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ユーザーネーム取得メソッド
	 * @return user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * ユーザーネーム格納メソッド
	 * @param user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * フリガナ取得メソッド
	 * @return name_kana
	 */
	public String getName_kana() {
		return name_kana;
	}

	/**
	 * フリガナ格納メソッド
	 * @param name_kana
	 */
	public void setName_kana(String name_kana) {
		this.name_kana = name_kana;
	}

	/**
	 * クレジットナンバー取得メソッド
	 * @return credit_number
	 */
	public String getCredit_number() {
		return credit_number;
	}

	/**
	 * クレジットナンバー格納メソッド
	 * @param credit_number
	 */
	public void setCredit_number(String credit_number) {
		this.credit_number = credit_number;
	}

	/**
	 * トークン取得メソッド
	 * @return
	 */
	public String getToken() {
		return token;
	}

	/**
	 * トークン格納メソッド
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
