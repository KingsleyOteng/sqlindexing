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
    String name, book, author, status, student_year, filex, ISBN1, categories, description;

    public LibraryBooksStatus(String ISBN1, int year, String name,  String book, String author, String status, String filex, String category, String description) {
        this.ISBN1 = ISBN1;
        this.year = year;
        this.name = name;
        this.book = book;
        this.author = author;
        this.status = status;
        this.filex = filex;
        this.categories = category;
        this.description = description;
    }

    public LibraryBooksStatus(String ISBN1, String name, int year, String book, String author, String status) {
        this.ISBN1 = ISBN1;
        this.year = year;
        this.name = name;
        this.book = book;
        this.author = author;
        this.status = status;
    }

    public LibraryBooksStatus(String book, String author, String status, String ISBN1) {
        this.book = book;
        this.author = author;
        this.status = status;
        this.ISBN1 = ISBN1;
    }

    public LibraryBooksStatus(String book, String author, String status, String ISBN1, String student_year) {
        this.book = book;
        this.author = author;
        this.status = status;
        this.student_year = student_year;
    }

    public LibraryBooksStatus(String book, String author, String status) {
        this.book = book;
        this.author = author;
        this.status = status;
    }

    public String getISBN1() {
        return ISBN1;

    }

    public String getFILE() {
        return filex;

    }

    public int getYear() {
        return year;
    }

    public String getBOOK() {
        return book;
    }

    public String getISBN() {
        return ISBN1;
    }

    public int getPublishedYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }

    ;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBook() {
        return book;
    }

    public String getAuthor() {
        return author;
    }
    
    public String getCategories() {
        return categories;
    }
     
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setISBN1(String ISBN1) {
        this.ISBN1 = ISBN1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFile(String file) {
        this.filex = file;
    }

    public String getIsbn1() {
        return ISBN1;
    }

    public String getStudent_year() {
        return student_year;
    }

    public void setIsbn1(String ISBN1) {
        this.ISBN1 = ISBN1;
    }

    public void setStudent_year(String student_year) {
        this.student_year = student_year;
    }
    
    public void setCategories(String categories) {
        this.categories = categories;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
