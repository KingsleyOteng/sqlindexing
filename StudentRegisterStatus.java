/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 * @description student register class
 * @date 5 September 2019
 * @author kwadwooteng-amoako
 */
public class StudentRegisterStatus {

    int id, year, isbn;
    String name, book, author, status;

    public StudentRegisterStatus() {
        this.id = 0;
        this.year = 0;
        this.name = "";
        this.book = "";
        this.author = "";
        this.status = "";
        this.isbn = 0;
    }
    
    public StudentRegisterStatus(int id, String name, int year, String book, String author) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.book = book;
        this.author = author;
    }

    public StudentRegisterStatus(String isbn, String name, int year, String book, String author, String status) {
        this.isbn = Integer.valueOf(isbn);
        this.book = book;
        this.author = author;
        this.status = status;
        this.year = year;
        this.name = name;
        
    }
    
    // get the user id
    public int getId() {
        return id;
    }

    // get the year information
    public int getYear() {
        return year;
    }

    // get the name information
    public String getName() {
        return name;
    }

    // get the book information
    public String getBook() {
        return book;
    }

    // get the author information
    public String getAuthor() {
        return author;
    }

    // set the id information
    public void setId(int id) {
        this.id = id;
    }

    // set the year information
    public void setYear(int year) {
        this.year = year;
    }

    // set the name information
    public void setName(String name) {
        this.name = name;
    }

    // set the book information
    public void setBook(String book) {
        this.book = book;
    }

    // set the author information
    public void setAuthor(String author) {
        this.author = author;
    }

}
