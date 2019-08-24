/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author kwadwooteng-amoako
 * @date 10 August 2019
 * @description Controller for the FXML
 *
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Button button1;
    private TextField borrow_author;

    @FXML
    private TableView<LibraryBooksStatus> employee;

    @FXML
    private TableColumn<LibraryBooksStatus, String> name, book, author;

    @FXML
    private TableColumn<LibraryBooksStatus, Integer> id, year;

    @FXML
    private void handleButtonAction(ActionEvent event, String Hello) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");

        borrow_author.setPromptText("what");
        System.out.println();
        button1.setText("Hello");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employee.getItems().add(new LibraryBooksStatus(1, "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee"));
        employee.getItems().add(new LibraryBooksStatus(2, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte"));
        employee.getItems().add(new LibraryBooksStatus(1, "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee"));
        employee.getItems().add(new LibraryBooksStatus(2, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte"));
        
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
    }

    @FXML
    private void borrowpage_button(ActionEvent event) {
        System.out.println("You clicked me again!");
        //BookObject buch = new BookObject();
        //buch.setId(10);
        //buch.setAuthor("God");
        //buch.setBook_name("The Holy Bible");
        //buch.setStudent_name("Christians");
        //buch.setStudent_year(200);
        
        BookObject buch = new BookObject(10, "kwadwo", 2019, "The Holy Bible", "Christians");
        this.insert_book_entry(buch);
        //label.setText("Hello World!");
        // fx_borrowpage_author.setText("author");
        //fx_borrowpage_title.setText("title");
        //fx_borrowpage_published.setText("published")
        // System.out.println(fx_borrowpage_overview.getText());
    }
    
    
    
    /**
    *
    * @author kwadwooteng-amoako
    * @date 24 August 2019
    * @description following method takes a book object and inserts it into table view
    *
    */
    @FXML
    private void insert_book_entry(BookObject bucher)
    {
      employee.getItems().add(new LibraryBooksStatus(bucher.getId(),bucher.getStudent_name(),bucher.getStudent_year(),bucher.getBook_name(),bucher.getAuthor()));
    
  
    
   
    }
}
