
package com.internousdevwork.mackeypark.dto;

/**
 * @author internous
 *
 */
public class LoginDTO {
	private String 	mail_adress;
	private String password;
	private int user_id;	//user_idはauto_incrementなのでゲッターのみ

	public LoginDTO(String mail_adress, String password) {	//コンストラクタ
		this.mail_adress = mail_adress;
		this.password = password;
	}

	public String getMailAdress() {		//以下ゲッターとセッター
		return mail_adress;
	}

	public void setMailAdress(String mail_adress) {
		this.mail_adress = mail_adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return user_id;
	}

}
