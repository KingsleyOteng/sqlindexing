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

    // field to get the students lastname
    public String getLastname() {
        return lastname;
    }

    // field to get the studnets class
    public int getClassd() {
        return classd;
    }

    // field to get number of books borrowed. 
    public int getNumberofbooks() {
        return numberofbooks;
    }

    // field to get the students id number
    public int getId() {
        return id;
    }

    // field to get the corresponding ISBN number of the book borrowed. 
    public int getISBN() {
        return isbn;
    } 
    
    // field to get the school that the student attends
    public String getSchool() {
        return school;
    }

    // field to get the book id of the book borrowed. 
    public String getBookid() {
        return bookid;
    }

    
    // field to store the book id of the book borrowed. 
    public String getFirstname() {
        return firstname;
    }

    // field to store the borrow date
    public String getDate() {
        return date;
    }
    
    // fields to get the time stamp
    public String getTimestamp() {
        return timestamp;
    }

    // field to set the students name
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // field to set the students class
    public void setClassd(int classd) {
        this.classd = classd;
    }

    // fiel to set the number of books
    public void setNumberofbooks(int numberofbooks) {
        this.numberofbooks = numberofbooks;
    }

    // filed to set the students id
    public void setId(int id) {
        this.id = id;
    }

    // set the school parameter
    public void setSchool(String school) {
        this.school = school;
    }

    // set the book id parameter
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    // set the firstname parameter
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // set the date parameter
    public void setDate(String date) {
        this.date = date;
    }

    // set the timestamp parameter
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


}
