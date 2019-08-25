/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author kwadwooteng-amoako
 */
public class JDBC_Controller {

    /**
     * @param args the command line arguments
     */
    static Connection cn;
    static Statement st;
    static ResultSet rs;

    /**
     * @author kwadwooteng-amoako
     * @date 23 August 2019
     * @description the following section captures the JDBC search routines
     *
     */
    JDBC_Controller() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    // jdbc find a book
    void jdbc_find_book()
            throws MalformedURLException, IOException, SQLException {

        //Book_Parse_Object bpo = new Book_Parse_Object();
        // JDBC_Controller jdbc_conn = new JDBC_Controller();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();
            //rs = st.executeQuery("select * from BookDB.Catalogue where BookID =" + ISBN_locator + ";");
            rs = st.executeQuery("select * from BookDB.Catalogue;");
            while (rs.next()) {

                System.out.println(rs.getString("BookName") + " by " + rs.getString("Author") + "; category" + rs.getString("CategoryDescription"));
                //bpo.setSearchResult(true);
                //bpo.setBookAuthors(rs.getString("Author"));
                //bpo.setBookTitle(rs.getString("BookName"));
                //bpo.setCategories(rs.getString("CategoryDescription"));
                //bpo.setMainCategory(rs.getString("Category"));
                //bpo.setILinkURLLargeThumbNail(ISBN_locator);
                //bpo.setILinkURLSmallThumbNail(ISBN_locator);
                //bpo.setISBN10(ISBN_locator);
                //bpo.setISBN13(ISBN_locator);
                //bpo.setPageCount(0);
                //bpo.setPrintType(ISBN_locator);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        //return bpo;
    }
    
    // jdbc find a book
    BookObject[] jdbc_find_book(BookObject[] obj)
            throws MalformedURLException, IOException, SQLException {

        //Book_Parse_Object bpo = new Book_Parse_Object();
        // JDBC_Controller jdbc_conn = new JDBC_Controller();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();
            //rs = st.executeQuery("select * from BookDB.Catalogue where BookID =" + ISBN_locator + ";");
            rs = st.executeQuery("select * from BookDB.Catalogue;");
            
            int i = 0;
            while (rs.next()) {
                
                obj[i] = new BookObject();
                obj[i].setStudent_name("NBN");
                obj[i].setStudent_year(1992);
                obj[i].setAuthor(rs.getString("Author"));
                obj[i].setBook_name(rs.getString("BookName"));   
                obj[i].setId(i);
                i++;
                
                //System.out.println(rs.getString("BookName") + " by " + rs.getString("Author") + "; category" + rs.getString("CategoryDescription"));
                //bpo.setSearchResult(true);
                //bpo.setBookAuthors(rs.getString("Author"));
                //bpo.setBookTitle(rs.getString("BookName"));
                //bpo.setCategories(rs.getString("CategoryDescription"));
                //bpo.setMainCategory(rs.getString("Category"));
                //bpo.setILinkURLLargeThumbNail(ISBN_locator);
                //bpo.setILinkURLSmallThumbNail(ISBN_locator);
                //bpo.setISBN10(ISBN_locator);
                //bpo.setISBN13(ISBN_locator);
                //bpo.setPageCount(0);
                //bpo.setPrintType(ISBN_locator);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return obj;
    }
}
