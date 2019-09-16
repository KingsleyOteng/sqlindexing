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

    int classd, numberofbooks, id;
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

    public String getLastname() {
        return lastname;
    }

    public int getClassd() {
        return classd;
    }

    public int getNumberofbooks() {
        return numberofbooks;
    }

    public int getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

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
