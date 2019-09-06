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
 * @description it handles all of the sql objects
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

    // jdbc find a book
    PupilObject[] jdbc_find_student(PupilObject[] obj, String toggle, String query)
            throws MalformedURLException, IOException, SQLException {

        //Book_Parse_Object bpo = new Book_Parse_Object();
        // JDBC_Controller jdbc_conn = new JDBC_Controller();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();
            //rs = st.executeQuery("select * from BookDB.Catalogue where BookID =" + ISBN_locator + ";");

            switch (toggle) {
                case "firstname":
                    rs = st.executeQuery("select * from BookDB.StudentRecords where BorrowerID = '" + query + "';");
                    break;
                case "lastname":
                    rs = st.executeQuery("select * from BookDB.StudentRecords where LastName = '" + query + "';");
                    break;
                case "studentnumber":
                    rs = st.executeQuery("select * from BookDB.StudentRecords where FirstName = '" + query + "';");
                    break;
                default:
                    System.out.println("hello");
            }

            int i = 0;

            while (rs.next()) {

                obj[i] = new PupilObject();
                obj[i].setBookid(rs.getString("BookID"));
                obj[i].setBorrowerid(rs.getString("BorrowerID"));
                obj[i].setClasswhenrecordcreated(rs.getString("ClassWhenRecordCreated"));
                //obj[i].setDate((rs.getString("Date")));
                obj[i].setDate(1);
                obj[i].setFirstname(rs.getString("FirstName"));
                obj[i].setLastname(rs.getString("LastName"));
                obj[i].setNumberofbooksborrowed(Integer.parseInt(rs.getString("NumberOfBooksBorrowed")));
                obj[i].setSchool(rs.getString("School"));
                //obj[i].setTimestamp(Integer.parseInt(rs.getString("TimeStamp")));
                obj[i].setTimestamp(2);
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

    // jdbc find a book
    BookObject[] jdbc_search_book(BookObject[] obj, String toggle, String query)
            throws MalformedURLException, IOException, SQLException {

        //Book_Parse_Object bpo = new Book_Parse_Object();
        // JDBC_Controller jdbc_conn = new JDBC_Controller();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();
            //rs = st.executeQuery("select * from BookDB.Catalogue where BookID =" + ISBN_locator + ";");

            switch (toggle) {
                case "searchtitle":
                    rs = st.executeQuery("select * from BookDB.Catalogue where BookName = '" + query + "';");
                    break;
                case "searchauthor":
                    rs = st.executeQuery("select * from BookDB.Catalogue where Author = '" + query + "';");
                    break;
                case "searchisbn":
                    rs = st.executeQuery("select * from BookDB.Catalogue where ISBN1 = '" + query + "';");
                    break;
                default:
                    System.out.println("hello");
            }

            int i = 0;

            while (rs.next()) {

                obj[i] = new BookObject();
                obj[i].setBook_name(rs.getString("BookName"));
                obj[i].setAuthor(rs.getString("Author"));
                obj[i].setId(1);
                //obj[i].setStudent_name("1");
                obj[i].setStatus("1");
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
