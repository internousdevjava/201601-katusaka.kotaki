package com.internousdevwork.mackeypark.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.mackeypark.dao.LoginDAO;
import com.internousdevwork.mackeypark.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * CreditCard ログイン処理を行うクラス
 *
 * @author KATUSAKA KOTAKI
 * @version 1.0
 * @since 1.0
 */
public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ログインID用のメールアドレス
	 */
	private String mail_adress;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ユーザー情報を格納する為のマップ
	 */
	private Map<String,Object> session;

	/**
	 * ログイン失敗時に表示されるエラーメッセージ
	 */
	private String errorMsg;

	/**
	 *ログイン処理を行うメソッド
	 *結果はログインできればSUCCESS、できなければERRORを返します。
	 */
	public String execute(){
		LoginDAO dao = new LoginDAO();
		if(!dao.select(mail_adress, password)){
			setErrorMsg("ID、もしくはパスワードが間違っています");
			return ERROR;
		}
		LoginDTO dto = new LoginDTO();
		dto = dao.getDto();
		session.put("user_id", dto.getUser_id());
		session.put("mail_adress", mail_adress);
		session.put("user_name", dto.getUser_name());
		session.put("name_kana", dto.getName_kana());
		session.put("credit_number", dto.getCredit_number());
		session.put("token", dto.getToken());
		return SUCCESS;
	}


	/**
	 * メールアドレス取得メソッド
	 * @return mail_adress
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
	 * セッション取得メソッド
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション格納メソッド
	 * @param session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * エラーメッセージ取得メソッド
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * エラーメッセージ格納メソッド
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


}