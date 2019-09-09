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
    String name, book, author, status, isbn1, student_year;

    public LibraryBooksStatus(int id, String name, int year, String book, String author) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.book = book;
        this.author = author;
    }

    public LibraryBooksStatus(String book, String author, String status, String isbn1) {
        this.book = book;
        this.author = author;
        this.status = status;
        this.isbn1 = isbn1;
    }

    public LibraryBooksStatus(String book, String author, String status, String isbn1, String student_year) {
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
        return isbn1;

    }

    public int getYear() {
        return year;
    }

    public String getBOOK() {
        return book;
    }

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setISBN1(String isbn1) {
        this.isbn1 = isbn1;
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

    public String getIsbn1() {
        return isbn1;
    }

    public String getStudent_year() {
        return student_year;
    }

    public void setIsbn1(String isbn1) {
        this.isbn1 = isbn1;
    }

    public void setStudent_year(String student_year) {
        this.student_year = student_year;
    }

}
