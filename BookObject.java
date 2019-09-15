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

    private int id, student_year;
    private String student_name, book_name, author, status, isbn1, year, filePath, description;
    private static String library;

    BookObject() {
        id = 0;
        student_name = "";
        student_year = 0;
        book_name = "";
        author = "";
        library = "HIBS";
        status = "Shelved";
        description = "";
        isbn1 = "";
        year = "";
        filePath = "";
    }

    BookObject(int id, String student_name, int student_year, String book_name, String author, String status, String isbn1, String year, String filePath, String description) {
        this.id = id;
        this.student_name = student_name;
        this.student_year = student_year;
        this.book_name = book_name;
        this.author = author;
        this.status = status;
        this.isbn1 = isbn1;
        this.year = year;
        this.filePath = filePath;
        this.description = description;
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
    
    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_year(int student_year) {
        this.student_year = student_year;
    }

    public void setBook(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(Boolean status) {
        if (status == true) {
            this.status = "Borrowed";
        } else {
            this.status = "Shelved";
        }
    }

    public void setISBN1(String isbn1) {
        this.isbn1 = isbn1;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getId() {
        return id;
    }
    
    public String getDescription()
    {
        return description;
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_year() {
        return student_year;
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
    
    public String getFilePath() {
        return filePath;
    }
    
    public String getYear() {
        return year;
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
