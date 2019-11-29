/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.util.Objects;

/**
 * @description searchbar status class
 * @date 5 September 2019
 * @author kwadwooteng-amoako
 */
public class SearchBarBookStatus {

    // variables
    String book, author, status, isbn1;

    // initialization
    public SearchBarBookStatus(String book, String author, String status) {
        this.book = book;
        this.author = author;
        this.status = status;

    }

    // initialization
    public SearchBarBookStatus(String book, String author, String status, String isbn1) {
        this.book = book;
        this.author = author;
        this.status = status;
        this.isbn1 = isbn1;

    }

    // get the book name
    public String getBook() {
        return book;
    }

    public String getAuthor() {
        return author;
    }

    
    // get the book status
    public String getStatus() {
        return status;
    }

    
    // get the books isbn
    public String getIsbn1() {
        return isbn1;
    }

    // set the books status
    public void setStatus(String status) {
        this.status = status;
    }

    // set the book name
    public void setBook(String book) {
        this.book = book;
    }

    // set the authors name
    public void setAuthor(String author) {
        this.author = author;
    }

    // set the isbn number
    public void setIsbn1(String isbn1) {
        this.isbn1 = isbn1;
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
        final SearchBarBookStatus other = (SearchBarBookStatus) obj;
        if (!Objects.equals(this.book, other.book)) {
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
        return true;
    }
    
    

}
