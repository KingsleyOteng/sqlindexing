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
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 *
 * @author kwadwooteng-amoako
 * @date  10 August 2019
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
    private TextField fx_borrowpage_author;
    
    @FXML
    private TextField fx_borrowpage_title;
    
    @FXML
    private TextField fx_borrowpage_published;
    
    @FXML
    private TextField fx_borrowpage_description;
    
    @FXML
    private TextField fx_borrowpage_isbn;
    
    @FXML
    private TextField fx_borrowpage_overview;
    
    @FXML
    private TextField fx_borrowpage_borrower;
    
    @FXML
    private TextField fx_borrowpage_school_level;
    
    @FXML
    private TextField fx_borrowpage_id;
    
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
        
    }    
    
   @FXML
    private void borrowpage_button(ActionEvent event) {
       System.out.println("You clicked me!");
       label.setText("Hello World!");
        fx_borrowpage_author.setText("author");
        fx_borrowpage_title.setText("title");
        fx_borrowpage_published.setText("published");
       
        System.out.println(fx_borrowpage_overview.getText());
    }
    
   
}
