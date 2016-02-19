package com.internous.action;

import com.internous.dao.loginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private int id;
	private String password;

	public String execute(){

		loginDAO dao = new loginDAO();

		if(!dao.select(id, password)){
			return ERROR;
		}
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
