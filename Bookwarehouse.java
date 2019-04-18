/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author kwadwooteng-amoako
 */
public class Bookwarehouse {

    /**
     * @param args the command line arguments
     */
    static Connection cn; 
    static Statement st; 
    static ResultSet rs; 

    public static void main(String[] args) 
    {
        
        JDBC_Interface_Logic jdbc_conn = new JDBC_Interface_Logic();
        
        String[] BookID = new String[] { "12345678", "9101112131415161718", "12345678", "9101112131415161718" ,"12345678" };
        
        jdbc_conn.new_borrow_request("oteng-amoako","20010101",7,2,1,"11111111","Hilltop", BookID ,"20010101", "KWajwo");
        
        // sql logic here
        try {
                Class.forName("com.mysql.jdbc.Driver");
                cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
                st = (Statement) cn.createStatement();
                rs = st.executeQuery("select * from userdata;");
                while(rs.next())
            {
                System.out.println(rs.next());
            };
            
            String sql1 = "INSERT INTO BookDB.userdata VALUES('UA502f', 'Venice');";
            st.executeUpdate(sql1);
            
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        
        GoogleBooksApi_Interface_LookUp gn = new GoogleBooksApi_Interface_LookUp();
        gn.find_book("9780310432593");
   
    }
    
}
