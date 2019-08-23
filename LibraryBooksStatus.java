/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 *
 * @author kwadwooteng-amoako
 */
public class LibraryBooksStatus {

    int id, year;
    String name, book;

    public LibraryBooksStatus(int id, String name, int year, String book) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.book = book;
    }

    
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
    
    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setBook(String book)
    {
        this.book = book; 
    }
    
    
    

    
    
    
    
}
