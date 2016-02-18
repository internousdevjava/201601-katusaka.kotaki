package com.internousdevwork.mackeypark.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.mackeypark.dao.LoginOauthDAO;
import com.internousdevwork.mackeypark.dto.LoginOauthDTO;
import com.internousdevwork.mackeypark.util.TwitterOauth;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Twitterでログインする為のクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */

public class LoginTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware{

	/**
	 * シリアルナンバー
	 */
	private static final long serialVersionUID = 3787626263699340105L;

	/**
	 * ネットワークネーム
	 */
	static final String NETWORK_NAME = "Twitter";

	/**
	 * セッション
	 */
	public Map<String, Object> session;

	/**
	 * レスポンス
	 */
	private HttpServletResponse response;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * Twitter認証の実行メソッド
	 * @return String 成功ならSUCCESS 失敗ならERRORを返します。
	 */
	public String execute() {

		TwitterOauth twitterOauth = new TwitterOauth();
		String[] userData = new String[3];
		userData = twitterOauth.getAccessToken(request, response);

		if (userData == null) {
			return ERROR;
		}

		String unique_id = userData[0];
		String user_name = userData[1];
		String mail_address = userData[2];
		LoginOauthDAO dao = new LoginOauthDAO();
		if (dao.select(unique_id, NETWORK_NAME)) {
			LoginOauthDTO dto = dao.getLoginOauthDTO();
			session.put("unique_id", dto.getUnique_Id());
			session.put("user_name", dto.getUser_Name());
			session.put("mail_address", dto.getMail_address());
			session.put("user_id", dto.getUser_id());
			return SUCCESS;
		}

		boolean result = dao.insert(user_name, mail_address, unique_id, NETWORK_NAME);
		if (!result) {
			return ERROR;
		}

		dao.select(unique_id, NETWORK_NAME);
		LoginOauthDTO dto = dao.getLoginOauthDTO();
		session.put("unique_id", dto.getUnique_Id());
		session.put("user_name", dto.getUser_Name());
		session.put("mail_address", dto.getMail_address());
		session.put("user_id", dto.getUser_id());
		return SUCCESS;
	}

	/**
	 * レスポンス格納メソッド
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * リクエスト格納メソッド
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * セッション格納メソッド
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * セッション取得メソッド
	 * @return Session
	 */
	public Map<String, Object> getSession() {
		return session;
	}
}