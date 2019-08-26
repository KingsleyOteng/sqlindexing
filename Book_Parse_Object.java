/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookWareHousing;

/**
 *
 * @author kwadwooteng-amoako
 * @date 23 August 2019
 * @description class mainly deals with formatting the output from google
 *
 */
public class Book_Parse_Object {

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
    static private String borrowDate;
    static private String urlidentifier;
    static private String returnDate;
    static private Boolean found;

    // initializer
    Book_Parse_Object() {
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

    }

    ;
    
    
    // the method sets the books return date
    void setBookBorrowDate(String date) {
        Book_Parse_Object.borrowDate = date;
    }

    // the method sets the books due date
    void setBookDueDate(String date) {
        Book_Parse_Object.returnDate = date;
    }

    // routines to highlight whether a book has been found
    void setSearchResult(Boolean search_result) {
        Book_Parse_Object.found = search_result;

    }

    ;
    
    // routines to highlight whether a book has been found
    Boolean getSearchResult() {
        return Book_Parse_Object.found;
    }

    ;

   // routines to update the object used for update the database
    void setPrintType(String printType) {
        printType = printType.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        printType = printType.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        Book_Parse_Object.printType = printType;

    }

    ;
    
    // the method sets the books category flag - perhaps this might be backed out from the ISBN number later
    void setMainCategory(String mainCategory) {
        mainCategory = mainCategory.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        mainCategory = mainCategory.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        Book_Parse_Object.mainCategory = mainCategory;
    }

    ;
    
    // sets the books language flag
    void setLanugageDesignator(String lanugageDesignator) {
        lanugageDesignator = lanugageDesignator.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        lanugageDesignator = lanugageDesignator.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        Book_Parse_Object.lanugageDesignator = lanugageDesignator;
    }

    ;
    
    // sets a link to the URL of the book
    void setILinkURLSmallThumbNail(String linkURLSmallThumbNail) {
        linkURLSmallThumbNail = linkURLSmallThumbNail.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        linkURLSmallThumbNail = linkURLSmallThumbNail.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        Book_Parse_Object.linkURLSmallThumbNail = linkURLSmallThumbNail;
    }

    ;
    
    // sets a field for the book categorisation
    void setCategories(String categories) {
        categories = categories.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        categories = categories.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        categories = categories.replaceAll(REPLACEMENT_FLAG_BRACKETS, REPLACEMENT_FLAGS_VALUE_SPACE);
        categories = categories.replaceAll("\\s+", REPLACEMENT_FLAGS_VALUE_SPACE);
        Book_Parse_Object.mainCategory = categories;
    }

    ;
   
     // sets a link to the URL of the book - a large image
    void setILinkURLLargeThumbNail(String linkURLLargeThumbNail) {
        linkURLLargeThumbNail = linkURLLargeThumbNail.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        linkURLLargeThumbNail = linkURLLargeThumbNail.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        Book_Parse_Object.linkURLLargeThumbNail = linkURLLargeThumbNail;
    }

    ;
    
    // sets the books title
    void setBookTitle(String bookTitle) {
        bookTitle = bookTitle.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        bookTitle = bookTitle.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        Book_Parse_Object.bookTitle = bookTitle;
    }

    ;
    
    // sets the books author flag
    void setBookAuthors(String bookAuthors) {
        bookAuthors = bookAuthors.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        bookAuthors = bookAuthors.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        bookAuthors = bookAuthors.replaceAll(REPLACEMENT_FLAG_BRACKETS, REPLACEMENT_FLAGS_VALUE_SPACE);
        bookAuthors = bookAuthors.replaceAll("\\s+", REPLACEMENT_FLAGS_VALUE_SPACE);
        Book_Parse_Object.bookAuthors = bookAuthors;
    }

    ;

    // sets the ISBN flag identifier - ISBN 10 format
    void setISBN10(String isbn10) {
        isbn10 = isbn10.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        isbn10 = isbn10.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        Book_Parse_Object.isbn10 = isbn10;
    }

