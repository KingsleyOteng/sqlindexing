/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

/**
 *
 * @author kwadwooteng-amoako
 */
public class Book_Parse_Object {
    
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
    
    Book_Parse_Object()
        {
            Book_Parse_Object.bookTitle = "";
            Book_Parse_Object.bookAuthors = "";
            Book_Parse_Object.isbn10 = "";
            Book_Parse_Object.isbn13 = "";
            Book_Parse_Object.publisher = "";
            Book_Parse_Object.publicationDate = "";
            Book_Parse_Object.pageCount = 0;
            Book_Parse_Object.printType = "";
            Book_Parse_Object.mainCategory = "";
            Book_Parse_Object.lanugageDesignator = "";
            Book_Parse_Object.linkURLSmallThumbNail = "";
            Book_Parse_Object.linkURLLargeThumbNail = "";
        };
    
    void setPrintType(String printType)
        {
            Book_Parse_Object.printType = printType;
        };
    
    void setMainCategory(String mainCategory)
        {
            Book_Parse_Object.mainCategory = mainCategory;
        };
    
    void setLanugageDesignator(String lanugageDesignator)
        {
            Book_Parse_Object.lanugageDesignator = lanugageDesignator;
        };
    
    void setILinkURLSmallThumbNail(String linkURLSmallThumbNail)
        {
            Book_Parse_Object.linkURLSmallThumbNail = linkURLSmallThumbNail;
        };
   
     void setILinkURLLargeThumbNail(String linkURLLargeThumbNail)
        {
            Book_Parse_Object.linkURLLargeThumbNail = linkURLLargeThumbNail;
        };
    
    void setBookTitle(String bookTitle)
        {
            Book_Parse_Object.bookTitle = bookTitle;
        };
    
    void setBookAuthors(String bookAuthors)
        {
            Book_Parse_Object.bookAuthors = bookAuthors;
        };
    
    void setISBN10(String isbn10)
        {
            Book_Parse_Object.isbn10 = isbn10;
        };
    
    void setISBN13(String isbn13)
        {
            Book_Parse_Object.isbn13 = isbn13;
        };
    
    void setPublisher(String publisher)
        {
            Book_Parse_Object.publisher = publisher;
        };
    
    void setPublicationDate(String publicationDate)
        {
            Book_Parse_Object.publicationDate = publicationDate;
        };
    
    void setPageCount(int pageCount)
        {
            Book_Parse_Object.pageCount = pageCount;
        };
    
}
