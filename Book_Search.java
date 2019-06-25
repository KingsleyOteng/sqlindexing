/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author kwadwooteng-amoako
 * @date 24 June 2019
 * @description the following class combines the SQL search with a google search
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
            throws MalformedURLException, IOException
    {
            
    };
    
}
