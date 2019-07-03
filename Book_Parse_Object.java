/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

/**
 *
 * @author kwadwooteng-amoako
 * @date  3 July 2019
 * @description class mainly deals with formatting the output from google
 * 
 */
public class Book_Parse_Object {
    
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
    static private String borrowDate;
    static private String returnDate;
    static private Boolean found;
    
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
            Book_Parse_Object.borrowDate = "";
            Book_Parse_Object.returnDate = "";
            Book_Parse_Object.found = false;
            
        };
    
    
    // routines to highlight whether a book has been found
    void setSearchResult(Boolean search_result)
        {
            Book_Parse_Object.found = search_result;
           
        };
    
    // routines to highlight whether a book has been found
    Boolean getSearchResult()
        {
            return Book_Parse_Object.found;
        };
    
   // routines to update the object used for update the database
    void setPrintType(String printType)
        {
            printType = printType.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            printType = printType.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            Book_Parse_Object.printType = printType;
           
        };
    
    void setMainCategory(String mainCategory)
        {
            mainCategory = mainCategory.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            mainCategory = mainCategory.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            Book_Parse_Object.mainCategory = mainCategory;
        };
    
    void setLanugageDesignator(String lanugageDesignator)
        {
            lanugageDesignator = lanugageDesignator.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            lanugageDesignator = lanugageDesignator.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            Book_Parse_Object.lanugageDesignator = lanugageDesignator;
        };
    
    void setILinkURLSmallThumbNail(String linkURLSmallThumbNail)
        {
            linkURLSmallThumbNail = linkURLSmallThumbNail.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            linkURLSmallThumbNail = linkURLSmallThumbNail.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            Book_Parse_Object.linkURLSmallThumbNail = linkURLSmallThumbNail;
        };
    
    void setCategories(String categories)
        {
            categories = categories.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            categories = categories.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            categories = categories.replaceAll(REPLACEMENT_FLAG_BRACKETS, REPLACEMENT_FLAGS_VALUE_SPACE);
            categories = categories.replaceAll("\\s+", REPLACEMENT_FLAGS_VALUE_SPACE);
            Book_Parse_Object.mainCategory = categories;
        };
   
     void setILinkURLLargeThumbNail(String linkURLLargeThumbNail)
        {
            linkURLLargeThumbNail = linkURLLargeThumbNail.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            linkURLLargeThumbNail = linkURLLargeThumbNail.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            Book_Parse_Object.linkURLLargeThumbNail = linkURLLargeThumbNail;
        };
    
    void setBookTitle(String bookTitle)
        {
            bookTitle = bookTitle.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            bookTitle = bookTitle.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            Book_Parse_Object.bookTitle = bookTitle;
        };
    
    void setBookAuthors(String bookAuthors)
        {
            bookAuthors = bookAuthors.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            bookAuthors = bookAuthors.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            bookAuthors = bookAuthors.replaceAll(REPLACEMENT_FLAG_BRACKETS, REPLACEMENT_FLAGS_VALUE_SPACE);
            bookAuthors = bookAuthors.replaceAll("\\s+", REPLACEMENT_FLAGS_VALUE_SPACE);
            Book_Parse_Object.bookAuthors = bookAuthors;
        };
    
    void setISBN10(String isbn10)
        {
            isbn10 = isbn10.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            isbn10 = isbn10.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            Book_Parse_Object.isbn10 = isbn10;
        };
    
    void setISBN13(String isbn13)
        {
            isbn13 = isbn13.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            isbn13 = isbn13.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            Book_Parse_Object.isbn13 = isbn13;
        };
    
    void setIdentifier(String ISBN)
        {
            ISBN = ISBN.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            
     
            
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
            publisher = publisher.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            publisher = publisher.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            publisher = publisher.replaceAll(REPLACEMENT_FLAG_BRACKETS, REPLACEMENT_FLAGS_VALUE_SPACE);
            Book_Parse_Object.publisher = publisher;
        };
    
    void setPublicationDate(String publicationDate)
        {
            publicationDate = publicationDate.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
            publicationDate = publicationDate.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
            publicationDate = publicationDate.replaceAll(REPLACEMENT_FLAG_BRACKETS, REPLACEMENT_FLAGS_VALUE_SPACE);
            publicationDate = publicationDate.replaceAll("\\s+", REPLACEMENT_FLAGS_VALUE_SPACE);
            Book_Parse_Object.publicationDate = publicationDate;
        };

    void setPageCount(int pageCount)
        {
            Book_Parse_Object.pageCount = pageCount;
        };
    
    String getPrintType()
    {
        return Book_Parse_Object.printType;
    }
    
    String getBookBorrowDate()
    {
        return Book_Parse_Object.borrowDate;
    }
    
    String getBookDueDate()
    {
        return Book_Parse_Object.returnDate;
    }
    
    String getBookName()
    {
        return Book_Parse_Object.bookTitle;
    }
    
    String getAuthor()
    {
        return Book_Parse_Object.bookAuthors;
    }
    
    String getCategory()
    {
        return Book_Parse_Object.mainCategory;
    }
    
    String getCategoryDescription()
    {
        return Book_Parse_Object.mainCategory;
    }
    
    String getBookID()
    {
        return Book_Parse_Object.isbn10;
    }
    
    String getSqlDateBorrowed()
    {
        return Book_Parse_Object.borrowDate;
    }
    
    String getSqlDateDue()
    {
        return Book_Parse_Object.returnDate;
    }
      
    String getISBNs(int isbn_type)
    {
        return (isbn_type == 0) ? Book_Parse_Object.isbn10 : Book_Parse_Object.isbn10 ;
    }
            
    String getCopy()
    {
        return "Single";
    }
                
    String getLocation()
    {
        return Book_Parse_Object.lanugageDesignator;
    }
}
