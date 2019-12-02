/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.math.BigInteger;
import java.util.Scanner;
import javax.swing.JTextPane;

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
    private Button school_catalogue_go;

    @FXML
    private Button button1;

    @FXML
    private Button go_button2;

    @FXML
    private Button popup;

    @FXML
    private Button returnbutton;

    @FXML
    private DatePicker calendar_start;

    @FXML
    private DatePicker calendar_start1;

    @FXML
    // note togglegroup and togglebuttons must be defined in controller class
    private ToggleButton button_title, button_author, button_isbn,
            register_surnames, register_firstnames, register_ids,
            search_bks_title, search_bks_author, search_bks_isbn;

    //------
    // Context menu entries for the Search TabPane's TableView
    @FXML
    private final MenuItem borrowSession = new MenuItem("Borrow this book");

    @FXML
    private final MenuItem returnSession = new MenuItem("Return this book");

    @FXML
    private final MenuItem addBookSession = new MenuItem("Add new book");

    @FXML
    private final MenuItem addStudentSession = new MenuItem("Add new student");

    @FXML
    private final MenuItem editStudentSession = new MenuItem("Edit student entry");

    @FXML
    private final MenuItem deleteStudentSession = new MenuItem("Delete student entry");
    //------

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
    private ImageView photobox_borrow = new ImageView();

    @FXML
    private ImageView catalogue_image1_handle = new ImageView();

    @FXML
    private ImageView borrow_image_box = new ImageView();

    @FXML
    private ImageView image_anchor_1 = new ImageView();

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
    private TextArea fx_borrowpage_overview = new TextArea();

    @FXML
    private TextField fx_borrowpage_borrower = new TextField();

    @FXML
    private TextField fx_borrowpage_borrower_firstname = new TextField();

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
    private TextField hellos = new TextField();

    @FXML
    private TableView<LibraryBooksStatus> searchTableCatalogue;

    @FXML
    private TableColumn<LibraryBooksStatus, String> book_searchbar, author_searchbar, status_searchbar, isbn_searchbar;

    @FXML
    private TableView<LibraryBooksStatus> schoolCatalogueTable;

    @FXML
    private TableColumn<LibraryBooksStatus, String> author_search, book_search, status_search, isbn_search, isbn_school_cat;

    @FXML
    private TableColumn<LibraryBooksStatus, Integer> id, year;

    @FXML
    private TableColumn<LibraryBooksStatus, String> book, author, status, isbn1, isbnx, ISBN1, catalogue_pane_status;

    @FXML
    private TableColumn<LibraryBooksStatus, String> name, name1, book1;

    @FXML
    private TableView<StudentRegisterStatus> table2;

    @FXML
    private TableColumn<StudentRegisterStatus, String> name_sregister, book_sregister, author_sregister;

    @FXML
    private TableColumn<StudentRegisterStatus, Integer> id_sregister, year_sregister;

    @FXML
    private Button button_catalogue;

    public FXMLDocumentController() {
        //this.toggleGroup = new ToggleGroup();

    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 2 OCtober 2019
     * @description label used for testing table view
     *
     */
    @FXML
    private void handleButtonAction(ActionEvent event, String Hello) {
        System.out.println("You clicked me!");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Add a context menu to TableView
        borrowSession.setOnAction(e -> {
            try {
                this.searchtab_borrowbtn_confirmation();
            } catch (SQLException ex) {
                this.server_connection_issue();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        returnSession.setOnAction(e -> {
            //complete this section

        });
        searchTableCatalogue.setContextMenu(new ContextMenu(borrowSession, returnSession));

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
                    schoolCatalogueTable.getColumns().addAll(ISBN1, name, year, book, author);
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

        // add some default book listings
        searchTableCatalogue.getItems().add(new LibraryBooksStatus("The Stepford Wivez", "Ira Lee", "Borrowed", "9784150410513"));
        searchTableCatalogue.getItems().add(new LibraryBooksStatus("The Stepford Wivez", "Ira Lee", "Borrowed", "9788401468711"));

        // add some default student names
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus("111", "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee", "Shelved"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus("222", "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte", "Shelved"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus("1111", "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee", "Shelved"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus("2222", "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily", "Shelved"));

        // earch pane
        year_sregister.setCellValueFactory(new PropertyValueFactory<>("year"));
        id_sregister.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_sregister.setCellValueFactory(new PropertyValueFactory<>("name"));
        book_sregister.setCellValueFactory(new PropertyValueFactory<>("book"));
        author_sregister.setCellValueFactory(new PropertyValueFactory<>("author"));

        // school catalogue table pane entries
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        isbn_school_cat.setCellValueFactory(new PropertyValueFactory<>("ISBN1"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        catalogue_pane_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        book_search.setCellValueFactory(new PropertyValueFactory<>("book"));
        author_search.setCellValueFactory(new PropertyValueFactory<>("author"));
        status_search.setCellValueFactory(new PropertyValueFactory<>("status"));
        isbn_search.setCellValueFactory(new PropertyValueFactory<>("isbn1"));

        register_firstnames.setToggleGroup(toggleGroupStudentRegister);
        register_firstnames.setUserData("firstname");
        register_surnames.setToggleGroup(toggleGroupStudentRegister);
        register_surnames.setUserData("lastname");
        register_ids.setToggleGroup(toggleGroupStudentRegister);
        register_ids.setUserData("studentnumber");

        // set meta data
        fx_borrowpage_borrower_firstname.setUserData("fx_firstname");
        fx_borrowpage_borrower.setUserData("fx_surname");
        fx_borrowpage_school_level.setUserData("fx_schoollevel");
        fx_borrowpage_id.setUserData("fx_id");

        //create a togglegroup for all three buttons; i.e. only one may be depressed at a time
        search_bks_title.setToggleGroup(toggleGroupBookSearch);
        search_bks_title.setUserData("searchtitle");
        search_bks_author.setToggleGroup(toggleGroupBookSearch);
        search_bks_author.setUserData("searchauthor");
        search_bks_isbn.setToggleGroup(toggleGroupBookSearch);
        search_bks_isbn.setUserData("searchisbn");

        // default is to have the books button depressed
        search_bks_title.fire();

        fxsearchtab_search.setText("");

    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 16 November 2019
     * @description following method takes a book object and inserts it into
     * table view
     *
     */
    @FXML
    private void borrowpage_button(ActionEvent event) throws MalformedURLException, IOException, SQLException, InterruptedException {

        
        Scanner in = new Scanner(System.in);
        FileWriter outFile = new FileWriter("/Users/kwadwooteng-amoako/NetBeansProjects/UserInterface/src/userinterface/myfile2.txt");
        PrintWriter out = new PrintWriter(outFile);
        out.printf("//////////////////////////////// \r\n");
        out.printf("// The Hilltop British School // \r\n");
        out.printf("//    Kumasi, Daban, Ghana.   // \r\n");
        out.printf("//    Phone: +233 244854490   // \r\n");
        // clear all the fields in the date page
        fx_borrowpage_author.setText("");
        fx_borrowpage_title.setText("");
        fx_borrowpage_published.setText("");
        fx_borrowpage_description.setText("");
        fx_borrowpage_isbn.setText("");
        fx_borrowpage_overview.setText("");
        fx_availability_status.setText("");
        fx_borrowpage_borrower_firstname.setText("");
        fx_borrowpage_borrower.setText("");
        fx_borrowpage_school_level.setText("");
        fx_borrowpage_id.setText("");
        calendar_start.getEditor().clear();
        calendar_start1.setValue(null);
        //System.out.println("You clicked me again 1111!");

        

        System.out.println("Done");
        out.close(); // Important: don't forget to close!

        String fileHandle = "/Users/kwadwooteng-amoako/NetBeansProjects/UserInterface/src/userinterface/myfile2.txt";
        File file = new File(fileHandle);
        Desktop.getDesktop().edit(file);

        //Desktop.getDesktop().print(file);
    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 16 November 2019
     * @description when key pressed it initiates a search of records table view
     *
     */
    @FXML
    private void insert_student_records_entry(StudentRegisterStatus[] student_records) throws MalformedURLException, IOException, SQLException, InterruptedException {

        // output to tableview
        for (int i = 0x0; i <= (student_records.length); ++i) {

            // exit when we reach the end of the array
            if (student_records[i] == null) {
                break;
            }

            //  public StudentRegisterStatus(int isbn, String name, int year, String book, String author, String status) {
            // schoolCatalogueTable.getItems().add(new StudentRegisterStatus(student_records[i].getISBN(), "2", "5", "2", "2", "3"));
        }

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
    private void searchpage_borrowpage_button(ActionEvent event) throws MalformedURLException, IOException, SQLException, InterruptedException {
        System.out.println("You clicked me again!");

        BookObject[] bucher = new BookObject[1000];
        JDBC_Controller socket = new JDBC_Controller();
        bucher = socket.jdbc_find_book(bucher);

        this.insert_book_entry(bucher);
        Thread.sleep(1000);

    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 2 October 2019
     * @description when key pressed it initiates a search of records table view
     *
     */
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
     * @date 2 October 2019
     * @description insert a book entry table view
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
            System.out.println(bucher[0].getBook());
            // output to tableview
            schoolCatalogueTable.getItems().add(new LibraryBooksStatus(bucher[i].getISBN1(), bucher[i].getYear(), bucher[i].getBook(), bucher[i].getAuthor(), bucher[i].getStatus()));
        }

    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description inserts the book entry back into the tab after a prompt
     * table view
     *
     */
    @FXML
    private void insert_book_entry_searchtab(BookObject bucher[]) throws InterruptedException {

        ObservableList<LibraryBooksStatus> table = FXCollections.<LibraryBooksStatus>observableArrayList();

        // generate an observable list to ensure there are no duplicates
        for (LibraryBooksStatus item : searchTableCatalogue.getItems()) {
            table.add(item);
        }

        // output the contents of the entire array
        for (int i = 0x0; i <= (bucher.length); ++i) {
            // exit when we reach the end of the array

            if (bucher[i] == null) {
                break;
            }

            // create a new object to hold the data
            LibraryBooksStatus libObj = new LibraryBooksStatus(
                    bucher[i].getBook(),
                    bucher[i].getAuthor(),
                    bucher[i].getStatus(),
                    bucher[i].getISBN1()
            );

            if (!table.contains(libObj)) {

                // you may remove
                System.out.println("title returned>>>>>>>>>" + bucher[i].getBook());

                // output to tableview
                searchTableCatalogue.getItems().add(libObj);

                table.add(libObj);
            }

        }

    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description populates the student array tab
     *
     */
    @FXML
    private void insert_students_entry(PupilObject kinder[]) throws InterruptedException {

        // search through the array
        for (int i = 0x0; i <= (kinder.length); ++i) {

            // exit when we reach the end of the array
            if (kinder[i] == null) {
                break;
            }

            // populate the table
            table2.getItems().add(new StudentRegisterStatus(1, kinder[0].getLastname(), 2, "989898", "3"));
        }

    }

    // ----------------------------------------------->
    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description populates a search tab query
     *
     */
    private void search_pane_query() {

        // initialize
        String btnDepressedId;
        String searchQuery;

        btnDepressedId = new String();
        searchQuery = new String();

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

        // initialize
        String btnDepressedId;
        String searchQuery;

        //searchQuery = new String();
        btnDepressedId = null;

        searchQuery = fxsearchtab_search.getText();

        // checks that there is both a query and that a toggle button is depressed
        while ((!searchQuery.isEmpty()) && (btnDepressedId == null)) {

            // capture the depressed buttons id by a string
            btnDepressedId = toggleGroupBookSearch.getSelectedToggle().getUserData().toString();

            // may remove -- used to track depressed buttons
            System.out.println(btnDepressedId);
        }

        if (!searchQuery.isEmpty()) {
            BookObject[] bucher = new BookObject[1000];
            JDBC_Controller socket = new JDBC_Controller();

            // check that the book is not stored locally
            bucher = socket.jdbc_search_book(bucher, toggleGroupBookSearch.getSelectedToggle().getUserData().toString(), searchQuery);

            // if not stored locally search googles records
            if (bucher == null) {
                this.search_cloud_notification(toggleGroupBookSearch.getSelectedToggle().getUserData().toString() + ": " + searchQuery);
            } else {
                this.insert_book_entry_searchtab(bucher);
            }
            Thread.sleep(1000);
        }
    }

    ;

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description switch pane tabs 
     *
     */
    @FXML
    private void switch_tab() {

        // get all tab information
        books_tab_pane.getTabs().addAll(search_tab, newsearchtext, studentsearchqueryss, teturn_tab, borrows_tabs);

        //field.setText("hello");
        System.out.println(books_tab_pane.getSelectionModel().getSelectedIndex());

        // populate
        books_tab_pane.getSelectionModel().select(3);

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description allow the user to select the item which they wish to borrow
     * and populate the borrow tab
     *
     */
    @FXML
    private void select_search_item_borrow() throws SQLException, IOException {
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        BookObject buchs = new BookObject();

        buchs = this.generate_search_object(buchs, buch.getIsbn1());

        // you may remove
        System.out.println(buch.getAuthor());

        // pass the selected books fields across to the borrow pane
        fx_borrowpage_author.setText(buchs.getAuthor());
        fx_borrowpage_title.setText(buchs.getBook());
        fx_borrowpage_published.setText(String.valueOf(buchs.getYear()));
        fx_borrowpage_isbn.setText(buchs.getISBN1());
        fx_borrowpage_description.setText(buchs.getCategories());
        fx_availability_status.setText(buchs.getStatus());
        fx_borrowpage_overview.setText(buchs.getOverview());
        fx_borrowpage_borrower.setText("");
        fx_borrowpage_school_level.setText("");
        fx_borrowpage_id.setText("");

        // force text to wrap
        fx_borrowpage_overview.setWrapText(true);

        String fileHandle = "/Users/kwadwooteng-amoako/NetBeansProjects/UserInterface/src/userinterface/images/" + buchs.getFilePath() + ".jpeg";
        File file = new File(fileHandle);
        boolean backgroundLoading = true;
        Image image2 = new Image(file.toURI().toString(), backgroundLoading);

        borrow_image_box.setImage(image2);
        borrow_image_box.setPreserveRatio(true);

        // insert a holder for future inclusion of users photos
        File file3 = new File("/Users/kwadwooteng-amoako/NetBeansProjects/UserInterface/src/userinterface/images/dummy_silo.jpeg");
        Image image3 = new Image(file3.toURI().toString(), backgroundLoading);

        photobox_borrow.setImage(image3);
        photobox_borrow.setPreserveRatio(true);

        // insert current date as the date the book was borrowed
        // set the return date to two weeks after the borrow date by default
        LocalDate todaysDate = LocalDate.now();
        LocalDate returnDate = LocalDate.now().plusWeeks(2);

        // populate the borrow and return dates
        calendar_start.setValue(todaysDate);
        calendar_start1.setValue(returnDate);
    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description use the iSBN number to populate the entire borrow pane
     *
     */
    @FXML
    private void select_search_item_return() throws SQLException, IOException {
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        BookObject buchs = new BookObject();

        // pass the selected books fields across to the borrow pane
        JDBC_Controller socket = new JDBC_Controller();
        socket.jdbc_return_book(buch.getISBN1());

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description alert user through a pop-up window of their book selection
     *
     */
    @FXML
    public void searchtab_noselection_alert() {
        Stage popupwindow = new Stage();
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        popupwindow.initModality(Modality.APPLICATION_MODAL);

        Label label1 = new Label("Borrow the book: " + buch.getBook() + " by " + buch.getAuthor() + "?");
        Button button1 = new Button("Borrow");
        button1.setOnAction(e -> popupwindow.close());

        Button button2 = new Button("Cancel");
        button1.setOnAction(e -> popupwindow.close());

        //VBox layout = new VBox(10);
        //layout.getChildren().addAll(label1, button1, button2);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(label1, button1, button2);

        hbox.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(hbox, 500, 250);

        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description this is the search button confirmation after hitting borrow
     */
    @FXML
    public void searchtab_borrowbtn_confirmation() throws SQLException, IOException {

        // grab search query
        String query = fxsearchtab_search.getText();

        // checks that the user has populated the query field and has also selected an entry from the table before progressing.
        //if (!query.isEmpty() && (searchTableCatalogue.getSelectionModel().getSelectedIndex() >= 0)) {
        if ((searchTableCatalogue.getSelectionModel().getSelectedIndex() >= 0)) {
            Stage popupwindow = new Stage();
            LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(AlertType.CONFIRMATION);

            alert.setTitle("Initiate Borrowing Session");
            alert.setHeaderText("Are you sure you wish to borrow this book?");

            alert.setContentText("\"" + buch.getBook() + "\" by " + buch.getAuthor());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // complete the borrow request
                select_search_item_borrow();

                // clear the entry from tableview
                searchTableCatalogue.getItems().remove(buch);
            } else {
                popupwindow.close();
            }
        }

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description this is the search button confirmation after hitting return
     */
    @FXML
    public void searchtab_returnbtn_confirmation() throws SQLException, IOException {

        // grab search query
        String query = fxsearchtab_search.getText();

        // checks that the user has populated the query field and has also selected an entry from the table before progressing.
        //if (!query.isEmpty() && (searchTableCatalogue.getSelectionModel().getSelectedIndex() >= 0)) {
        if ((searchTableCatalogue.getSelectionModel().getSelectedIndex() >= 0)) {
            Stage popupwindow = new Stage();
            LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(AlertType.CONFIRMATION);

            // set-up an alert
            alert.setTitle("Initiate Borrowing Session");
            alert.setHeaderText("Are you sure you wish to return this book?");
            alert.setContentText("\"" + buch.getBook() + "\" by " + buch.getAuthor());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                //complete the return request
                select_search_item_return();

                // clear the entry from tableview
                searchTableCatalogue.getItems().remove(buch);

            } else {
                popupwindow.close();
            }
        }

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description this is the search button confirmation after hitting return
     */
    @FXML
    public void search_cloud_notification(String AlertHeader) throws SQLException, IOException {

        Stage popupwindow = new Stage();
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cloud Search Notification");
        alert.setHeaderText("Book is not catalogued locally. Search cloud for book?");
        alert.setContentText(AlertHeader);
        //alert.setContentText("\"" + buch.getBook() + "\" by " + buch.getAuthor());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            popsup1();
        } else {
            popupwindow.close();
            obtain_ISBN();
        }

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description generate a search object
     */
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
    
    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description generate window when there is a server connection issue
     */
    @FXML
    public void server_connection_issue() {

        Stage popupwindow = new Stage();

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Network Timeout");
        alert.setHeaderText("SERVER CONNECTION ISSUE");
        alert.setContentText("Your connection with the servers has been lost. Please make sure have a reliable network connection and try again. Riverting to local stored databases.");
        alert.showAndWait();
    }

    ;
    
    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description likely redundant --- check and then delete
     */
    @FXML
    public void load_image() {
        System.out.println("hello");
        String url = "https://books.google.com.gh/books/content?id=YG9okGt4Wt4C&printsec=frontcover&img=1&zoom=1&imgtk=AFLRE70byCnPACD-0f58YqwlX2UmQudfhGYu12SOWgFaiHer6paDzpX5TB2g_8lachuu4XB5MND2zpglrJbIN3OmsOn66AC_9w3DTgw5wtVo7iQpyBoXAnVJ3kOgskojMy8kmw8nvZLz";
        String imagePath = "image1.jpeg";

        // load the file containing the image. 
        File file = new File("/Users/kwadwooteng-amoako/NetBeansProjects/UserInterface/src/userinterface/images/image2.jpeg");
        boolean backgroundLoading = true;
        Image image2 = new Image(file.toURI().toString(), backgroundLoading);

        // update the image box
        borrow_image_box.setImage(image2);
        borrow_image_box.setPreserveRatio(true);

    }

    ;

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description search for the students name by accessing the database and then returning the fields
     */
    @FXML
    public void quick_search_firstname() throws IOException, SQLException {

        // clear fields
        fx_borrowpage_borrower.setText("");
        fx_borrowpage_school_level.setText("");
        fx_borrowpage_id.setText("");

        // grab query
        String query = fx_borrowpage_borrower_firstname.getText();
        Node node = new TextField();
        System.out.println(((TextField) node).getUserData());

        //search database for closest match
        JDBC_Controller socket = new JDBC_Controller();
        StudentRegisterd obj = new StudentRegisterd();
        obj = socket.jdbc_quick_search_firstname(query);

        // update fields
        fx_borrowpage_borrower.setText(obj.getLastname());
        fx_borrowpage_school_level.setText(String.valueOf(obj.getClassd()));
        fx_borrowpage_id.setText(String.valueOf(obj.getId()));

    }

    ;
    
    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description search for the students using the lastname  by accessing the database and then returning the fields
     */
    @FXML
    public void quick_search_lastname() throws IOException, SQLException {

        // clear fields
        fx_borrowpage_borrower_firstname.setText("");
        fx_borrowpage_school_level.setText("");
        fx_borrowpage_id.setText("");

        // grab query
        String query = fx_borrowpage_borrower.getText();

        //search database for closest match
        JDBC_Controller socket = new JDBC_Controller();
        StudentRegisterd obj = new StudentRegisterd();
        obj = socket.jdbc_quick_search_lastname(query);

        // update fields
        fx_borrowpage_borrower_firstname.setText(obj.getFirstname());
        fx_borrowpage_school_level.setText(String.valueOf(obj.getClassd()));
        fx_borrowpage_id.setText(String.valueOf(obj.getId()));

    }

    ;
    
    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description search for the students using the return button confirmation 
     */
    @FXML
    public void seachtab_return_btn_confirmation() throws IOException, SQLException {
        // grab search query
        String query = fxsearchtab_search.getText();
        Stage popupwindow;
        Alert alert;

        // checks that the user has populated the query field and has also selected an entry from the table before progressing.
        //if (!query.isEmpty() && (searchTableCatalogue.getSelectionModel().getSelectedIndex() >= 0)) {
        if ((searchTableCatalogue.getSelectionModel().getSelectedIndex() >= 0)) {
            popupwindow = new Stage();
            LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
            alert = new Alert(AlertType.CONFIRMATION);

            // generate the box information
            alert.setTitle("Initiate Return Session");
            alert.setHeaderText("Are you sure you wish to return this book?");
            alert.setContentText("\"" + buch.getBook() + "\" by " + buch.getAuthor());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                select_search_item_return();

            } else {
                popupwindow.close();
            }
        }
    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 13 November 2019
     * @description generate the pop-up window for user selection
     */
    @FXML
    public void popsup1() throws IOException, SQLException {
        // grab search query
        String query = fxsearchtab_search.getText();
        StringBuilder filename = new StringBuilder();
        StringBuilder suffix = new StringBuilder();

        // Create an instance of the google socket class
        Google_Socket gs = new Google_Socket();

        // Use the method find books to locate book through Google's API
        BookObject cloud_search = gs.google_find_book(query);

        System.out.println("Hello \n" + cloud_search.getCategories());

        Boolean FLAGS = true;
        // checks that the user has populated the query field and has also selected an entry from the table before progressing.
        if (((searchTableCatalogue.getSelectionModel().getSelectedIndex() >= 0) | FLAGS)) {
            Stage popupwindow = new Stage();
            LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(AlertType.CONFIRMATION);

            // generate the box information
            alert.setTitle("Add Book");
            alert.setHeaderText("Will you like to add the following book to your catalogue? \n");

            // label
            String title_label = cloud_search.getBook();

            // label
            String author_label = cloud_search.getAuthor();
            author_label = author_label.replaceAll("\\[", "").trim();
            author_label = author_label.replaceAll("\\]", "").trim();
            author_label = author_label.replaceAll("  ", "").trim();

            alert.setHeaderText("Title: " + title_label + "\n Authored by: " + author_label);

            String content = String.format("Is this the correct book?");

            alert.setContentText(content);

            //System.out.println("title>>>>"+cloud_search.getThumbNailIndentifier());
            // generate random string suffix
            suffix.append("image_" + this.generateRandomString(32));

            // capture the resource locator
            String resource = cloud_search.getThumbNailIndentifier();
            resource = resource.replaceAll("\"", "").trim();
            URL url = new URL(resource);
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();

            // save file from the resource locator
            filename.append("/Users/kwadwooteng-amoako/NetBeansProjects/UserInterface/src/userinterface/images/" + suffix.toString() + ".jpeg");
            //System.out.println("print out" + filename.toString());

            Files.copy(url.openStream(), new File(filename.toString()).toPath());

            // load the data in the background from the file saved
            boolean backgroundLoading = true;
            File file3 = new File(filename.toString());
            Image image3 = new Image(file3.toURI().toString(), backgroundLoading);

            // set the image bounds
            ImageView images = new ImageView(image3);
            images.setLayoutX(5);
            images.setLayoutY(5);

            // include the image in the display
            alert.setGraphic(images);

            //repotion the window size
            alert.setResizable(true);
            alert.getDialogPane().setPrefSize(480, 320);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                // select_search_item_return();
                String ISBN_Phrase = obtain_ISBN();

                if (!"".equals(ISBN_Phrase)) {
                    cloud_search.setISBN1(ISBN_Phrase);
                }

            } else {

                popupwindow.close();

            }
        }

        // label
        String author_label = cloud_search.getAuthor();
        author_label = author_label.replaceAll("\\[", "").trim();
        author_label = author_label.replaceAll("\\]", "").trim();
        author_label = author_label.replaceAll("  ", "").trim();
        author_label = author_label.replaceAll("\"", "").trim();
        cloud_search.setAuthor(author_label);

        cloud_search.setStatus(false);

        String book_name = cloud_search.getBook();
        book_name = book_name.replaceAll("\\[", "").trim();
        book_name = book_name.replaceAll("\\]", "").trim();
        book_name = book_name.replaceAll("  ", "").trim();
        book_name = book_name.replaceAll("\"", "").trim();
        cloud_search.setBook(book_name);

        System.out.println("cloud_search.getISBN1()>" + cloud_search.getISBN1() + "<");
        System.out.println("suffix>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + suffix);

        System.out.println(cloud_search.getCategories());
        System.out.println(cloud_search.getDescription());

        // create a new object to hold the data 
        LibraryBooksStatus libObj = new LibraryBooksStatus(
                cloud_search.getISBN1(),
                Integer.valueOf(cloud_search.getPublishedYEar()),
                "",
                cloud_search.getBook(),
                cloud_search.getAuthor(),
                cloud_search.getStatus(),
                suffix.toString() + ".jpeg",
                cloud_search.getCategories(),
                cloud_search.getDescription(),
                cloud_search.getThumbNailIndentifier()
        );

        // if no entry is returned from the ISBN lookup do not update the table
        if (!"".equals(cloud_search.getISBN1())) {
            searchTableCatalogue.getItems().add(libObj);

            System.out.println(cloud_search.getAuthor());

            JDBC_Controller jd = new JDBC_Controller();

            jd.jdbc_quick_insert(libObj);
        }

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 14 November 2019
     * @description generate a random string used for storing image data
     */
    private String generateRandomString(int length) {
        // Random string suffix generator
        // Source: http://www.appsdeveloperblog.com/generate-random-string-in-java-different-ways/
        Random RANDOM = new SecureRandom();
        String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 14 November 2019
     * @description obtain a books isbn number
     */
    @FXML
    public String obtain_ISBN() throws SQLException, IOException {

        Boolean flag = true;
        String titleText = "Confirm ISBN";
        String headerText = "Before the book may be added to the local catalogue the ISBN must be confirmed.";

        TextInputDialog dialog = new TextInputDialog("walter");
        dialog.setTitle("Confirm ISBN");
        dialog.setHeaderText("Before the book may be added to the local catalogue the ISBN must be confirmed.");
        dialog.setContentText("ISBN:");
        Optional<String> results = dialog.showAndWait();
        String result_out = results.get();

        results.ifPresent(name -> System.out.println("ISBN: " + name));

        System.out.println("results  " + results);
        result_out = result_out.replaceAll("\\[", "").trim();
        result_out = result_out.replaceAll("\\]", "").trim();
        result_out = result_out.replaceAll("  ", "").trim();
        result_out = result_out.replaceAll("\"", "").trim();
        result_out = result_out.replaceAll("-", "").trim();
        results = Optional.of(result_out);

        String val = result_out;

        // allow only ISBN10 or ISBN13
        if ((val.length() == 10) | (val.length() == 13)) {

            // set the isbn if it exists
            val = this.confirm_ISBN();

        } else {

            // generate error message
            this.isbn_error();
            return "";
        }

        return val;

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 14 November 2019
     * @description confirm books isbn nuber
     */
    @FXML
    public String confirm_ISBN() throws SQLException, IOException {

        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Confirm ISBN");
        dialog.setHeaderText("Before the book may be added to the local catalogue the ISBN must be confirmed.");
        dialog.setContentText("ISBN:");
        Optional<String> results = dialog.showAndWait();

        String result_out = results.get();
        result_out = result_out.replaceAll("\\[", "").trim();
        result_out = result_out.replaceAll("\\]", "").trim();
        result_out = result_out.replaceAll("  ", "").trim();
        result_out = result_out.replaceAll("\"", "").trim();
        result_out = result_out.replaceAll("-", "").trim();
        results = Optional.of(result_out);

        String val = results.get();

        System.out.println(results.get());

        if (val.length() == 10) {
            if (this.check_isbn10(results.get())) {
                thanks_dialog();

            } else {
                isbn_error();
                return "";
            }

        }

        if (val.length() == 13) {

            if (this.check_isbn13(results.get())) {
                thanks_dialog();

                //return val;
            } else {
                isbn_error();
                return "";
            }

        } else {
            this.isbn_error();
            return "";
        }

        return val;
    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 14 November 2019
     * @description generate a thanks dialog box
     */
    @FXML
    public void thanks_dialog() throws SQLException, IOException {

        Stage popupwindow = new Stage();
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Cataloguing complete.");
        alert.setHeaderText("Book has been added. Thank You !!");

        // Optional<ButtonType> result = alert.showAndWait();
    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 14 November 2019
     * @description generate an dialog box when the isbn is found to be in error
     */
    @FXML
    public void isbn_error() throws SQLException, IOException {

        Stage popupwindow = new Stage();
        LibraryBooksStatus buch = searchTableCatalogue.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error in the ISBN number");
        alert.setHeaderText("Error in the ISBN number. \n Book has not been added.");

        Optional<ButtonType> result = alert.showAndWait();

    }

    /**
     *
     * @author kwadwooteng-amoako
     * @date 14 November 2019
     * @description checks that the isbn-10 value is considered accurate
     */
    public boolean check_isbn10(String value) {
        // the following routine will check an ISBN 10 number
        // And determine it's accuracy by returning a boolean

        // declaration
        String final_check_sum;
        String input_check_sum;

        // grab the input checksum
        input_check_sum = String.valueOf(value.charAt(value.length()));

        // check to ensure it's 10 variables
        value = value.replace("-", "");

        // variabls
        Integer checksum = 0;
        Integer length_of_isbn = value.length();

        // sum digits
        for (int i = 0; i <= (length_of_isbn - 1); i++) {
            // take the nth figure and convert it to an integer
            String y = String.valueOf(value.charAt(i));
            Integer yInt = Integer.valueOf(y);

            // store running checksum
            checksum = checksum + (yInt * (10 - i));
        }

        // generate the checksum
        checksum = (checksum % 11);

        // calculate final checksum
        if (checksum == 0) {
            final_check_sum = "X";
        } else {
            checksum = 11 - checksum;
            final_check_sum = checksum.toString();
        }

        // return status
        return !(input_check_sum == null ? final_check_sum != null : !input_check_sum.equals(final_check_sum));

    }

    ;

        /**
        *
        * @author kwadwooteng-amoako
        * @date 14 November 2019
        * @description checks that the isbn-13 value is considered accurate
        */  
        public boolean check_isbn13(String value) {
        // the following routine will check an ISBN 13 number
        // And determine it's accuracy by returning a boolean

        String input_check_sum;
        String final_check_sum;

        // grab the input checksum
        input_check_sum = String.valueOf(value.charAt(value.length() - 1));

        // check to ensure it's 13 variables
        value = value.replace("-", "");
        value = value.replace(" ", "");

        // variabls
        Integer checksum = 0;
        Integer length_of_isbn = value.length();

        // sum digits
        for (int i = 0; i <= (length_of_isbn - 2); i++) {

            // take the nth figure and convert it to an integer
            String y = String.valueOf(value.charAt(i));
            Integer yInt = Integer.valueOf(y);

            if ((i % 2) == 0) {

                // store running checksum
                checksum = checksum + (yInt * 1);
            } else {
                // store running checksum
                checksum = checksum + (yInt * 3);
            }

        }

        // generate the checksum
        checksum = (checksum % 10);

        // calculate final checksum
        if (checksum == 0) {
            final_check_sum = "0";
        } else {
            checksum = 10 - checksum;
            final_check_sum = checksum.toString();
        }

        // return status
        return !(input_check_sum == null ? final_check_sum != null : !input_check_sum.equals(final_check_sum));

    }

    ;
        
        /**
        *
        * @author kwadwooteng-amoako
        * @date 14 November 2019
        * @description checks that the isbn-13 value is considered accurate
        */  
        public void print_receipt() {

        };

};
