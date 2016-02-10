package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnector;

public class UserUpdateDAO {
	public int select(String user,String password,int id) throws SQLException{
		int count = 0;
        Connection conn =  DBConnector.getConnection();
        String sql = "UPDATE user SET user=?, password=? WHERE id=?";

         try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,password);
            ps.setInt(3,id);
            count =ps.executeUpdate();


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