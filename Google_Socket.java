/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kwadwooteng-amoako
 */
public class Google_Socket {

    public static final String GOOGLE_BOOK_SEARCH_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    public static final String GOOGLE_BOOK_SEARCH_URL_END = "+download=epub";

    String parse_search_phrase(String phrase)
    {
        // the following method reomves unwanted phrases from the parsed string
        phrase = phrase.replaceAll("\\[", "").trim();
        phrase = phrase.replaceAll("\\]", "").trim();
        phrase = phrase.replaceAll("  ", "").trim();
        phrase = phrase.replaceAll("\"", "").trim();
        
        return phrase;
    }
    
    BookObject google_find_book(
            String Title_locator
    ) throws MalformedURLException, IOException {
        Pattern p_general;
        BookObject bpo;
        String output;
        BufferedReader br;
        StringBuilder value;
        char[] buffer;
        URL url;
        int count;
        int groupCount;
        String[] testString;
        String parseResult;
        Matcher matcher_general;
        List<String> testStringList;
        String stringMatcherPhrase;
        HashSet<String> intersection;
        String matchedPhrase;
        String[] spltStringMatcherPhrase;
        Object[] stringIntersection;

        //
        String myQuery = Title_locator.replaceAll(" ", "+").toLowerCase();

        //create an object to hold the parse results
        bpo = new BookObject();

        //setup connection to the google api
        //search for book based off of the isbn
        url = new URL(GOOGLE_BOOK_SEARCH_URL + myQuery + GOOGLE_BOOK_SEARCH_URL_END);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        value = new StringBuilder();
        buffer = new char[1024];
        
        // add the buffer results read from the string table to the value string
        for (int length = 0x0; (length = br.read(buffer)) > 0;) {
            value.append(buffer, 0, length);
        }

        // create the regex patter
        p_general = Pattern.compile("\\s+?\"[A-Za-z]+\":\\s+?(\"?\\[?[A-Za-z0-9+#:/'.\\s+&_=?\"-]+\\]?\"?)");

        // ----> May purge
        System.out.println("Output from Server .... \n");
        int i = 1;
       
        {

            i++;
            matcher_general = p_general.matcher(value);

            parseResult = "";

            count = 0;
            groupCount = matcher_general.groupCount();
            while (matcher_general.find()) {

                testString = new String[]{"XX", "authors", "title", "subtitle", "publisher", "publishedDate", "categories", "country", "smallThumbnail", "description", "printType", "pageCount"};
                testStringList = Arrays.asList(testString);

                String s;
                String y;

                s = matcher_general.group(1);
                stringMatcherPhrase = matcher_general.group(0);
                
                // add a terminator to the end of the phrase
                stringMatcherPhrase = stringMatcherPhrase + "#XX";

                spltStringMatcherPhrase = stringMatcherPhrase.split("\\b+");

                List<String> testSpltStringMatcherPhrase;
                testSpltStringMatcherPhrase = Arrays.asList(spltStringMatcherPhrase);

                // include a dummy variable for matching
                // initially seartch such that only candidate strings are searched
                testStringList.contains(testSpltStringMatcherPhrase);

                // create a dictionary of interesecting words
                intersection = new HashSet<>();

                // add the set of key fields
                intersection.addAll(testStringList);

                // determine if there is a match with the new google phrases
                intersection.retainAll(testSpltStringMatcherPhrase);

                // convert from hashset to array
                stringIntersection = intersection.toArray();

                //cycle through the set of phrases scraped from
                for (Object stringIntersection1 : stringIntersection) {
                    
                    // backout the current match phrase which will be used to update the database keyfield
                    matchedPhrase = stringIntersection1.toString();
                    if ((Arrays.asList(spltStringMatcherPhrase).contains(matchedPhrase)) && (!"XX".equals(matchedPhrase))) {
                        
                        //System.out.println(">>>"+Arrays.stream(testString).filter(matcher_general.group(0)::contains).toArray().//);
                        switch (matchedPhrase) {

                            // set the authors name
                            case "authors":
                                bpo.setAuthor(matcher_general.group(1));
                                break;
                                
                            // set the title         
                            case "title":
                                bpo.setBook(matcher_general.group(1));
                                System.out.println("found a title");
                                break;
           
                                
                            // set the publishers name
                            case "publisher":
                                bpo.setPublisher(matcher_general.group(1));
                                break;
                                
                            // set the publication date                     
                            case "publishedDate":
                                String phrase = this.parse_search_phrase(matcher_general.group(1));
                                phrase = phrase.substring(0,4);
                                bpo.setPublishedYear(Integer.valueOf(phrase.substring(0,4)));
                                break;
                                
                            // set the category name
                            case "categories":
                                bpo.setCategories(this.parse_search_phrase(matcher_general.group(1)));
                                break;
                                
                            // set the country details
                            case "country":
                                bpo.setCountry(matcher_general.group(1));
                                break;
                                
                            // set the thumbnail link
                            case "language":
                                bpo.setLanguage(matcher_general.group(1));
                                break;
                                
                            // set the printed page count
                            case "pageCount":
                                bpo.setPageCount(Integer.parseInt(matcher_general.group(1)));
                                break;

                            // set the printed page count
                            case "printType":
                                bpo.setPrintType(matcher_general.group(1));
                                break;

                            // set isbn identifier
                            case "identifier":
                                bpo.setIdentifier(this.parse_search_phrase(matcher_general.group(1)));
                                break;
                                
                            // set description data
                            case "description":
                                bpo.setDescription(this.parse_search_phrase(matcher_general.group(1)));
                                break;

                            // set tumbnail reference
                            case "smallThumbnail":
                                bpo.setThumbNailIndentifier(this.parse_search_phrase(matcher_general.group(1)));
                                break;

                            // capture the introduced value
                            case "XX":
                                break;

                            // break
                            default:
                                break;
                        }
                    }
                }

            }
        }

        System.out.println("and we are done");
        return bpo;
    }

}
