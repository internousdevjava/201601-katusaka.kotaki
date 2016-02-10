package dto;

 /**
 * OAUTHで顧客情報を格納する為のDTOクラス
 * @author 堅田 一成
 * @since 1.0
 * @version 1.0
 */
public class LoginOauthDTO{

	/**
	 * 名前
	 */
	private String userName;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 顧客名取得メソッド
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 顧客名格納メソッド
	 * @param userName 名前
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * ユーザーID取得メソッド
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * ユーザーID格納メソッド
	 * @param userId ユーザーID
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
}