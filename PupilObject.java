/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.util.Objects;

/**
 * @description pupil object class
 * @date 5 September 2019
 * @author kwadwooteng-amoako
 */
public class PupilObject {

    private int numberofbooksborrowed, date, timestamp;
    private String lastname, firstname, classwhenrecordcreated, borrowerid, school, bookid;
    private static String library;

    // pupil object constructor
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

    // method to initiate the pupil object
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

    // get information related to the number of books
    public int getNumberofbooksborrowed() {
        return numberofbooksborrowed;
    }

    // get information related to the date
    public int getDate() {
        return date;
    }

    // get the timestamp information
    public int getTimestamp() {
        return timestamp;
    }

    // get the lastname information
    public String getLastname() {
        return lastname;
    }

    // get the firstname information
    public String getFirstname() {
        return firstname;
    }

    // get the class when the record was created information
    public String getClasswhenrecordcreated() {
        return classwhenrecordcreated;
    }

    // get the borrower id information
    public String getBorrowerid() {
        return borrowerid;
    }

    // get the school infrmation
    public String getSchool() {
        return school;
    }

    // get the book id information
    public String getBookid() {
        return bookid;
    }

    // get the library information
    public static String getLibrary() {
        return library;
    }

    // set the number of books read
    public void setNumberofbooksborrowed(int numberofbooksborrowed) {
        this.numberofbooksborrowed = numberofbooksborrowed;
    }

    // set the current date
    public void setDate(int date) {
        this.date = date;
    }

    // get the timestamp information
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    // set the lastname information
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    // set the first name
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // set the class field - for when the record was created
    public void setClasswhenrecordcreated(String classwhenrecordcreated) {
        this.classwhenrecordcreated = classwhenrecordcreated;
    }

    // set the borrower id
    public void setBorrowerid(String borrowerid) {
        this.borrowerid = borrowerid;
    }

    // set the schcool information
    public void setSchool(String school) {
        this.school = school;
    }

    // set the book id information
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    // set the designated library information
    public static void setLibrary(String library) {
        PupilObject.library = library;
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
        final PupilObject other = (PupilObject) obj;
        if (this.numberofbooksborrowed != other.numberofbooksborrowed) {
            return false;
        }
        if (this.date != other.date) {
            return false;
        }
        if (this.timestamp != other.timestamp) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.classwhenrecordcreated, other.classwhenrecordcreated)) {
            return false;
        }
        if (!Objects.equals(this.borrowerid, other.borrowerid)) {
            return false;
        }
        if (!Objects.equals(this.school, other.school)) {
            return false;
        }
        if (!Objects.equals(this.bookid, other.bookid)) {
            return false;
        }
        return true;
    }

}
