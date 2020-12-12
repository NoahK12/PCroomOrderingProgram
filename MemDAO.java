package PCroomOrderingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class MemDAO {
   private Connection conn;
   private Statement stmt;
   private PreparedStatement pstmt;
   private ResultSet rs;

   private static MemDAO dao = new MemDAO();
   
   public MemDAO() {
   }

   public static MemDAO getInstance() {
      return dao;
   }

   private Connection init() throws ClassNotFoundException, SQLException {
      Class.forName("oracle.jdbc.OracleDriver");

      String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
      String user = "hr";
      String password = "a1234";
      return DriverManager.getConnection(url, user, password);
   }

   private void exit() throws SQLException {
      if (rs != null) {
         rs.close();
         if (stmt != null) {
            stmt.close();
            if(pstmt!=null) {
               pstmt.close();
            }
            if (conn != null) {
               conn.close();
            }
         }
      }
   }// exit
   
   public void insertMethod1(MemDTO dto) {
      try {
         conn= init();
         String sql="INSERT INTO ORDERPRODUCT(ORDER_NUMBER,TOTAL_PRICE,ORDER_QUANTITY,SEAT_NUMBER,PRODUCT_NAME)"
                 + " VALUES(NO_SEQ.nextval,?,?,?,?)\n";//?,?,?순서대로 1,2,3지정
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1,dto.getTotal_price());
         pstmt.setInt(2,dto.getOrder_quantity());
         pstmt.setInt(3,dto.getSeat_number());
         pstmt.setString(4,dto.getProduct_name());
         
         int rs=pstmt.executeUpdate();
         
         if (rs>=1) {
            System.out.println("레코드 삽입");
         }else {
            System.out.println("레코드 실패");
         }
         
         
         conn.commit();
      
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
      }finally {
         try {
            
            exit();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}// end class