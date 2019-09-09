/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 * @description searchbar status class
 * @date 5 September 2019
 * @author kwadwooteng-amoako
 */
public class SearchBarBookStatus {

    String book, author, status, isbn1;

    public SearchBarBookStatus(String book, String author, String status) {
        this.book = book;
        this.author = author;
        this.status = status;
    
  
    }
    
    public SearchBarBookStatus(String book, String author, String status, String isbn1) {
        this.book = book;
        this.author = author;
        this.status = status;
        this.isbn1 = isbn1;
  
    }

    public String getBook() {
        return book;
    }

    public String getAuthor() {
        return author;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getIsbn1() {
        return isbn1;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setIsbn1(String isbn1) {
        this.isbn1 = isbn1;
    }

}
