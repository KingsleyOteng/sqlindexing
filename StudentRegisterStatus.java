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

    public int getYear() {
        return year;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
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

}
