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
                        //value.append(" ",0,1);
                        value.append(buffer, 0, length); 
                       
                        
                    }
                    System.out.println("block contents: " + value.toString());
                    System.out.println("length of block:  " + value.length());
                    
                    String output;

                    Pattern p_general;
                     //p_general = Pattern.compile("\"?\\w*\"?:?");
                     //p_general = Pattern.compile("\"\\w*\":?");
                     p_general = Pattern.compile("\\s+?\"[A-Za-z]+\":\\s+?(\"?\\[?[A-Za-z0-9+#:/'.\\s+&_=?\"-]+\\]?\"?)");
                     
                    System.out.println("Output from Server .... \n");
                    int i = 1;
                    //while ((output = br.readLine()) != null)
                        {
                            
                            i++;
                            Matcher matcher_general = p_general.matcher(value);
                            

                            String parseResult = "";
                            
                            int count = 0;
                            int groupCount = matcher_general.groupCount();
                            while(matcher_general.find()) {
                                System.out.println("group count "+groupCount);
                                for (int ii = 0; ii <= groupCount; ii++) {
                                System.out.println("hello "+ ii + " " + matcher_general.group(ii));
                                };
                                System.out.println("found: " + count + " : "
                                    + matcher_general.start() + " - " + matcher_general.end());
                               
                                
                                switch(matcher_general.group(0))
                                {
                                    case "author"           :  
                                                        System.out.print("yes\n");
                                                        bpo.setBookAuthors(matcher_general.group(1));   
                                                       break;
                                    case "title"            :   bpo.setBookTitle(matcher_general.group(1));
                                                        break;
                                    case "subtitle"         :   bpo.setBookTitle(matcher_general.group(1));
                                                        break;
                                    case "publisher"        :   bpo.setPublisher(matcher_general.group(1));
                                                        break;
                                    case "publicationdate"  :   bpo.setPublicationDate(matcher_general.group(1));
                                                        break;
                                    case "categories"       :   bpo.setLanugageDesignator(matcher_general.group(1));
                                                        break;
                                    case "country"          :   bpo.setPublicationDate(matcher_general.group(1));
                                                        break;
                                    case "thumbnail"        :   bpo.setLanugageDesignator(matcher_general.group(1));
                                                        break;
                                    case "printedPageCount" :   bpo.setPageCount(1);
                                                        break;
                                };
                            };
                            
                            //System.out.println(matcher_general.find("author"));
                           
                            
                            
                            // requirement is to determine which match group gives us a single string. likely 
                            
                        };
                }
            catch (Exception e)
                {
                    
                };
            System.out.println("and we are done");
    }


    
    
    
};
