/**
 *
 */
package com.internousdevwork.mackeypark.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
/**
 * DBconnector DBから情報を取得するメソッド
 * @author internous
 * @since 2015/06/25
 * @param driverName  ドライバー名
 * @param url         url名
 * @param user        ユーザー名
 * @param pass        パスワード
 * @throws ClassNotFoundException
 * @throws SQLException
 * @return con
 */
public class DBConnector{

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/";
	private static String user = "root"; //DBのユーザ名
	private static String pass = "mysql";  //DBに接続するときのパスワード

	public static Connection getConnection(String database){
		StringBuffer sBuffer = new StringBuffer("");
		sBuffer.append(url);
		sBuffer.append(database);
		url = sBuffer.toString();

		Connection con = null;
		try{
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,pass);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	url = "jdbc:mysql://localhost/";
	return con;
	}
}