/**
 *
 */
/**
 * @author internous
 *
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnector;

public class UserInsertDAO{


	public int selectToInsert(String user, String password) throws SQLException{
			int count = 0;
	        Connection conn =  DBConnector.getConnection();
	        String sql = "INSERT INTO user (user,password) VALUES (?,?)";
	         try{
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1,user);
	            ps.setString(2,password);
	            count = ps.executeUpdate();


	           }catch (SQLException e) {
	 	           e.printStackTrace();
	 	        }finally{
	 	              try{
	 	                 conn.close();
	 	              }catch (SQLException e){
	 	            	  e.printStackTrace();
	 	              }
	 	        }
	 	        return count;
	     }


}