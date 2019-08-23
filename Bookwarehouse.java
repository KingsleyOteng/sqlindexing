/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kwadwooteng-amoako
 * @date  23 August 2019
 * @description the programs main section
 *
 */
public class Bookwarehouse {

    /**
     * @param args the command line arguments
     */
    static Connection cn; 
    static Statement st; 
    static ResultSet rs; 

    public static void main(String[] args) throws IOException, SQLException 
    {
        
        JDBC_Interface_Logic jdbc_conn = new JDBC_Interface_Logic();
        
        //String[] BookID = new String[] { "12345678", "9101112131415161718", "12345678", "9101112131415161718" ,"12345678" };
        
        //jdbc_conn.new_borrow_request("oteng-amoako","20010101",7,2,1,"11111111","Hilltop", BookID ,"20010101", "KWajwo");
        
        // sql logic here
        try 
            {
                            Book_Search BSO = new Book_Search();
                            BSO.universal_find(("9780310432593"));
                            
                            //Class.forName("com.mysql.jdbc.Driver");
                            //cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
                            //st = (Statement) cn.createStatement();
                            //rs = st.executeQuery("select * from userdata;");
                            //while(rs.next())
                            //{
                            //   System.out.println(rs.next());
                            //}

                            // test the book insertion routine
                            //String sql1 = "INSERT INTO BookDB.WorkWithOne VALUES(9, 'UA502f', 'Venice');";
                            //st.executeUpdate(sql1);

                            // test the catalogue search
                            //GoogleBooksApi_Interface_LookUp gn = new GoogleBooksApi_Interface_LookUp();
                            //Book_Parse_Object output = new Book_Parse_Object();
                            //output = gn.google_find_book("9780310432593");
                            System.out.println("hello");
        } 
        //catch (IOException | ClassNotFoundException | SQLException e) 
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        // test the book lookup
        //GoogleBooksApi_Interface_LookUp gn = new GoogleBooksApi_Interface_LookUp();
        //jdbc_conn.getDBEntry("9780310432593");
        
   
    }
    
}
