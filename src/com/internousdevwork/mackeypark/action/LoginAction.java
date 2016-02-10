package com.internousdevwork.mackeypark.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.mackeypark.dao.LoginDAO;
import com.internousdevwork.mackeypark.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internous
 *
 */
public class LoginAction extends ActionSupport implements SessionAware{
	public String id;
	public String password;
	private Map<String,Object>session;

	public String execute(){

		LoginDAO dao = new LoginDAO(); //LoginDAOクラスを作成すると波線が消える

		boolean res = dao.select(id,password);

		if(!res){
			return ERROR;
		}
		 LoginDTO dto = new LoginDTO(id, password);

	        session.put("id", dto.getId());

		session.put("id", id );

		session.put("name_key", password );


		return SUCCESS;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getPass(){
		return password;
	}

	public void setPass(String password){
		this.password = password;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}