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
 * @date 23 August 2019
 * @description the following class combines the SQL search with a google
 * search; we decided to combine the two classes into one instead of calling
 * them seperately.
 *
 */
public class Book_Search {

    // string constants with regex matching values used to match entries in the book record object
    public static final String REPLACEMENT_FLAGS = "\"|\n";
    public static final String REPLACEMENT_FLAG_SINGLE_COMMA = "\\'";
    public static final String REPLACEMENT_FLAG_BRACKETS = "\\[|\\]";

    // string constants with regex matching values used to replace entries in the book record object
    public static final String REPLACEMENT_FLAG_SINGLE_COMMA_VALUE = "'";
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

    void universal_find(
            String ISBN_locator
    )
            throws MalformedURLException, IOException, SQLException {
        JDBC_Interface_Logic sql_handle;
        GoogleBooksApi_Interface_LookUp google_handle;
        String borrow_date;
        String return_date;

        // create an SQL object
        sql_handle = new JDBC_Interface_Logic();

        // create an object to connect to the google webservice
        google_handle = new GoogleBooksApi_Interface_LookUp();

        //First search the local database and if found do nothing else
        // create an object to hold the text parsing objects
        Book_Parse_Object BPO1, BPO2 = new Book_Parse_Object();

        // where the sql object is successful created, proceed to search
        BPO1 = sql_handle.jdbc_find_book(ISBN_locator);

        // work though the SQL objects and the SQL tables
        if (BPO1.getSearchResult()) {
            // initially attempt to locate the book in the SQL database
            System.out.println("-------------------------------------------------> Searching using sql....");
            sql_handle.setDBEntry(BPO1);
        } else {
            // where the sql search is not succesful proceed with a google search
            // pass the class an ISBN locator as a type string - it then returns an object with the filled parameters
            BPO1 = google_handle.google_find_book(ISBN_locator);

            // let us store the object in the SQL table; using the object returned set the corresponding data parameters
            borrow_date = "20191130";
            return_date = "20191101";
            sql_handle.setBorrowDates(BPO1, borrow_date, return_date);

            // store the borrowing object in the SQL database
            sql_handle.setDBEntry(BPO1);
            System.out.println("-------------------------------------------------> Searching using google....");
        }

    }
;

}
