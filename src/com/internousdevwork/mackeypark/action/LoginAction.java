package com.internousdevwork.mackeypark.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.mackeypark.dao.LoginDAO;
import com.internousdevwork.mackeypark.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//ログイン画面でログインボタンを押すと呼ばれるクラス
public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;

	private String mail_adress;			//ID用のメールアドレス
	private String password;			//パスワード

	private Map<String,Object> session;	//セッションスコープに保存するためのマップリスト
	private String errorMsg;

	//struts.xmlの method = "execute" で呼ばれている
	public String execute(){

		//LoginDAOクラスを呼び出し
		LoginDAO dao = new LoginDAO();
		//データベースからID(メールアドレス)とパスワードが見つからなければ
		if(!dao.searchDB(mail_adress, password)){
			setErrorMsg("ID、もしくはパスワードが間違っています");
			//struts.xmlにERRORを返す（ログイン画面へ）
			return ERROR;
		}

		//見つかった場合はLoginDTOを呼び出し

		LoginDTO dto = new LoginDTO();
		dto = dao.getDto();

		 System.out.println(dto.getUser_id());
		 System.out.println(dto.getUser_name());
		 System.out.println(dto.getName_kana());
		 System.out.println(dto.getCredit_number());
		 System.out.println(dto.getToken());

		 //ユーザーのIDを"user_id"というキーでセッションスコープに保存。以下略
		 session.put("user_id", dto.getUser_id());
		 session.put("mail_adress", mail_adress);
		 session.put("user_name", dto.getUser_name());
		 session.put("name_kana", dto.getName_kana());
		 session.put("credit_number", dto.getCredit_number());
		 session.put("token", dto.getToken());

		//struts.xmlにSUCCESSを返す（メイン画面へ）
		 return SUCCESS;
	}

	public String getMail_adress() {
		return mail_adress;
	}

	public void setMail_adress(String mail_adress) {
		this.mail_adress = mail_adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	//インターフェースSessionAwareの抽象メソッド
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}