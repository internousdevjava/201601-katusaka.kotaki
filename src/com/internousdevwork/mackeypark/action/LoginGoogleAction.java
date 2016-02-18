package com.internousdevwork.mackeypark.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.mackeypark.dao.LoginOauthDAO;
import com.internousdevwork.mackeypark.dto.LoginOauthDTO;
import com.internousdevwork.mackeypark.util.GoogleOauth;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Googleでログインする為のクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */
public class LoginGoogleAction extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * シリアルナンバー
	 */
	private static final long serialVersionUID = 4405462117636579678L;

	/**
	 * ネットワークネーム
	 */
	static final String NETWORK_NAME = "google";

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * Google認証の実行メソッド
     * @return String 成功ならSUCCESS 失敗ならERRORを返します。
	 */
	public String execute(){

		GoogleOauth googleOauth = new GoogleOauth();
		Map<String, String> userMap = googleOauth.getAccessToken(request);
		if (userMap == null) {
			return ERROR;
		}
		String unique_id = userMap.get("id");
		String user_name = userMap.get("name");
		String mail_address = userMap.get("email");
		LoginOauthDAO dao = new LoginOauthDAO();
		if (dao.select(unique_id, NETWORK_NAME)) {
			LoginOauthDTO dto = dao.getLoginOauthDTO();
			session.put("unique_id", dto.getUnique_Id());
			session.put("user_naame", dto.getUser_Name());
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
	  *  セッションを格納するためのメソッド
	  *  @param session セッション
	  */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	 /**
	  * セッションを取得するためのメソッド
	  * @return session
	  */
	public Map<String, Object> getSession() {
		return session;
	}
	 /**
	  * リクエストを取得するためのメソッド
	  * @param request リクエスト
	  */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}