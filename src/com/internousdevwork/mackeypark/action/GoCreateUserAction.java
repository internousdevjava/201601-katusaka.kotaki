package com.internousdevwork.mackeypark.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ログイン画面から新規登録画面に遷移する際に呼ばれるクラス
 * @author KATUSAKA KOTAKI
 * @version 1.0
 * @since 1.0
 */
	public class GoCreateUserAction  extends ActionSupport{

		/**
		 * SUCCESSを返すだけのメソッド
		 * @return String
		 */
		public String execute() {

			return SUCCESS;
		}
}
