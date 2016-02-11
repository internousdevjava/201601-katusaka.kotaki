package com.internousdevwork.mackeypark.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.mackeypark.dao.LoginDAO;
import com.internousdevwork.mackeypark.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//ログイン画面でログインボタンを押すと呼ばれるクラス
public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;

	private boolean isLogin;

	private String mail_adress;			//ID用のメールアドレス
	private String password;			//パスワード
	private Map<String,Object>session;	//セッションスコープに保存するためのマップリスト

	//struts.xmlの method = "execute" で呼ばれている
	public String execute(){

		//LoginDAOクラスを呼び出し
		LoginDAO dao = new LoginDAO();

		boolean result = dao.isRegister(mail_adress, password);

		//データベースからID(メールアドレス)とパスワードが見つからなければ
		if(!result){
			isLogin = false;
			session.put("isLogin", isLogin);
			//struts.xmlにERRORを返す（ログイン画面へ）
			return ERROR;
		}
		//見つかった場合はLoginDTOを呼び出し
		 LoginDTO dto = new LoginDTO(mail_adress, password);

		 //ユーザーのIDを"user_id"というキーでセッションスコープに保存。以下略
		 session.put("user_id", dto.getUserId());
		 session.put("mail_adress", mail_adress );
		 session.put("password", password );

		//struts.xmlにSUCCESSを返す（メイン画面へ）
		return SUCCESS;
	}

	//インターフェースSessionAwareの抽象メソッド
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}