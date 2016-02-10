package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import util.TwitterOauth;

/**
 * Twitterでログインする為のクラス
 * @author 堅田 一成
 * @since 1.0
 * @version 1.0
 */
public class GoTwitterAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 1524555947613444860L;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * レスポンス
	 */
	private HttpServletResponse response;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * TwitterリクエストToken取得メソッド
	 * @return  SUCCESS ERROR
	 */
	public String execute() {
		TwitterOauth twitterOauth = new TwitterOauth();
		if (!twitterOauth.getRequestToken(request, response)) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * セッションを格納するためのメソッド
	 * @param session セッション
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
	 * レスポンスを格納するためのメソッド
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * リクエストを格納するためのメソッド
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
