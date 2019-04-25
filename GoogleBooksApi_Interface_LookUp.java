/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

import static BookWareHousing.Bookwarehouse.rs;
import static BookWareHousing.JDBC_Interface_Logic.st;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.io.IOException;
import java.util.Scanner;

import java.net.*;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;



/**
 *
 * @author kwadwooteng-amoako
 */
public class GoogleBooksApi_Interface_LookUp {
    
    /**
     *
     */
    public static final String GOOGLE_BOOK_SEARCH_URL = "https://www.googleapis.com/books/v1/volumes?q=isbn:";
    
    
    
    
    void find_book
    (
            String ISBN_locator        
    )   
    {
            try {
            
                    //create an object to hold the parse results
                    Book_Parse_Object bpo = new Book_Parse_Object();

                    //setup connection to the google api
                    //search for book based off of the isbn
                    URL url = new URL(GOOGLE_BOOK_SEARCH_URL+ISBN_locator);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder value = new StringBuilder();
                    char[] buffer = new char[1024];
                    for (int length = 0; (length = br.read(buffer)) > 0;) {
                        value.append(buffer, 0, length); 
                    }
                    System.out.println(value.toString());
                    
                    String output;

                    Pattern p_general;
                    p_general = Pattern.compile("\"?\\w*\"?:?");
                    // Pattern p_authors = Pattern.compile("\"authors\":\\s");
                    // Pattern p_title = Pattern.compile("\"title\":\\s");
                    // Pattern p_subtitle = Pattern.compile("\"subtitle\":\\s");
                    // Pattern p_publisher = Pattern.compile("\"publisher\":\\s");
                    // Pattern p_publicationdate = Pattern.compile("\"publicationDate\":\\s");
                    // Pattern p_pagecount = Pattern.compile("\"printedPageCount\":\\s");
                    // Pattern p_designator = Pattern.compile("\"categories\":\\s");
                    // Pattern p_country = Pattern.compile("\"country\":\\s");
                    // Pattern p_image = Pattern.compile("\"thumbnail\":\\s");
                
                    
            
                    System.out.println("Output from Server .... \n");
                    while ((output = br.readLine()) != null)
                        {
                            Matcher matcher_general = p_general.matcher(output);
                           //  Matcher matcher_authors = p_authors.matcher(output);
                           //  Matcher matcher_title = p_title.matcher(output);
                           //  Matcher matcher_subtitle = p_subtitle.matcher(output);
                           //  Matcher matcher_publisher = p_publisher.matcher(output);
                            // Matcher matcher_publicationDate = p_publicationdate.matcher(output);
                            // Matcher matcher_pagecount = p_pagecount.matcher(output);
                           //  Matcher matcher_designator = p_designator.matcher(output);
                            // Matcher matcher_country = p_country.matcher(output);
                            // Matcher matcher_image = p_image.matcher(output);
                            
                            
                            System.out.println(output);
                            String parseResult = "";
                            
                            // requirement is to determine which match group gives us a single string. likely 
                            switch(matcher_general.group(2))
                                {
                                    case "author"           :  bpo.setBookAuthors(parseResult);   
                                                       break;
                                    case "title"            :   bpo.setBookTitle(parseResult);
                                                        break;
                                    case "subtitle"         :   bpo.setBookTitle(parseResult);
                                                        break;
                                    case "publisher"        :   bpo.setPublisher(parseResult);
                                                        break;
                                    case "publicationdate"  :   bpo.setPublicationDate(parseResult);
                                                        break;
                                    case "categories"       :   bpo.setLanugageDesignator(parseResult);
                                                        break;
                                    case "country"          :   bpo.setPublicationDate(parseResult);
                                                        break;
                                    case "thumbnail"        :   bpo.setLanugageDesignator(parseResult);
                                                        break;
                                    case "printedPageCount" :   bpo.setPageCount(1);
                                                        break;
                                };
                        };
                }
            catch (Exception e)
                {
                    
                };
    }


    
    
    
};
