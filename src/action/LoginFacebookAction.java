package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginOauthDAO;
import dto.LoginOauthDTO;
import util.FacebookOauth;
/**
 * FACEBOOKでログインする為のクラス
 * @author 堅田 一成
 * @since 1.0
 * @version 1.0
 */
public class LoginFacebookAction extends ActionSupport implements SessionAware,
		ServletResponseAware, ServletRequestAware {

	/**
	 * シリアルバージョンIDの生成
	 */
	private static final long serialVersionUID = 7463433040601990718L;

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
	 * @return SUCCESS ERROR
	 */
	public String execute() {
		String rtn = ERROR;
		FacebookOauth oauth = new FacebookOauth();
		Map<String, String> userMap = null;
		userMap = oauth.getAccessToken(request, response);
		if (userMap == null) {
			return rtn;
		}
		String uniqueId = userMap.get("id");
		String userName = userMap.get("name");
		LoginOauthDAO dao = new LoginOauthDAO();
		if (dao.select(uniqueId, NETWORK_NAME)) {
			LoginOauthDTO dto = dao.getLoginOauthDTO();
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

	/**
	 * セッション取得メソッド
	 * @return session セッション
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション格納メソッド
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}