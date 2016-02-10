/**
 *
 */
/**
 * @author internous
 *
 */
package dto;

public class UserSelectDTO{

	private int id;

	private String user;
	//ユーザー名

	private String password;
	//パスワード

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

		public String getUser(){
		return user;
	}

	public void setUser(String user){
		this.user = user;
	}


	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

}

