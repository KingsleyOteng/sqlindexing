/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
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
     * @param args the command line arguments
     */
    
    JDBC_Interface_Logic() 
    {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB?zeroDateTimeBehavior=convertToNull", "root", "");
                st = (Statement) cn.createStatement();    
            }
            catch (Exception e)
            {
                
            };
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
                java.sql.Date sqlRecordCreationDate = new java.sql.Date(parsed.getTime());
                
                // manual date insertion
                
                parsed = format.parse(borrowDate);
                java.sql.Date sqlBorrowDate = new java.sql.Date(parsed.getTime());
                
                st.executeUpdate
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
                java.sql.Date sqlDateBorrowed= new java.sql.Date(parsed.getTime());
                
                parsed = format.parse(dateDue);
                java.sql.Date sqlDateDue = new java.sql.Date(parsed.getTime());
                
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
                java.sql.Date sqlDateBorrowed = new java.sql.Date(parsed.getTime());
                
                parsed = format.parse(dateDue);
                java.sql.Date sqlDateDue = new java.sql.Date(parsed.getTime());
                
                // insert the book catalogue details into the database
                st.executeUpdate("INSERT INTO BookDB.Catalogue  " + "VALUES( '"+bookName+"','"+author+"','"+category+"','"+categoryDescription+"','"+bookID+"','"+sqlDateBorrowed+"','"+sqlDateDue+"','"+ISBNs[0]+"','"+ISBNs[1]+"','"+copy+"','"+location+"')");
                 
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
                java.sql.Date sqlDateReturned = new java.sql.Date(parsed.getTime());
                
                st.executeUpdate("INSERT INTO BookDB.Returns  " + "VALUES( '"+bookID+"','"+sqlDateReturned+"','"+location+"')");
                 
                cn.close();
            }
            catch (SQLException | ParseException | HeadlessException e)
            {
                System.out.println("hello Returns: "+e);
            }
    
    };
}
