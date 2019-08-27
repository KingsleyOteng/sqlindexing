/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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

    @FXML
    // note togglegroup and togglebuttons must be defined in controller class
    private ToggleButton button_title, button_author, button_isbn, register_surnames, register_firstnames, register_ids;

    
    //@FXML
    // note togglegroup and togglebuttons must be defined in controller class
    //private ToggleButton b2;
            //register_firstname, register_lastname, register_studentidnumber;

    @FXML
    // note togglegroup and togglebuttons must be defined in controller class
    private final ToggleGroup toggleGroup = new ToggleGroup();
    
    @FXML
    // note togglegroup and togglebuttons must be defined in controller class
    private final ToggleGroup toggleGroupStudentRegister = new ToggleGroup();

    private TextField borrow_author;
    
    @FXML 
    private TextField fxsearchtab_search = new TextField();
    
    @FXML 
    private TextField studentsearchquery = new TextField();

    @FXML
    private TableView<LibraryBooksStatus> employee, employee1, employee2;

    @FXML
    private TableColumn<LibraryBooksStatus, String> name, book, author, name1, book1, status;

    @FXML
    private TableColumn<LibraryBooksStatus, Integer> id, year;

    public FXMLDocumentController() {
        //this.toggleGroup = new ToggleGroup();

    }

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
        employee.setPlaceholder(new Label("Search books"));
        employee1.setPlaceholder(new Label("Search books"));
        employee2.setPlaceholder(new Label("Search students"));
        
        employee.getItems().add(new LibraryBooksStatus(1, "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee"));
        employee.getItems().add(new LibraryBooksStatus(2, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte"));
        employee.getItems().add(new LibraryBooksStatus(1, "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee"));
        employee.getItems().add(new LibraryBooksStatus(2, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte"));
        
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));

        //create a togglegroup for all three buttons; i.e. only one may be depressed at a time
        button_title.setToggleGroup(toggleGroup);
        button_title.setUserData("title");
        button_author.setToggleGroup(toggleGroup);
        button_author.setUserData("author");
        button_isbn.setToggleGroup(toggleGroup);
        button_isbn.setUserData("isbn");
        
        //create a togglegroup for all three buttons; i.e. only one may be depressed at a time
        register_firstnames.setToggleGroup(toggleGroupStudentRegister);
        register_firstnames.setUserData("firstname");
        register_surnames.setToggleGroup(toggleGroupStudentRegister);
        register_surnames.setUserData("lastname");
        register_ids.setToggleGroup(toggleGroupStudentRegister);
        register_ids.setUserData("studentnumber");
        
        //System.out.println(toggleGroup.getSelectedToggle());

    }

    @FXML
    private void borrowpage_button(ActionEvent event) throws MalformedURLException, IOException, SQLException {
        System.out.println("You clicked me again!");
        //BookObject buch = new BookObject();
        //buch.setId(10);
        //buch.setAuthor("God");
        //buch.setBook_name("The Holy Bible");
        //buch.setStudent_name("Christians");
        //buch.setStudent_year(200);

        BookObject[] bucher = new BookObject[1000];
        JDBC_Controller socket = new JDBC_Controller();
        bucher = socket.jdbc_find_book(bucher);

        //bucher[0] = new BookObject();
        //bucher[1] = new BookObject();
        //new BookObject(10, "kwadwo", 2019, "The Holy Bible", "Christians");
        //bucher[1] = new BookObject(11, "kojo", 2019, "Book of Mormon", "Mormons");
        //bucher[0] = new BookObject(10, "kwadwo", 2019, "The Holy Bible", "Christians");
        //BookObject buch = new BookObject(10, "kwadwo", 2019, "The Holy Bible", "Christians");
        this.insert_book_entry(bucher);

    }

    @FXML
    private void searchpage_query(ActionEvent event) throws MalformedURLException, IOException, SQLException {
        System.out.println("You student search me again!");
        //BookObject buch = new BookObject();
        //buch.setId(10);
        //buch.setAuthor("God");
        //buch.setBook_name("The Holy Bible");
        //buch.setStudent_name("Christians");
        //buch.setStudent_year(200);
        
        String btnDepressedId = new String();
        String searchQuery = new String();
        System.out.println("-->");
        
        btnDepressedId= toggleGroupStudentRegister.getSelectedToggle().getUserData().toString();
        searchQuery = studentsearchquery.getText();
        System.out.println("-->"+btnDepressedId+searchQuery+" ");
        
        System.out.println("fx"+fxsearchtab_search.getText());
        System.out.println("ss"+studentsearchquery.getText());
        
        
        PupilObject[] kinder = new PupilObject[1000];
        JDBC_Controller socket = new JDBC_Controller();
        
        kinder = socket.jdbc_find_student(kinder, toggleGroupStudentRegister.getSelectedToggle().getUserData().toString(), studentsearchquery.getText());

        //bucher[0] = new BookObject();
        //bucher[1] = new BookObject();
        //new BookObject(10, "kwadwo", 2019, "The Holy Bible", "Christians");
        //bucher[1] = new BookObject(11, "kojo", 2019, "Book of Mormon", "Mormons");
        //bucher[0] = new BookObject(10, "kwadwo", 2019, "The Holy Bible", "Christians");
        //BookObject buch = new BookObject(10, "kwadwo", 2019, "The Holy Bible", "Christians");
        this.insert_students_entry(kinder);

    }

// ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 24 August 2019
     * @description following method takes a book object and inserts it into
     * table view
     *
     */
    @FXML
    private void insert_book_entry(BookObject bucher) {
        // output to tableview
        employee.getItems().add(new LibraryBooksStatus(bucher.getId(), bucher.getStudent_name(), bucher.getStudent_year(), bucher.getBook_name(), bucher.getAuthor()));

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 24 August 2019
     * @description inserts an array into the table view
     *
     */
    @FXML
    private void insert_book_entry(BookObject bucher[]) {
        // output the contents of the entire array
        for (int i = 0; i <= (bucher.length); ++i) {
            // exit when we reach the end of the array
            if (bucher[i] == null) {
                break;
            }

            // output to tableview
            employee.getItems().add(new LibraryBooksStatus(bucher[i].getId(), bucher[i].getStudent_name(), bucher[i].getStudent_year(), bucher[i].getBook_name(), bucher[i].getAuthor()));
        }
    }
    
    @FXML
    private void insert_students_entry(PupilObject kinder[]) {
        // output the contents of the entire array
        for (int i = 0; i <= (kinder.length); ++i) {
            // exit when we reach the end of the array
            if (kinder[i] == null) {
                break;
            }

            // output to tableview
            employee2.getItems().add(new LibraryBooksStatus(1, kinder[i].getLastname(), 2, kinder[i].getBookid(), ""));
        }
    }

    private void search_pane_query() {
        String btnDepressedId = new String();
        String searchQuery = new String();
        
        btnDepressedId= toggleGroup.getSelectedToggle().getUserData().toString();
        searchQuery = fxsearchtab_search.getText();
    }
    
    /**
     *
     * @author kwadwooteng-amoako
     * @date 26 August 2019
     * @description will return the button in the toggle key depressed; if we combine that with a search to sql we may dynamically display names
     *
     */
    @FXML
    private void toggle_group_action()
    {    
          String btnDepressedId = toggleGroup.getSelectedToggle().getUserData().toString();
          System.out.println(btnDepressedId);
    };

    private void print_hello() {
        System.out.println("hello people");
    }

}
