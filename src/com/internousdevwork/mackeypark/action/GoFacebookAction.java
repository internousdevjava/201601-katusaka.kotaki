package com.internousdevwork.mackeypark.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.internousdevwork.mackeypark.util.FacebookOauth;
import com.opensymphony.xwork2.ActionSupport;

/**
 * FACEBOOKでログインする為のクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */
public class GoFacebookAction  extends ActionSupport implements ServletResponseAware,ServletRequestAware  {

	/**
	 * シリアルナンバー
	 */
	private static final long serialVersionUID = 8410788671527276072L;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * レスポンス
	 */
	private HttpServletResponse response;

	/**
	 * FaceBookでリクエストToken取得できるか確認するメソッド
	 * @return String
	 */
	public String execute() {
		FacebookOauth oauth = new FacebookOauth();
		if(!oauth.getRequestToken(request, response)){
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * リクエスト格納メソッド
	 * @param request
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * レスポンス格納メソッド
	 * @param response
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
