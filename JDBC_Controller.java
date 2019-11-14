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
import java.sql.PreparedStatement;

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

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 11 November 2019
     * @description jdbc find a book
     *
     */
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
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 11 November 2019
     * @description jdbc find a book
     *
     */
    BookObject[] jdbc_find_book(BookObject[] obj)
            throws MalformedURLException, IOException, SQLException {

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
                obj[i].setBook(rs.getString("BookName"));
                obj[i].setISBN1("ISBN1");
                obj[i].setId(i);
                i++;

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return obj;
    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 11 November 2019
     * @description jdbc find a student by string
     *
     */
    PupilObject[] jdbc_find_student(PupilObject[] obj, String toggle, String query)
            throws MalformedURLException, IOException, SQLException {

        //Book_Parse_Object bpo = new Book_Parse_Object();
        // JDBC_Controller jdbc_conn = new JDBC_Controller();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

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
                    break;
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

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return obj;
    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 11 November 2019
     * @description jdbc general search string
     *
     */
    BookObject[] jdbc_search_book(BookObject[] obj, String toggle, String query)
            throws MalformedURLException, IOException, SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

            // generate a results set 
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

            }

            int i = 0;

            // if there is an empty results set go to google
            if (!rs.isBeforeFirst()) {
                System.out.println("Empty results set");
                return null;

            } 

            while (rs.next()) {

                obj[i] = new BookObject();
                obj[i].setBook(rs.getString("BookName"));
                obj[i].setAuthor(rs.getString("Author"));
                obj[i].setId(1);
                obj[i].setISBN1(rs.getString("ISBN1"));
                obj[i].setCategories(rs.getString("Category"));
                obj[i].setDescription(rs.getString("CategoryDescription"));
                obj[i].setStatus(rs.getBoolean("BorrowedStatus"));
                i++;

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
       
        
        return obj;
    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 11 November 2019
     * @description jdbc find a single string
     *
     */
    BookObject jdbc_search_singlebook(BookObject obj, String isbn_query)
            throws MalformedURLException, IOException, SQLException {

        try {

            // create SQL socker
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");

            // initiate a statement
            st = (Statement) cn.createStatement();

            // search by the isbn1 which will be a unique key
            rs = st.executeQuery("select * from BookDB.Catalogue where ISBN1 = '" + isbn_query + "';");

            // remember; the while command initiates populating the object from SQL
            while (rs.next()) {

                obj = new BookObject();
                obj.setBook(rs.getString("BookName"));
                obj.setAuthor(rs.getString("Author"));
                obj.setYear(rs.getString("PublicationYear"));
                obj.setId(1);
                obj.setISBN1(rs.getString("ISBN1"));
                obj.setDescription(rs.getString("CategoryDescription"));
                obj.setFilePath(rs.getString("ImageFile"));
                obj.setOverview(rs.getString("BookDescription"));
                obj.setStatus(rs.getBoolean("BorrowedStatus"));
                obj.setCategories(rs.getString("Category"));

                break;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return obj;
    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 11 November 2019
     * @description jdbc find a book string using the firstname
     *
     */
    StudentRegisterd jdbc_quick_search_firstname(String query)
            throws MalformedURLException, IOException, SQLException {
        StudentRegisterd obj = new StudentRegisterd();

        System.out.println();
        try {

            //create socket
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

            // search database
            rs = st.executeQuery("SELECT * FROM BookDb.StudentRecords WHERE FirstName LIKE '%" + query + "%';");

            // update fields and then exit
            while (rs.next()) {
                obj.setLastname(rs.getString("LastName"));
                obj.setClassd(rs.getInt("ClassWhenRecordCreated"));
                obj.setNumberofbooks(rs.getInt("NumberOfBooksBorrowed"));
                obj.setId(rs.getInt("BorrowerID"));
                obj.setFirstname(rs.getString("FirstName"));
                obj.setDate("hello");
                obj.setTimestamp("one");
                break;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return obj;
    }

    ;
   

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 11 November 2019
     * @description jdbc find a book string using the lastname
     *
     */
    StudentRegisterd jdbc_quick_search_lastname(String query)
            throws MalformedURLException, IOException, SQLException {
        StudentRegisterd obj = new StudentRegisterd();

        System.out.println();
        try {

            //create socket
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

            // search database
            rs = st.executeQuery("SELECT * FROM BookDb.StudentRecords WHERE Lastname LIKE '%" + query + "%';");

            // update fields and then exit
            while (rs.next()) {
                obj.setLastname(rs.getString("LastName"));
                obj.setClassd(rs.getInt("ClassWhenRecordCreated"));
                obj.setNumberofbooks(rs.getInt("NumberOfBooksBorrowed"));
                obj.setId(rs.getInt("BorrowerID"));
                obj.setFirstname(rs.getString("FirstName"));
                obj.setDate("hello");
                obj.setTimestamp("one");
                break;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return obj;
    }

    ;
   
    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 11 November 2019
     * @description jdbc find a book string
     *
     */
    StudentRegisterd jdbc_quick_search_fx_borrowpage_borrower(String query)
            throws MalformedURLException, IOException, SQLException {
        StudentRegisterd obj = new StudentRegisterd();

        System.out.println();
        try {

            //create socket
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

            // search database
            rs = st.executeQuery("SELECT * FROM BookDb.StudentRecords WHERE Surname LIKE '%" + query + "%';");

            // update fields and then exit
            while (rs.next()) {
                obj.setLastname(rs.getString("LastName"));
                obj.setClassd(rs.getInt("ClassWhenRecordCreated"));
                obj.setNumberofbooks(rs.getInt("NumberOfBooksBorrowed"));
                obj.setId(rs.getInt("BorrowerID"));
                obj.setFirstname(rs.getString("FirstName"));
                obj.setDate("hello");
                obj.setTimestamp("one");
                break;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return obj;
    }

    ;
    
    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 24 August 2019
     * @description search for a book in jdbc
     *
     */
    StudentRegisterd jdbc_quick_search_fx_borrowpage_school_level(String query)
            throws MalformedURLException, IOException, SQLException {
        StudentRegisterd obj = new StudentRegisterd();

        System.out.println();
        try {

            //create socket
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

            // search database
            rs = st.executeQuery("SELECT * FROM BookDb.StudentRecords WHERE ClassWhenRecordCreated LIKE '%" + query + "%';");

            // update fields and then exit
            while (rs.next()) {
                obj.setLastname(rs.getString("LastName"));
                obj.setClassd(rs.getInt("ClassWhenRecordCreated"));
                obj.setNumberofbooks(rs.getInt("NumberOfBooksBorrowed"));
                obj.setId(rs.getInt("BorrowerID"));
                obj.setFirstname(rs.getString("FirstName"));
                obj.setDate("hello");
                obj.setTimestamp("one");
                break;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return obj;
    }

    ;
    
     // jdbc find a book
    StudentRegisterd jdbc_quick_search_fx_borrowpage_id(String query)
            throws MalformedURLException, IOException, SQLException {
        StudentRegisterd obj = new StudentRegisterd();

        try {

            //create socket
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

            // search database
            rs = st.executeQuery("SELECT * FROM BookDb.StudentRecords WHERE BorrowerID LIKE '%" + query + "%';");

            // update fields and then exit
            while (rs.next()) {
                obj.setLastname(rs.getString("LastName"));
                obj.setClassd(rs.getInt("ClassWhenRecordCreated"));
                obj.setNumberofbooks(rs.getInt("NumberOfBooksBorrowed"));
                obj.setId(rs.getInt("BorrowerID"));
                obj.setFirstname(rs.getString("FirstName"));
                obj.setDate("hello");
                obj.setTimestamp("one");
                break;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return obj;
    }

    ;
    
    // jdbc find a book
    StudentRegisterd jdbc_return_book(String ISBN1)
            throws MalformedURLException, IOException, SQLException {
        StudentRegisterd obj = new StudentRegisterd();

        try {

            //create socket
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

            // search database
            st.executeUpdate("UPDATE BookDb.Catalogue SET BorrowedStatus = 0 WHERE ISBN1 = " + ISBN1 + ";");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return obj;
    }

    ;

     // jdbc find a book
    public void jdbc_quick_insert(LibraryBooksStatus obj) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) cn.createStatement();

            String sqlString;
            
            sqlString = "INSERT INTO BookDB.Catalogue (BookName,Author) VALUES (?,?)";

            String sqlString2 = "INSERT INTO BookDB.Catalogue  (`BookName`, `Author`, `Category`, `CategoryDescription`, `BookID`, `DateBorrowed`, `DateDue`, `BorrowerID`, `ISBN1`, `ISBN2`, `Copy`, `Location`, `ImageURL`, `PublicationYear`, `BorrowedStatus`, `ImageFile`, `BookDescription`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = cn.prepareStatement(sqlString2);

            java.sql.Date date = getCurrentJavaSqlDate();

            System.out.println("Book title" + obj.getBook());

            pstmt.setString(1, obj.getBook());
            pstmt.setString(2, obj.getAuthor());
            pstmt.setString(3, obj.getCategories());
            pstmt.setString(4, "XX");
            pstmt.setString(5, "00000");
            pstmt.setDate(6, date);
            pstmt.setDate(7, date);
            pstmt.setString(8, "XX");
            pstmt.setString(9, obj.getIsbn1());
            pstmt.setString(10, "XX");
            pstmt.setInt(11, 1);
            pstmt.setString(12, "HIBS");
            pstmt.setString(13, obj.getThumbNailIdentifier());
            pstmt.setInt(14, obj.getYear());
            pstmt.setInt(15, 1);
            pstmt.setString(16, obj.getFILE());
            pstmt.setString(17, obj.getDescription());

            pstmt.execute();

            //rs = st.executeQuery(sqlString);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    };
    
    // generate a data string and format it it into an acceptable java sql format
    public static java.sql.Date getCurrentJavaSqlDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
}
