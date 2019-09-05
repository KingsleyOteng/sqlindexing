/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 * @description pupil object class
 * @date 5 September 2019
 * @author kwadwooteng-amoako
 */
public class PupilObject {

    private int numberofbooksborrowed, date, timestamp;
    private String lastname, firstname, classwhenrecordcreated, borrowerid, school, bookid;
    private static String library;

    PupilObject() {
        numberofbooksborrowed = 0;
        date = 0;
        timestamp = 0;
        lastname = "";
        firstname = "";
        classwhenrecordcreated = "";
        borrowerid = "";
        bookid = "";
        school = "";
    }

    public PupilObject(int numberofbooksborrowed, int date, int timestamp, String lastname, String firstname, String classwhenrecordcreated, String borrowerid, String school, String bookid) {
        this.numberofbooksborrowed = numberofbooksborrowed;
        this.date = date;
        this.timestamp = timestamp;
        this.lastname = lastname;
        this.firstname = firstname;
        this.classwhenrecordcreated = classwhenrecordcreated;
        this.borrowerid = borrowerid;
        this.school = school;
        this.bookid = bookid;
    }

    public int getNumberofbooksborrowed() {
        return numberofbooksborrowed;
    }

    public int getDate() {
        return date;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getClasswhenrecordcreated() {
        return classwhenrecordcreated;
    }

    public String getBorrowerid() {
        return borrowerid;
    }

    public String getSchool() {
        return school;
    }

    public String getBookid() {
        return bookid;
    }

    public static String getLibrary() {
        return library;
    }

    public void setNumberofbooksborrowed(int numberofbooksborrowed) {
        this.numberofbooksborrowed = numberofbooksborrowed;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setClasswhenrecordcreated(String classwhenrecordcreated) {
        this.classwhenrecordcreated = classwhenrecordcreated;
    }

    public void setBorrowerid(String borrowerid) {
        this.borrowerid = borrowerid;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public static void setLibrary(String library) {
        PupilObject.library = library;
    }

}
