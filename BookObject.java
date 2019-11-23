/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.util.Objects;

/**
 * @description the following is a class to hold objects of type 'book'
 * @author kwadwooteng-amoako
 * @date 24th of August, 2019
 */
public class BookObject {

    private int id, student_year, pagecount, publishedyear;
    private String printtype, thumbnailIdentifier, language, identifier10, identifier, country, student_name, book_name, author, publisher, status, isbn1, isbn2, year, filePath, description, overview, categories;
    private static String library;

    BookObject() {
        pagecount = 0;
        language = "";
        country = "";
        id = 0;
        publishedyear = 0;
        categories = "";
        student_name = "";
        student_year = 0;
        book_name = "";
        author = "";
        library = "HIBS";
        status = "Shelved";
        description = "";
        isbn1 = "";
        isbn2 = "";
        year = "";
        filePath = "";
        overview = "";
        status = "";
        categories = "";
        printtype = "";
        publisher = "";
        identifier = "";
        thumbnailIdentifier = "";
    }

    BookObject(int id, String student_name, int student_year, String book_name, String author, String status, String isbn1, String year, String filePath, String description, String overview, int publishedyear, String thumbnailidentifier) {
        this.id = id;
        this.student_name = student_name;
        this.student_year = student_year;
        this.publisher = publisher;
        this.publishedyear = publishedyear;
        this.book_name = book_name;
        this.author = author;
        this.status = status;
        this.isbn1 = isbn1;
        this.year = year;
        this.filePath = filePath;
        this.description = description;
        this.overview = overview;
        this.status = status;
        this.categories = categories;
        this.thumbnailIdentifier = thumbnailIdentifier;
    }

    private static void setLibrary(String library) {
        BookObject.library = library;
    }

    private static String getLibrary() {
        return BookObject.library;
    }

    /**
     *
     * @return
     */
    public void setCategories(String categories) {
        this.categories = categories;
    }

    // set information on the book categories
    public String getCategories() {
        return this.categories;
    }

    // set information relating to an overview of the book
    public void setOverview(String overview) {
        this.overview = overview;
    }

    // set language information
    public void setLanguage(String language) {
        this.language = language;
    }

    ;
    
    // set country information
    public void setCountry(String country) {
        this.country = country;
    }

    ;
    
    // set page count information
    public void setPageCount(int pagecount) {
        this.pagecount = pagecount;
    }

    ;
    
    // set information relating to the year the book was published
     public void setPublishedYear(int publishedyear) {
        this.publishedyear = publishedyear;
    }

    ;
     
    // set the media type
    public void setPrintType(String Type) {
        this.printtype = Type;
    }

    ;
    
    // set the id number
    public void setId(int id) {
        this.id = id;
    }

    // set the ISBN identifier
    public void setIdentifier(String identifier) {
        this.identifier = identifier;

        if (identifier.length() == 10) {
            this.setISBN1(identifier);
        } else if (identifier.length() == 13) {
            this.setISBN2(identifier);
        }
    }

    // set the student name
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    // set the student year
    public void setStudent_year(int student_year) {
        this.student_year = student_year;
    }

    // set the book name
    public void setBook(String book_name) {
        this.book_name = book_name;
    }

    // set the author name
    public void setAuthor(String author) {
        this.author = author;
    }

    // set the book status
    public void setStatus(Boolean status) {
        if (status == true) {
            this.status = "Borrowed";
        } else {
            this.status = "Shelved";
        }
    }

    // set the ISBN number
    public void setISBN1(String isbn1) {
        this.isbn1 = isbn1;
    }

    // set the ISBN number format 2
    public void setISBN2(String isbn1) {
        this.isbn1 = isbn2;
    }

    // set the year that the book as published
    public void setYear(String year) {
        this.year = year;
    }

    // set the books publisher
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // provide a description of the book
    public void setDescription(String description) {
        this.description = description;
    }

    // set the filepath of the book
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // provide a link to the thumbnail identifier
    public void setThumbNailIndentifier(String thumbnailIdentifier) {
        this.thumbnailIdentifier = thumbnailIdentifier;
    }

    public int getId() {
        return id;
    }

    public int getPageCount() {
        return pagecount;
    }

    public String getOverview() {
        return overview;
    }

    public String getDescription() {
        return description;
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_year() {
        return student_year;
    }

    public int getPublishedYEar() {
        return publishedyear;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getBook() {
        return book_name;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return this.status;
    }

    public String getISBN1() {
        return isbn1;
    }

    public String getISBN2() {
        return isbn2;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getYear() {
        return year;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getThumbNailIndentifier() {
        return this.thumbnailIdentifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookObject other = (BookObject) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.student_year != other.student_year) {
            return false;
        }
        if (!Objects.equals(this.student_name, other.student_name)) {
            return false;
        }
        if (!Objects.equals(this.book_name, other.book_name)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.isbn1, other.isbn1)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.filePath, other.filePath)) {
            return false;
        }
        return true;
    }

}
