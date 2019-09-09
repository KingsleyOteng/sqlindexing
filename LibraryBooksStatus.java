/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 * @description library object class
 * @date 5 September 2019
 * @author kwadwooteng-amoako
 */
public class LibraryBooksStatus {

    int id, year;
    String name, book, author, status, isbn1;

    public LibraryBooksStatus(int id, String name, int year, String book, String author) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.book = book;
        this.author = author;
    }

    public LibraryBooksStatus(String book, String author, String status) {
        this.book = book;
        this.author = author;
        this.status = status;
    }

    public LibraryBooksStatus(String book, String author, String status, String isbn) {
        this.book = book;
        this.author = author;
        this.status = status;
        this.isbn1 = isbn;
    }
    
    public String getISBN1()
    {
        return isbn1;
        
    }
    
    public int getYear() 
    {
        return year;
    }
    
    public String getBOOK()
    {
        return book;
    }
    
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

    public void setId(int id) {
        this.id = id;
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
    
    public void setISBN1(String isbn1) {
        this.isbn1 = isbn1;
    }
    
    public void setYear(int year) {
        this.year = year;
    }


}
