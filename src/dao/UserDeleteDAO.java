package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnector;

public class UserDeleteDAO {
	public int select(String user) throws SQLException{
		int count = 0;
        Connection conn =  DBConnector.getConnection();
        String sql = "Delete from user WHERE user= ?";

         try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
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