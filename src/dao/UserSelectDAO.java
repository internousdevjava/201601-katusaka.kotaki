package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.UserSelectDTO;
import util.DBConnector;


public class UserSelectDAO {

	private ArrayList<UserSelectDTO> list = new ArrayList<UserSelectDTO>();


	public boolean select() throws SQLException{
			boolean result = false;
	        Connection conn = DBConnector.getConnection();
	        String sql = "SELECT * FROM user";
	        System.out.println(sql);

	         try{
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	            	UserSelectDTO dto = new UserSelectDTO();
	            	dto.setId(rs.getInt("id"));
	            	dto.setUser(rs.getString("user"));
	              	dto.setPassword(rs.getString("password"));
	            	list.add(dto);
	            	result = true;
	             }
	           }catch (SQLException e) {
	 	           e.printStackTrace();
	 	        }finally{
	 	              try{
	 	                 conn.close();
	 	              }catch (SQLException e){
	 	            	  e.printStackTrace();
	 	              }
	 	        }
	 	        return result;
	     }

		public ArrayList<UserSelectDTO> getUserSelect(){
			return list;
		}


}
