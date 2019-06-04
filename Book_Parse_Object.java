/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

/**
 *
 * @author kwadwooteng-amoako
 * @date 4 June 2019
 */
public class Book_Parse_Object {
    
    public static final String REPLACEMENT_FLAGS = "\"|\n";
    public static final String REPLACEMENT_FLAG_SINGLE_COMMA  = "\'";
    
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
    
   // routines to update the object used for update the database
    void setPrintType(String printType)
        {
            printType = printType.replaceAll(REPLACEMENT_FLAGS, "");
            printType = printType.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.printType = printType;
           
        };
    
    void setMainCategory(String mainCategory)
        {
            mainCategory = mainCategory.replaceAll(REPLACEMENT_FLAGS, "");
            mainCategory = mainCategory.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.mainCategory = mainCategory;
        };
    
    void setLanugageDesignator(String lanugageDesignator)
        {
            lanugageDesignator = lanugageDesignator.replaceAll(REPLACEMENT_FLAGS, "");
            lanugageDesignator = lanugageDesignator.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.lanugageDesignator = lanugageDesignator;
        };
    
    void setILinkURLSmallThumbNail(String linkURLSmallThumbNail)
        {
            linkURLSmallThumbNail = linkURLSmallThumbNail.replaceAll(REPLACEMENT_FLAGS, "");
            linkURLSmallThumbNail = linkURLSmallThumbNail.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.linkURLSmallThumbNail = linkURLSmallThumbNail;
        };
   
     void setILinkURLLargeThumbNail(String linkURLLargeThumbNail)
        {
            linkURLLargeThumbNail = linkURLLargeThumbNail.replaceAll(REPLACEMENT_FLAGS, "");
            linkURLLargeThumbNail = linkURLLargeThumbNail.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.linkURLLargeThumbNail = linkURLLargeThumbNail;
        };
    
    void setBookTitle(String bookTitle)
        {
            bookTitle = bookTitle.replaceAll(REPLACEMENT_FLAGS, "");
            bookTitle = bookTitle.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.bookTitle = bookTitle;
        };
    
    void setBookAuthors(String bookAuthors)
        {
            bookAuthors = bookAuthors.replaceAll(REPLACEMENT_FLAGS, "");
            bookAuthors = bookAuthors.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.bookAuthors = bookAuthors;
        };
    
    void setISBN10(String isbn10)
        {
            isbn10 = isbn10.replaceAll(REPLACEMENT_FLAGS, "");
            isbn10 = isbn10.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.isbn10 = isbn10;
        };
    
    void setISBN13(String isbn13)
        {
            isbn13 = isbn13.replaceAll(REPLACEMENT_FLAGS, "");
            isbn13 = isbn13.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.isbn13 = isbn13;
        };
    
    void setIdentifier(String ISBN)
        {
            ISBN = ISBN.replaceAll(REPLACEMENT_FLAGS, "");
            if (ISBN.length() > 10)
                    {
                        Book_Parse_Object.isbn13 = ISBN;
                    }
            else 
                    {
                        Book_Parse_Object.isbn10 = ISBN;
                    }
        };
    
    void setPublisher(String publisher)
        {
            publisher = publisher.replaceAll(REPLACEMENT_FLAGS, "");
            publisher = publisher.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.publisher = publisher;
        };
    
    void setPublicationDate(String publicationDate)
        {
            publicationDate = publicationDate.replaceAll(REPLACEMENT_FLAGS, "");
            publicationDate = publicationDate.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, "'");
            Book_Parse_Object.publicationDate = publicationDate;
        };
    
    void setPageCount(int pageCount)
        {
            Book_Parse_Object.pageCount = pageCount;
        };
    
}
