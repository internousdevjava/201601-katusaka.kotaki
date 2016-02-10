package dto;

/**
 * LoginUserDTO
 * 顧客情報を格納する為のDTOクラス
 * @author 堅田 一成
 * @since 1.0
 * @version 1.0
 */
public class LoginDTO{

	/**
	 * 名前
	 */
	private String userName;

	/**
	 * ログインID
	 */
	private int loginId;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * メールアドレス
	 */
	private String email;

	/**
	 * 名前取得メソッド
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * ログインID格納メソッド
	 * @param userName ユーザの名前
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * ログインID取得メソッド
	 * @return loginId
	 */
	public int getLoginId() {
		return loginId;
	}

	/**
	 * ログインID格納メソッド
	 * @param loginId ログインID
	 */
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	/**
	 * パスワード取得メソッド
	 * @return password
	 */
	public String getpassword() {
		return password;
	}

	/**
	 * パスワード格納メソッド
	 * @param password パスワード
	 */
	public void setpassword(String password) {
		this.password = password;
	}

	/**
	 * メールアドレス取得メソッド
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * メールアドレス格納メソッド
	 * @param email メールアドレス
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}