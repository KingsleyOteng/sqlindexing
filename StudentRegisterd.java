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
public class StudentRegisterd {

    int classd, numberofbooks, id, isbn;
    String lastname, school, bookid, firstname,date,timestamp;
    
    public StudentRegisterd()
    {
        
    };

    public StudentRegisterd(String lastname, int classd, int numberofbooks, int id, String school, String bookid, String firstname, String date, String timestamp) {
        this.lastname = lastname;
        this.classd = classd;
        this.numberofbooks = numberofbooks;
        this.id = id;
        this.school = school;
        this.bookid = bookid;
        this.firstname = firstname;
        this.date = date;
        this.timestamp = timestamp;
    }

    // field to store the students lastname
    public String getLastname() {
        return lastname;
    }

    // field to store the studnets class
    public int getClassd() {
        return classd;
    }

    // field to store number of books borrowed. 
    public int getNumberofbooks() {
        return numberofbooks;
    }

    // field to stroe the students id number
    public int getId() {
        return id;
    }

    // field to store the corresponding ISBN number of the book borrowed. 
    public int getISBN() {
        return isbn;
    } 
    
    // field to store the school that the student attends
    public String getSchool() {
        return school;
    }

    // field to store the book id of the book borrowed. 
    public String getBookid() {
        return bookid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getDate() {
        return date;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setClassd(int classd) {
        this.classd = classd;
    }

    public void setNumberofbooks(int numberofbooks) {
        this.numberofbooks = numberofbooks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


}
