/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 * @description the following is a class to hold objects of type 'book'
 * @author kwadwooteng-amoako
 * @date 24th of August, 2019
 */
public class BookObject {

    private int id, student_year;
    private String student_name, book_name, author;
    private static String library;

    BookObject() {
        id = 0;
        student_name = "";
        student_year = 0;
        book_name = "";
        author = "";
        library = "HIBS";
    }

    BookObject(int id, String student_name, int student_year, String book_name, String author) {
        this.id = id;
        this.student_name = student_name;
        this.student_year = student_year;
        this.book_name = book_name;
        this.author = author;
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
    public int getId() {
        return id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_year() {
        return student_year;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_year(int student_year) {
        this.student_year = student_year;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
