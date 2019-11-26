/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.util.Objects;

/**
 * @description library object class
 * @date 5 September 2019
 * @author kwadwooteng-amoako
 */
public class LibraryBooksStatus {

    //boolean status;
    int id, year;
    String name, book, author, status, student_year, filex, ISBN1, categories, description, thumbnailidentifier;

    /**
     * @description construct a library object
     * @date 14 November 2019
     * @author kwadwooteng-amoako
     * @parameters 10 parameters
     */
    public LibraryBooksStatus(String ISBN1, int year, String name, String book, String author, String status, String filex, String category, String description, String thumbnailidentifier) {
        this.ISBN1 = ISBN1;
        this.year = year;
        this.name = name;
        this.book = book;
        this.author = author;
        this.status = status;
        this.filex = filex;
        this.categories = category;
        this.description = description;
        this.thumbnailidentifier = thumbnailidentifier;
    }

    /**
     * @description construct a library object
     * @date 14 November 2019
     * @author kwadwooteng-amoako
     * @parameters 6 parameters
     */
    public LibraryBooksStatus(String ISBN1, String name, int year, String book, String author, String status) {
        this.ISBN1 = ISBN1;
        this.year = year;
        this.name = name;
        this.book = book;
        this.author = author;
        this.status = status;
    }

    /**
     * @param book
     * @param author
     * @description construct a library object
     * @date 14 November 2019
     * @author kwadwooteng-amoako
     * @parameters 4 parameters
     */
    public LibraryBooksStatus(String book, String author, String status, String ISBN1) {
        this.book = book;
        this.author = author;
        this.status = status;
        this.ISBN1 = ISBN1;
    }

    /**
     * @description construct a library object
     * @date 14 November 2019
     * @author kwadwooteng-amoako
     * @parameters 5 parameters
     */
    public LibraryBooksStatus(String book, String author, String status, String ISBN1, String student_year) {
        this.book = book;
        this.author = author;
        this.status = status;
        this.student_year = student_year;
    }

    /**
     * @description construct a library object
     * @date 14 November 2019
     * @author kwadwooteng-amoako
     * @parameters 3 parameters
     */
    public LibraryBooksStatus(String book, String author, String status) {
        this.book = book;
        this.author = author;
        this.status = status;
    }

    // get the ISBN details
    public String getISBN1() {
        return ISBN1;

    }

    // get the file details
    public String getFILE() {
        return filex;

    }
    
    // get the year details
    public int getYear() {
        return year;
    }

    // get the book details
    public String getBOOK() {
        return book;
    }

    // get the ISBN details
    public String getISBN() {
        return ISBN1;
    }

    // get the published year details
    public int getPublishedYear() {
        return year;
    }

    // get the status details
    public String getStatus() {
        return status;
    }

    ;

    // get the book id
    public int getId() {
        return id;
    }

    // get the name details
    public String getName() {
        return name;
    }

    // get the book details
    public String getBook() {
        return book;
    }

    // get the author details
    public String getAuthor() {
        return author;
    }

    // get the category details
    public String getCategories() {
        return categories;
    }

    // get the book description details
    public String getDescription() {
        return description;
    }

    // get the thumbnail identifier details
    public String getThumbNailIdentifier() {
        return this.thumbnailidentifier;
    }

    // set the id 
    public void setId(int id) {
        this.id = id;
    }

    // set the status 
    public void setStatus(String status) {
        this.status = status;
    }

    // set the first ISBN number
    public void setISBN1(String ISBN1) {
        this.ISBN1 = ISBN1;
    }

    // set the name of the borrower
    public void setName(String name) {
        this.name = name;
    }

    // set the book title
    public void setBook(String book) {
        this.book = book;
    }

    // set the author details
    public void setAuthor(String author) {
        this.author = author;
    }

    // set the year
    public void setYear(int year) {
        this.year = year;
    }

    // set the file details
    public void setFile(String file) {
        this.filex = file;
    }

    // get the isbn details
    public String getIsbn1() {
        return ISBN1;
    }

    // get the student year
    public String getStudent_year() {
        return student_year;
    }

    // set the isbn1 number
    public void setIsbn1(String ISBN1) {
        this.ISBN1 = ISBN1;
    }

    // set the student and year details
    public void setStudent_year(String student_year) {
        this.student_year = student_year;
    }

    // set the categorisation
    public void setCategories(String categories) {
        this.categories = categories;
    }
    
    // set the descriptor details
    public void setDescription(String description) {
        this.description = description;
    }

    // set the thumbnail identifier
    public void setThumbNailIdentifier(String thumbnailidentifier) {
        this.thumbnailidentifier = thumbnailidentifier;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final LibraryBooksStatus other = (LibraryBooksStatus) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.ISBN1, other.ISBN1)) {
            return false;
        }
        if (!Objects.equals(this.student_year, other.student_year)) {
            return false;
        }
        return true;
    }

}
