/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

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
            URL url = new URL(GOOGLE_BOOK_SEARCH_URL+ISBN_locator);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null)
                {
                    System.out.println(output);
                };
            }
            catch (Exception e)
            {};
    }


    
    
    
};
