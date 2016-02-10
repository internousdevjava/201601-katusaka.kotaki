package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 /**
 * MySQLの指定したデータベースに接続する為のクラス
 * @author N.Kitayama
 * @version 1.1
 * @since 1.0
 */
 public class DBConnector {
 	/**
 	 * MySQLのドライバー名
 	 */
     private static String driverName = "com.mysql.jdbc.Driver";
     /**
 	 * MySQLのsports_gymというデータベースのURL
 	 */
     private static String url = "jdbc:mysql://localhost/prototype1512";
     /**
 	 * MySQLのユーザー名
 	 */
     private static String user = "root";
     /**
 	 * MySQLのパスワード
 	 */
     private static String pass = "mysql";


     /**
      * 指定したデータベースへのコネクションを取得するメソッド
      * @return con 指定したデータベースへのコネクション
      */
     public static Connection getConnection() {


         Connection con = null;
         try {
             Class.forName(driverName);
             con = DriverManager.getConnection(url,user,pass);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return con;
     }
}