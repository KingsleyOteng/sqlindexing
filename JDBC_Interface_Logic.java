/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

//import static BookWareHousing.Bookwarehouse.cn;
import static BookWareHousing.Book_Parse_Object.REPLACEMENT_FLAGS;
import static BookWareHousing.Book_Parse_Object.REPLACEMENT_FLAGS_VALUE_SPACE;
import static BookWareHousing.Book_Parse_Object.REPLACEMENT_FLAG_SINGLE_COMMA;
import static BookWareHousing.Book_Parse_Object.REPLACEMENT_FLAG_SINGLE_COMMA_VALUE;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author kwadwooteng-amoako
 */
public class JDBC_Interface_Logic {
    
     /**
     * @param args the command line arguments
     */
    static Connection cn; 
    static Statement st; 
    static ResultSet rs; 
    
     /**
     * @author kwadwooteng-amoako
     * @date  9 July 2019
     * @description the following section captures the JDBC search routines
     *
     */
    
    JDBC_Interface_Logic() throws SQLException 
    {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
                st = (Statement) cn.createStatement ();    
            }
            catch (ClassNotFoundException | SQLException e)
            {
                
            }
    };

    
// jdbc find a book
Book_Parse_Object jdbc_find_book
(
    String ISBN_locator      
) 
    throws MalformedURLException, IOException, SQLException   
{
        
        Book_Parse_Object bpo = new Book_Parse_Object ();
        JDBC_Interface_Logic jdbc_conn = new JDBC_Interface_Logic ();
        
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
                st = (Statement) cn.createStatement ();
                rs = st.executeQuery("select * from BookDB.Catalogue where BookID ="+ISBN_locator+";");
                while(rs.next())
                {   
                    bpo.setSearchResult(true);
                    bpo.setBookAuthors(rs.getString("Author"));
                    bpo.setBookTitle(rs.getString("BookName"));
                    bpo.setCategories(rs.getString("CategoryDescription"));
                    bpo.setMainCategory(rs.getString("Category"));
                    //bpo.setILinkURLLargeThumbNail(ISBN_locator);
                    //bpo.setILinkURLSmallThumbNail(ISBN_locator);
                    //bpo.setISBN10(ISBN_locator);
                    //bpo.setISBN13(ISBN_locator);
                    //bpo.setPageCount(0);
                    //bpo.setPrintType(ISBN_locator);
                    

                }    
            } 
            catch (ClassNotFoundException | SQLException e) 
            {
                    System.out.println(e);
            }
        
        return bpo;
};
        
// structure for a borrower request
void new_borrow_request
        (
            
            String lastName,          
            String recordCreationDate,
            int classWhenRecordCreated,
            int numberOfBooksBorrowed,
            int overdue,
            String borrowerID,
            String school, 
            String[] bookID,
            String borrowDate,
            String firstName
        )   
    
    {
        
        
           
            
            
            try 
            {
                // New overdue books
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                Date parsed = format.parse(recordCreationDate);
                java.sql.Date sqlRecordCreationDate = new java.sql.Date(parsed.getTime ());
                
                // manual date insertion
                
                parsed = format.parse(borrowDate);
                java.sql.Date sqlBorrowDate = new java.sql.Date(parsed.getTime ());
                
                st.executeUpdate
                
                // update the database
                ("INSERT INTO BookDB.BookedRecords  " + "VALUES( '"+lastName+"','"+sqlRecordCreationDate+"','"+classWhenRecordCreated+"','"+numberOfBooksBorrowed+"','"+overdue+"','"+borrowerID+"','"+school+"','"+bookID[0]+"','"+bookID[1]+"','"+bookID[2]+"','"+bookID[3]+"','"+bookID[4]+"','"+sqlBorrowDate+"','"+firstName+"')");
                 
            
                cn.close();
            }
            catch (SQLException | ParseException | HeadlessException e)
            {
                System.out.println("hello BookedRecords: "+e);
            }
    };
        
// structure for an overdue book request   
void overdue_book
    (
            String borrowerID,
            String dateBorrowed,
            String dateDue,
            int dayOverdue,
            String bookID,
            String[] ISBNs           
    )   
    
    {
            try 
            {
                // Pull up the list of overdue books
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                Date parsed = format.parse(dateBorrowed);
                java.sql.Date sqlDateBorrowed= new java.sql.Date(parsed.getTime ());
                
                parsed = format.parse(dateDue);
                java.sql.Date sqlDateDue = new java.sql.Date(parsed.getTime ());
                
                // insert the actual book details into the database
                st.executeUpdate("INSERT INTO BookDB.OverdueBooks  " + "VALUES( '"+borrowerID+"','"+sqlDateBorrowed+"','"+sqlDateDue+"','"+dayOverdue+"','"+ISBNs[0]+"','"+ISBNs[1]+"')");
                
                cn.close();
                
                
            }
            catch (SQLException | ParseException | HeadlessException e)
            {
                  System.out.println("hello OverdueBooks: "+e);
            }
    
    };
// structure for a catalogue request    
void catalogue
    (
            String bookName,
            String author,
            String category,
            String categoryDescription,
            String bookID, //hello
            String dateBorrowed,
            String dateDue,
            String borrowerID,
            String[] ISBNs,
            int copy,
            String location
    )   
    
    {
            try 
            {
                // Pull up the catalogue of books
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                Date parsed = format.parse(dateBorrowed);
                java.sql.Date sqlDateBorrowed = new java.sql.Date(parsed.getTime ());
                
                parsed = format.parse(dateDue);
                java.sql.Date sqlDateDue = new java.sql.Date(parsed.getTime ());
                
                // insert the book catalogue details into the database
                st.executeUpdate("INSERT INTO BookDB.Catalogue  " + "VALUES( '"+bookName+"','"+author+"','"+category+"','"+categoryDescription+"','"+bookID+"','"+sqlDateBorrowed+"','"+sqlDateDue+"','"+ISBNs[0]+"','"+ISBNs[1]+"','"+copy+"','"+location+"')");
                 
                cn.close();
            }
            catch (SQLException | ParseException | HeadlessException e)
            {
                System.out.println("hello Catalogue: "+e);
            }
    
    };
    
