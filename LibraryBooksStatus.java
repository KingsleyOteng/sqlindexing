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

    int id, salary;
    String name;

    public LibraryBooksStatus(int id, String name, int salary) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    
    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    

    
    
    
    
}
