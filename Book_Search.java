/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 *
 * @author kwadwooteng-amoako
 * @date 2 July 2019
 * @description the following class combines the SQL search with a google search; we decided to combine the two classes into one instead of calling them seperately.
 *
 */
public class Book_Search {
    
    // string constants with regex matching values used to match entries in the book record object
    public static final String REPLACEMENT_FLAGS = "\"|\n";
    public static final String REPLACEMENT_FLAG_SINGLE_COMMA  = "\\'";
    public static final String REPLACEMENT_FLAG_BRACKETS = "\\[|\\]";
    
    // string constants with regex matching values used to replace entries in the book record object
    public static final String REPLACEMENT_FLAG_SINGLE_COMMA_VALUE  = "'";
    public static final String REPLACEMENT_FLAGS_VALUE_SPACE = "";
    
    static private String bookTitle;
    static private String bookAuthors;
    static private String isbn10;
    static private String isbn13;
    static private String publisher;
    static private String publicationDate;
    static private int pageCount;
    static private String printType;
    static private String mainCategory;
    static private String lanugageDesignator;
    static private String linkURLSmallThumbNail;
    static private String linkURLLargeThumbNail;
    
    void universal_find
    (
            String ISBN_locator 
    ) 
            throws MalformedURLException, IOException, SQLException
    {
            
            //First search the local database and if found do nothing else
            JDBC_Interface_Logic sql_handle                 = new JDBC_Interface_Logic();
            GoogleBooksApi_Interface_LookUp google_handle   = new GoogleBooksApi_Interface_LookUp();
            Book_Parse_Object BPO1, BPO2 = new Book_Parse_Object();
            
            // where the sql search is successful, proceed
            BPO1 = sql_handle.jdbc_find_book(ISBN_locator);
            if (BPO1.getSearchResult())
                {
                    System.out.println("-------------------------------------------------> Searching using sql....");         
                }
            else 
                {
                       // where the sql seart is not succesful proceed with a google search
                    BPO2 = google_handle.google_find_book(ISBN_locator);
                    sql_handle.setDBEntry(BPO2);
                    System.out.println("-------------------------------------------------> Searching using google....");
                }
            
         
    };
    
}