void setBorrowDates 
    (
        Book_Parse_Object bpo, 
        String borrow_date, 
        String return_date 
    )
            
    {
        bpo.setBookBorrowDate(borrow_date);
        bpo.setBookDueDate(return_date);
    };

void delDBEntry
    (
            String catalogue_id,
            Book_Parse_Object bpo
    )
    {
                try
                {
                    st.executeUpdate("DELETE FROM BookDB.Catalogue WHERE BookID ="+catalogue_id);
                }
                catch (SQLException e)
                {
                    System.out.println("hello Catalogue: "+e);
                }
  
    };
    
// structure for a catalogue request to be filed in the database    
void setDBEntry
    (
        Book_Parse_Object bpo
    )   
    
    {
            try 
            {
                // Pull up the catalogue of books
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                String temp;
                temp = bpo.getBookBorrowDate ();
                Date parsed = format.parse(bpo.getBookBorrowDate ());
                java.sql.Date sqlDateBorrowed;
                sqlDateBorrowed = new java.sql.Date(parsed.getTime ());
                
                parsed = format.parse(bpo.getBookDueDate ());
                java.sql.Date sqlDateDue = new java.sql.Date(parsed.getTime ());
                
                // insert the book catalogue details into the database
                // st.executeUpdate("INSERT INTO BookDB.Catalogue  " + "VALUES( '"+bpo.getBookName ()+"','"+bpo.getAuthor ()+"','"+bpo.getCategory ()+"','"+bpo.getCategoryDescription ()+"','"+bpo.getBookID ()+"','"+bpo.getSqlDateBorrowed ()+"','"+bpo.getSqlDateDue ()+"','"+bpo.getISBNs (0)+"','"+bpo.getISBNs (1)+"','"+bpo.getCopy ()+"','"+bpo.getLocation ()+"')");
                System.out.println("Hello"+ bpo.getBookName ());
                String printType = bpo.getBookName();
                printType = printType.replaceAll("'|\n|#", "");
                printType = printType.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
                
                
                st.executeUpdate("INSERT INTO BookDB.Catalogue  " + "VALUES( '"+printType+"','"+bpo.getAuthor()+"','"+bpo.getCategory()+"','"+bpo.getCategoryDescription()+"','"+bpo.getBookID()+"','"+bpo.getBookBorrowDate()+"','"+bpo.getBookDueDate()+"','"+bpo.getBookID()+"','"+bpo.getISBNs(0)+"','"+bpo.getISBNs(1)+"','"+bpo.getCopy()+"','"+bpo.getLocation()+"','"+bpo.getThumbNailIndentifier()+"')");

                
                cn.close();
            }
            catch (SQLException | ParseException | HeadlessException e)
            {
                System.out.println("hello Catalogue: "+e);
            }
    
    };

//structure for a book return
void returns
    (
            String bookID,
            String dateReturned,
            String location
    )   
    
    {
            try 
            {
                // Returned books to the digital catalogue
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                Date parsed = format.parse(dateReturned);
                java.sql.Date sqlDateReturned = new java.sql.Date(parsed.getTime ());
                
                st.executeUpdate("INSERT INTO BookDB.Returns  " + "VALUES( '"+bookID+"','"+sqlDateReturned+"','"+location+"')");
                 
                cn.close();
            }
            catch (SQLException | ParseException | HeadlessException e)
            {
                System.out.println("hello Returns: "+e);
            }
    
    };
    
  void getDBEntry
    (
            String bookID
    )
    {
            try 
            {
                //st.executeUpdate;
                System.out.println("SELECT * FROM BookDB.BookedRecords WHERE BookID4 = "+bookID);
                Connection conn2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
                Statement s = (Statement) conn2.createStatement ();
                rs = s.executeQuery("SELECT * FROM BookDB.BookedRecords WHERE BookID4 = '9101112131415161718'");
                //System.out.println(rs.toString());
           //     System.out.println("00000");
            //    String ln = rs.getString("LastName");
              //  System.out.print(ln);
               //   System.out.println("00001");
                while (rs.next())
                {
                            System.out.println("hello");
                            //int id = rs.getInt("id");
                            String ln       = rs.getString("LastName");
                            String rcd      = rs.getString("RecordCreationDate");
                            String cwrc     = rs.getString("ClassWhenReocordCreated");
                            String nbb      = rs.getString("NumberBooksBorrowed");
                            String overdue  = rs.getString("Overdue");
                            String bid      = rs.getString("BorrowerID");
                            String school   = rs.getString("School");
                            String bid1     = rs.getString("BookID1");
                            String bid2     = rs.getString("BookID2");
                            String bid3     = rs.getString("BookID3");
                            String bid4     = rs.getString("BookID4");
                            String bid5     = rs.getString("BookID5");
                            String bd       = rs.getString("BorrowDate");
                            String fn       = rs.getString("FirstName");
        
                            // print the results
                            System.out.format("%s\n", cwrc);
                            
                            cn.close();
                }
            }
            catch (SQLException e)
            {
                            System.out.println("hello Returns: "+e);
            }
          
    };
}
