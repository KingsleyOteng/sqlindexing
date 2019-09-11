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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private Button go_button2;

    @FXML
    private Button returnbutton;

    @FXML
    // note togglegroup and togglebuttons must be defined in controller class
    private ToggleButton button_title, button_author, button_isbn,
            register_surnames, register_firstnames, register_ids,
            search_bks_title, search_bks_author, search_bks_isbn;

    //@FXML
    // note togglegroup and togglebuttons must be defined in controller class
    //private ToggleButton b2;
    //register_firstname, register_lastname, register_studentidnumber;
    @FXML
    // note togglegroup and togglebuttons must be defined in controller class
    private final ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    private final TabPane books_tab_pane = new TabPane();

    @FXML
    private final Tab borrows_tabs = new Tab();

    @FXML
    private final Tab search_tab = new Tab();

    @FXML
    private final Tab newsearchtext = new Tab();

    @FXML
    private final Tab studentsearchqueryss = new Tab();

    @FXML
    private final Tab teturn_tab = new Tab();

    @FXML
    // note togglegroup and togglebuttons must be defined in controller class
    private final ToggleGroup toggleGroupStudentRegister = new ToggleGroup();

    @FXML
    // note togglegroup and togglebuttons must be defined in controller class
    private final ToggleGroup toggleGroupBookSearch = new ToggleGroup();

    private TextField borrow_author;

    @FXML
    private TextField fx_borrowpage_published = new TextField();
    
    @FXML
    private TextField hello = new TextField();

    @FXML
    private TextField fx_borrowpage_description = new TextField();

    @FXML
    private TextField fx_borrowpage_isbn = new TextField();

    @FXML
    private TextField fx_borrowpage_overview = new TextField();

    @FXML
    private TextField fx_borrowpage_borrower = new TextField();

    @FXML
    private TextField fx_borrowpage_school_level = new TextField();

    @FXML
    private TextField fx_borrowpage_id = new TextField();
    
    @FXML
    private TextField fx_availability_status = new TextField();

    @FXML
    private TextField fxsearchtab_search = new TextField();

    @FXML
    private TextField newsearch2 = new TextField();

    @FXML
    private TextField onemoretime = new TextField();

    @FXML
    private TextField field = new TextField();

    @FXML
    private TextField fx_borrowpage_author = new TextField();

    @FXML
    private TextField fx_borrowpage_title = new TextField();

    @FXML
    private TableView<LibraryBooksStatus> searchTableCatalogue;

    @FXML
    private TableColumn<LibraryBooksStatus, String> book_searchbar, author_searchbar, status_searchbar, isbn_searchbar;

    @FXML
    private TableView<LibraryBooksStatus> schoolCatalogueTable;

    @FXML
    private TableColumn<LibraryBooksStatus, String> author_search, book_search, status_search, isbn_search;

    @FXML
    private TableColumn<LibraryBooksStatus, Integer> id, year;

    @FXML
    private TableColumn<LibraryBooksStatus, String> book, author, status, isbn1;

    @FXML
    private TableColumn<LibraryBooksStatus, String> name, name1, book1;

    @FXML
    private TableView<StudentRegisterStatus> table2;

    @FXML
    private TableColumn<StudentRegisterStatus, String> name_sregister, book_sregister, author_sregister;

    @FXML
    private TableColumn<StudentRegisterStatus, Integer> id_sregister, year_sregister;

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

        books_tab_pane.getTabs().addAll(search_tab, newsearchtext, studentsearchqueryss, teturn_tab, borrows_tabs);

        // listener to reset table ordering after a move; table search
        searchTableCatalogue.getColumns().addListener(new ListChangeListener() {
            public boolean suspended;
            ObservableList columns = searchTableCatalogue.getColumns();
            String x = columns.get(0).toString();

            @Override
            public void onChanged(ListChangeListener.Change change) {

                change.next();
                if (change.wasReplaced()) {
                    searchTableCatalogue.getColumns().clear();
                    searchTableCatalogue.getColumns().addAll(book_searchbar, author_searchbar, status_searchbar, isbn_searchbar);
                    searchTableCatalogue.refresh();

                }
            }

        });

        // listener to reset table ordering after a move; table search
        schoolCatalogueTable.getColumns().addListener(new ListChangeListener() {
            public boolean suspended;
            ObservableList columns = schoolCatalogueTable.getColumns();
            String x = columns.get(0).toString();

            @Override
            public void onChanged(Change change) {

                change.next();
                if (change.wasReplaced()) {
                    schoolCatalogueTable.getColumns().clear();
                    schoolCatalogueTable.getColumns().addAll(id, name, year, book, author);
                    schoolCatalogueTable.refresh();

                }
            }
        });

        // listener to reset table ordering after a move; table school catalogue
        table2.getColumns().addListener(new ListChangeListener() {
            public boolean suspended;
            ObservableList columns = schoolCatalogueTable.getColumns();
            String x = columns.get(0).toString();

            @Override
            public void onChanged(ListChangeListener.Change change) {

                change.next();
                if (change.wasReplaced()) {
                    table2.getColumns().clear();
                    table2.getColumns().addAll(id_sregister, name_sregister, year_sregister, book_sregister, author_sregister);
                    table2.refresh();

                }
            }
        });

        schoolCatalogueTable.setPlaceholder(new Label("Search books"));
        searchTableCatalogue.setPlaceholder(new Label("Search books teo"));
        table2.setPlaceholder(new Label("Search students"));

        searchTableCatalogue.getItems().add(new LibraryBooksStatus("Stepford Wives", "Ira Lee", "2013", "9784150410513"));
        searchTableCatalogue.getItems().add(new LibraryBooksStatus("Stepford Wives", "Ira    Lee", "2012", "9788401468711"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus(1, "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus(2, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus(1, "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus(2, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte"));

        //table2.getItems().add(new StudentRegisterStatus(2, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte"));
        year_sregister.setCellValueFactory(new PropertyValueFactory<>("year"));
        id_sregister.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_sregister.setCellValueFactory(new PropertyValueFactory<>("name"));
        book_sregister.setCellValueFactory(new PropertyValueFactory<>("book"));
        author_sregister.setCellValueFactory(new PropertyValueFactory<>("author"));

        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));

        book_search.setCellValueFactory(new PropertyValueFactory<>("book"));
        author_search.setCellValueFactory(new PropertyValueFactory<>("author"));
        status_search.setCellValueFactory(new PropertyValueFactory<>("status"));
        isbn_search.setCellValueFactory(new PropertyValueFactory<>("isbn1"));

        //create a togglegroup for all three buttons; i.e. only one may be depressed at a time
        //button_title.setToggleGroup(toggleGroup);
        //button_title.setUserData("title");
        //button_author.setToggleGroup(toggleGroup);
        //button_author.setUserData("author");
        //button_isbn.setToggleGroup(toggleGroup);
        //button_isbn.setUserData("isbn");
        //create a togglegroup for all three buttons; i.e. only one may be depressed at a time
        register_firstnames.setToggleGroup(toggleGroupStudentRegister);
        register_firstnames.setUserData("firstname");
        register_surnames.setToggleGroup(toggleGroupStudentRegister);
        register_surnames.setUserData("lastname");
        register_ids.setToggleGroup(toggleGroupStudentRegister);
        register_ids.setUserData("studentnumber");

        //create a togglegroup for all three buttons; i.e. only one may be depressed at a time
        search_bks_title.setToggleGroup(toggleGroupBookSearch);
        search_bks_title.setUserData("searchtitle");
        search_bks_author.setToggleGroup(toggleGroupBookSearch);
        search_bks_author.setUserData("searchauthor");
        search_bks_isbn.setToggleGroup(toggleGroupBookSearch);
        search_bks_isbn.setUserData("searchisbn");

        //System.out.println(toggleGroup.getSelectedToggle());
        //System.out.println(schoolCatalogueTable.lookupAll(".column-header").toString());
        String yy = schoolCatalogueTable.lookupAll(".column-header").toString();

    }

    @FXML
    private void borrowpage_button(ActionEvent event) throws MalformedURLException, IOException, SQLException, InterruptedException {
        System.out.println("You clicked me again!");

        BookObject[] bucher = new BookObject[1000];
        JDBC_Controller socket = new JDBC_Controller();
        bucher = socket.jdbc_find_book(bucher);

        this.insert_book_entry(bucher);
        Thread.sleep(1000);

    }

    @FXML
    private void searchpage_borrowpage_button(ActionEvent event) throws MalformedURLException, IOException, SQLException, InterruptedException {
        System.out.println("You clicked me again!");

        BookObject[] bucher = new BookObject[1000];
        JDBC_Controller socket = new JDBC_Controller();
        bucher = socket.jdbc_find_book(bucher);

        this.insert_book_entry(bucher);
        Thread.sleep(1000);

    }

    @FXML
    private void searchpage_query(ActionEvent event) throws MalformedURLException, IOException, SQLException, InterruptedException {

        String btnDepressedId;
        String searchQuery;

        btnDepressedId = toggleGroupStudentRegister.getSelectedToggle().getUserData().toString();
        searchQuery = newsearch2.getText();

        PupilObject[] kinder = new PupilObject[1000];
        JDBC_Controller socket = new JDBC_Controller();
        kinder = socket.jdbc_find_student(kinder, toggleGroupStudentRegister.getSelectedToggle().getUserData().toString(), newsearch2.getText());

        this.insert_students_entry(kinder);
        Thread.sleep(1000);

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
    private void insert_book_entry(BookObject bucher) throws InterruptedException {
        // output to tableview

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
    private void insert_book_entry_in_search_page(BookObject bucher[]) throws InterruptedException {
        // output to tableview
        for (int i = 0x0; i <= (bucher.length); ++i) {
            // exit when we reach the end of the array
            if (bucher[i] == null) {
                break;
            }

            searchTableCatalogue.getItems().add(new LibraryBooksStatus("1", "2", "3"));
        }
    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 24 August 2019
     * @description inserts an array into the table view
     *
     */
    @FXML
    private void insert_book_entry(BookObject bucher[]) throws InterruptedException {
        // output the contents of the entire array
        for (int i = 0x0; i <= (bucher.length); ++i) {
            // exit when we reach the end of the array
            if (bucher[i] == null) {
                break;
            }

            // output to tableview
            schoolCatalogueTable.getItems().add(new LibraryBooksStatus(bucher[i].getId(), bucher[i].getStudent_name(), bucher[i].getStudent_year(), bucher[i].getBook(), bucher[i].getAuthor()));
        }

    }

    @FXML
    private void insert_book_entry_searchtab(BookObject bucher[]) throws InterruptedException {
        // output the contents of the entire array
        for (int i = 0x0; i <= (bucher.length); ++i) {
            // exit when we reach the end of the array
            if (bucher[i] == null) {
                break;
            }

            // output to tableview
            searchTableCatalogue.getItems().add(
                    new LibraryBooksStatus(
                            bucher[i].getBook(),
                            bucher[i].getAuthor(),
                            bucher[i].getStatus(),
                            bucher[i].getISBN1()
                    )
            );

        }

    }

    @FXML
    private void insert_students_entry(PupilObject kinder[]) throws InterruptedException {
        // output the contents of the entire array
        //table2.getItems().add(new StudentRegisterStatus(1, "otengamoako", 2, "989898", "3"));

        for (int i = 0x0; i <= (kinder.length); ++i) {
            // exit when we reach the end of the array
            if (kinder[i] == null) {
                break;
            }

            table2.getItems().add(new StudentRegisterStatus(1, kinder[0].getLastname(), 2, "989898", "3"));
        }
        //System.out.println("run");
        //System.out.println("kinder[0].getLastname()"+kinder[0].getLastname());
        //table2.getItems().add(new StudentRegisterStatus(1, kinder[0].getLastname(), 2, "989898", "3"));

    }

    private void search_pane_query() {
        String btnDepressedId = new String();
        String searchQuery = new String();

        btnDepressedId = toggleGroup.getSelectedToggle().getUserData().toString();
        searchQuery = fxsearchtab_search.getText();
    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 5 September 2019
     * @description will return the button in the toggle key depressed; if we
     * combine that with a search to sql we may dynamically display names
     *
     */
    @FXML
    private void toggle_group_action_search() throws SQLException, IOException, InterruptedException {
        String btnDepressedId = new String();
        String searchQuery = new String();

        btnDepressedId = null;

        while (btnDepressedId == null) {
            btnDepressedId = toggleGroupBookSearch.getSelectedToggle().getUserData().toString();
            searchQuery = fxsearchtab_search.getText();
            System.out.println(btnDepressedId);
        };

        BookObject[] bucher = new BookObject[1000];
        JDBC_Controller socket = new JDBC_Controller();

        bucher = socket.jdbc_search_book(bucher, toggleGroupBookSearch.getSelectedToggle().getUserData().toString(), fxsearchtab_search.getText());
        this.insert_book_entry_searchtab(bucher);
        Thread.sleep(1000);
    }

    ;

    @FXML
    private void switch_tab() {
        books_tab_pane.getTabs().addAll(search_tab, newsearchtext, studentsearchqueryss, teturn_tab, borrows_tabs);
        System.out.println("hello hello");
        field.setText("hello");
        System.out.println(books_tab_pane.getSelectionModel().getSelectedIndex());

        //books_tab_pane.getTabs().addAll(search_tab, newsearchtext, studentsearchqueryss, teturn_tab, borrows_tabs);
        //books_tab_pane.getSelectionModel().selectNext();
        books_tab_pane.getSelectionModel().select(3);

    }

    @FXML
    private void select_search_item_return() throws SQLException, IOException {
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        BookObject buchs = new BookObject();

        buchs = this.generate_search_object(buchs, buch.getIsbn1());

        System.out.println(buch.getAuthor());

        // pass the selected books fields across to the borrow pane
        fx_borrowpage_author.setText(buchs.getAuthor());
        fx_borrowpage_title.setText(buchs.getBook());
        fx_borrowpage_published.setText(String.valueOf(buchs.getYear()));
        fx_borrowpage_description.setText("");
        fx_borrowpage_isbn.setText(buchs.getISBN1());
       
        
        fx_availability_status.setText(buchs.getStatus());
        fx_borrowpage_overview.setText("");
        fx_borrowpage_borrower.setText("");
        fx_borrowpage_school_level.setText("");
        fx_borrowpage_id.setText("");

    }

    @FXML
    public void searchtab_noselection_alert() {
        Stage popupwindow = new Stage();
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        //popupwindow.setTitle("This is a pop up window");

        Label label1 = new Label("Borrow the book: " + buch.getBook() + " by " + buch.getAuthor() + "?");
        Button button1 = new Button("Borrow");
        button1.setOnAction(e -> popupwindow.close());

        Button button2 = new Button("Cancel");
        button1.setOnAction(e -> popupwindow.close());

        //VBox layout = new VBox(10);
        //layout.getChildren().addAll(label1, button1, button2);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(label1, button1, button2);

        //layout.setAlignment(Pos.CENTER);
        //Scene scene1 = new Scene(layout, 500, 250);
        hbox.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(hbox, 500, 250);

        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }

    @FXML
    public void searchtab_borrowbtn_confirmation() throws SQLException, IOException {

        Stage popupwindow = new Stage();
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Initiate Borrowing Session");
        alert.setHeaderText("Are you sure you wish to borrow this book?");
        ///alert.setContentText("Confirm borrow: \"" + buch.getBook() + "\" by " + buch.getAuthor() + "?");
        alert.setContentText("\""+ buch.getBook() + "\" by " + buch.getAuthor());
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            select_search_item_return();
        } else {
            popupwindow.close();
        }

    }

    public BookObject generate_search_object(BookObject buch, String ISBN) throws SQLException, IOException {

        // create a socket for jdbc search
        JDBC_Controller socket = new JDBC_Controller();
        BookObject buch_return = new BookObject();
        
        // generate the equivalent bookobject from the tableview input
        buch_return = socket.jdbc_search_singlebook(buch, ISBN);
        // this method will pass a BookObject which will populate the tabs

        return buch_return;
    }
;
    
    @FXML
    public void server_connection_issue() throws SQLException, IOException {

        Stage popupwindow = new Stage();

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Network Timeout");
        alert.setHeaderText("SERVER CONNECTION ISSUE");
        alert.setContentText("Your connection with the servers has been lost. Please make sure have a reliable network connection and try again. Riverting to local stored databases.");
        alert.showAndWait(); 
    };
}
