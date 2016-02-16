
package com.internousdevwork.mackeypark.dto;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internous
 *
 */
public class LoginDTO extends ActionSupport{
	private int user_id;
	private String mail_adress;
	private String password;
	private String user_name;
	private String name_kana;
	private String credit_number;
	private String token;

	public LoginDTO(){}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getMail_adress() {
		return mail_adress;
	}

	public void setMail_adress(String mail_adress) {
		this.mail_adress = mail_adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getName_kana() {
		return name_kana;
	}

	public void setName_kana(String name_kana) {
		this.name_kana = name_kana;
	}

	public String getCredit_number() {
		return credit_number;
	}

	public void setCredit_number(String credit_number) {
		this.credit_number = credit_number;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
