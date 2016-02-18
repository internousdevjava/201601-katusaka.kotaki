package com.internousdevwork.mackeypark.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.mackeypark.dao.LoginOauthDAO;
import com.internousdevwork.mackeypark.dto.LoginOauthDTO;
import com.internousdevwork.mackeypark.util.FacebookOauth;
import com.opensymphony.xwork2.ActionSupport;

/**
 * facebookで認証を確認する為のクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */
public class LoginFacebookAction extends ActionSupport implements SessionAware, ServletResponseAware, ServletRequestAware{

	/**
	 * シリアルナンバー
	 */
	private static final long serialVersionUID = 8951888096203473890L;

	/**
	 * ネットワークネーム
	 */
	static final String NETWORK_NAME = "Facebook";

	/**
	 * レスポンス
	 */
	private HttpServletRequest request;

	/**
	 * リクエスト
	 */
	private HttpServletResponse response;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * FACEBOOK認証の実行メソッド
	 * @return String 成功ならSUCCESS 失敗ならERRORを返します。
	 */
	public String execute() {

		FacebookOauth oauth = new FacebookOauth();
		Map<String, String> userMap = null;
		userMap = oauth.getAccessToken(request, response);
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
	 * リクエストを格納するメソッド
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * レスポンスを格納するメソッド
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * セッションを取得するメソッド
	 * @return session セッション
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッションを格納するメソッド
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