    ;

      // sets the ISBN flag identifier - ISBN 13 format
    void setISBN13(String isbn13) {
        isbn13 = isbn13.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        isbn13 = isbn13.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        Book_Parse_Object.isbn13 = isbn13;
    }

    ;

    
    // filters through and determines which ISBN format to store
    void setIdentifier(String ISBN) {
        ISBN = ISBN.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);

        if (ISBN.length() > 10) {
            Book_Parse_Object.isbn13 = ISBN;
        } else {
            Book_Parse_Object.isbn10 = ISBN;
        }
    }

    ;

    // sets the books publisher flag
    void setPublisher(String publisher) {
        publisher = publisher.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        publisher = publisher.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        publisher = publisher.replaceAll(REPLACEMENT_FLAG_BRACKETS, REPLACEMENT_FLAGS_VALUE_SPACE);
        Book_Parse_Object.publisher = publisher;
    }

    ;
    
    // sets the books publication date
    void setPublicationDate(String publicationDate) {
        publicationDate = publicationDate.replaceAll(REPLACEMENT_FLAGS, REPLACEMENT_FLAGS_VALUE_SPACE);
        publicationDate = publicationDate.replaceAll(REPLACEMENT_FLAG_SINGLE_COMMA, REPLACEMENT_FLAG_SINGLE_COMMA_VALUE);
        publicationDate = publicationDate.replaceAll(REPLACEMENT_FLAG_BRACKETS, REPLACEMENT_FLAGS_VALUE_SPACE);
        publicationDate = publicationDate.replaceAll("\\s+", REPLACEMENT_FLAGS_VALUE_SPACE);
        Book_Parse_Object.publicationDate = publicationDate;
    }

    ;

    // sets the books page count flag
    void setPageCount(int pageCount) {
        Book_Parse_Object.pageCount = pageCount;
    }

    ;
    
    // ----- this identifier needs likely to be replaced
    void setThumbNailIndentifier(String URLidentifier) {
        Book_Parse_Object.urlidentifier = URLidentifier;
    }

    ;
    
    // get the books media type
    String getPrintType() {
        return Book_Parse_Object.printType;
    }

    // obtain information on when the book was lent out
    String getBookBorrowDate() {
        return Book_Parse_Object.borrowDate;
    }

    // obtain information detailing when the book is due back
    String getBookDueDate() {
        return Book_Parse_Object.returnDate;
    }

    // obtain information related to the books name
    String getBookName() {
        return Book_Parse_Object.bookTitle;
    }

    // obtain the books author
    String getAuthor() {
        return Book_Parse_Object.bookAuthors;
    }

    // obtain the categorisation of the book
    String getCategory() {
        return Book_Parse_Object.mainCategory;
    }

    // obtain a description of the categorisation of the book
    String getCategoryDescription() {
        return Book_Parse_Object.mainCategory;
    }

    // obtain the book identification
    String getBookID() {
        return Book_Parse_Object.isbn10;
    }

    // ----- likely needs to be deleted, double up
    String getSqlDateBorrowed() {
        return Book_Parse_Object.borrowDate;
    }

    // ----- likely needs to be deleted, double up
    String getSqlDateDue() {
        return Book_Parse_Object.returnDate;
    }

    // obtain the books isbn number
    String getISBNs(int isbn_type) {
        return (isbn_type == 0) ? Book_Parse_Object.isbn10 : Book_Parse_Object.isbn10;
    }

    // obtain the url which points to the books image
    String getThumbNailIndentifier() {
        return Book_Parse_Object.urlidentifier;
    }

    ;
     
    // obtain information detailing the version of the book
    int getCopy() {
        return 1;
    }

    // obtain information detailing where the book is typically held
    String getLocation() {
        return Book_Parse_Object.lanugageDesignator;
    }
}
