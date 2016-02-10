package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import util.FacebookOauth;

/**
 * FACEBOOKでログインする為のクラス
 * @author 堅田 一成
 * @since 1.0
 * @version 1.0
 */
public class GoFacebookAction  extends ActionSupport implements ServletResponseAware,ServletRequestAware  {

	/**
	 * 生成されたシリアルナンバー
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
	 * FaceBookからTokenを取得メソッド
	 * @return String
	 */
    public String execute() {
    	FacebookOauth oauth = new FacebookOauth();
		oauth.getRequestToken(request, response);
		return "success";
	}
 
	/**
	 * リクエスト格納メソッド
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * レスポンス格納メソッド
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
