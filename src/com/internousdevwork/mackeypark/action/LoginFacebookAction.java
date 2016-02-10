/*
 * タイトル：facebookでログインする為のクラス
 * 説明    ：facebookからTokenを取得
 *
 * 著作権  ：Copyright(c) 2016 InterNous, Inc.
 * 会社名  ：インターノウス株式会社
 *
 */
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
 * @author K.abe
 * @since 1.0
 * @version 1.1
 */
public class LoginFacebookAction extends ActionSupport implements SessionAware, ServletResponseAware, ServletRequestAware{

	/**
	 * シリアルID
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
	 * @return FACEBOOK認証成功時SUCCESS FACEBOOK認証失敗時ERROR
	 */
	public String execute() {
		String rtn = ERROR;
		FacebookOauth oauth = new FacebookOauth();			//FacebookOauthをインスタンス化
		Map<String, String> userMap = null;
		userMap = oauth.getAccessToken(request, response);	//アクセストークンを取得
		if (userMap == null) {
			return rtn;
		}
		String uniqueId = userMap.get("id");
		String userName = userMap.get("name");
		LoginOauthDAO dao = new LoginOauthDAO();			//LoginOauthDAOをインスタンス化
		if (dao.select(uniqueId, NETWORK_NAME)) {			//selectメソッド
			LoginOauthDTO dto = dao.getLoginOauthDTO();		//
			session.put("loginId", dto.getUserId());
			session.put("userName", dto.getUserName());
			rtn = SUCCESS;
			return rtn;
		}
		boolean result = dao.insert(uniqueId, userName, NETWORK_NAME);
		if (!result) {
			return rtn;
		}

		dao.select(uniqueId, NETWORK_NAME);
		LoginOauthDTO dto = dao.getLoginOauthDTO();
		session.put("loginId", dto.getUserId());
		session.put("userName", dto.getUserName());
		rtn = SUCCESS;
		return rtn;
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
