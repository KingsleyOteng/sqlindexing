/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.Region;
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
    private ImageView borrow_photo_box = new ImageView();

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
    private TableColumn<LibraryBooksStatus, String> book, author, status, isbn1, catalogue_pane_status;

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
                    schoolCatalogueTable.getColumns().addAll(isbn1, name, year, book, author);
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

        File file = new File("/Users/kwadwooteng-amoako/NetBeansProjects/UserInterface/src/userinterface/images/image1.jpeg");
        boolean backgroundLoading = true;
        Image image2 = new Image(file.toURI().toString(), backgroundLoading);
        borrow_photo_box.setImage(image2);
        borrow_photo_box.setPreserveRatio(true);

        schoolCatalogueTable.setPlaceholder(new Label("Search books"));
        searchTableCatalogue.setPlaceholder(new Label("Search books teo"));
        table2.setPlaceholder(new Label("Search students"));

        searchTableCatalogue.getItems().add(new LibraryBooksStatus("Stepford Wives", "Ira Lee", "Shelved", "9784150410513"));
        searchTableCatalogue.getItems().add(new LibraryBooksStatus("Stepford Wives", "Ira    Lee", "Shelved", "9788401468711"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus(111, "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee", "Shelved"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus(222, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte" , "Shelved"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus(1111, "kwadwo oteng-amoako", 2100, "Stepford Wives", "Ira Lee" , "Shelved"));
        schoolCatalogueTable.getItems().add(new LibraryBooksStatus(2222, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily" , "Shelved"));

     
                
                
        //table2.getItems().add(new StudentRegisterStatus(2, "kofi oteng-boateng", 2000, "Wuthering Heights", "Emily Bronte"));
        year_sregister.setCellValueFactory(new PropertyValueFactory<>("year"));
        id_sregister.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_sregister.setCellValueFactory(new PropertyValueFactory<>("name"));
        book_sregister.setCellValueFactory(new PropertyValueFactory<>("book"));
        author_sregister.setCellValueFactory(new PropertyValueFactory<>("author"));

        // school catalogue table pane entries
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        isbn_school_cat.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        book.setCellValueFactory(new PropertyValueFactory<>("book"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        catalogue_pane_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        book_search.setCellValueFactory(new PropertyValueFactory<>("book"));
        author_search.setCellValueFactory(new PropertyValueFactory<>("author"));
        status_search.setCellValueFactory(new PropertyValueFactory<>("status"));
        isbn_search.setCellValueFactory(new PropertyValueFactory<>("isbn1"));
        
        //isbn_school_cat.setCellValueFactory(new PropertyValueFactory<>("isbn1"));

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

        //System.out.println(toggleGroup.getSelectedToggle());
        //System.out.println(schoolCatalogueTable.lookupAll(".column-header").toString());
        String yy = schoolCatalogueTable.lookupAll(".column-header").toString();

        // ChangeListener<String> listener = ((observable, oldValue, newValue) -> {
        //     System.out.println(newValue + " >>> Out <<<" + oldValue);
        // });
        //fx_borrowpage_borrower_firstname.textProperty().addListener(listener);
        // fx_borrowpage_borrower.textProperty().addListener(listener);
        // fx_borrowpage_school_level.textProperty().addListener(listener);
        // fx_borrowpage_id.textProperty().addListener(listener);
        fxsearchtab_search.setText("");
    }

    @FXML
    private void borrowpage_button(ActionEvent event) throws MalformedURLException, IOException, SQLException, InterruptedException {
        System.out.println("You clicked me again!");
        
        BookObject[] bucher = new BookObject[1000];
        JDBC_Controller socket = new JDBC_Controller();
        bucher = socket.jdbc_find_book(bucher);
        schoolCatalogueTable.getItems().clear();
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
            System.out.println(bucher[0].getBook());
            // output to tableview
            schoolCatalogueTable.getItems().add(new LibraryBooksStatus(bucher[i].getISBN1(), bucher[i].getYear(), bucher[i].getBook(), bucher[i].getAuthor(), bucher[i].getStatus()));
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

            System.out.println("hello>>>>>>>>>" + bucher[i].getBook());

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

        searchQuery = new String();
        btnDepressedId = null;

        
        searchQuery = fxsearchtab_search.getText();
        
        // checks that there is both a query and that a toggle button is depressed
        while ((!searchQuery.isEmpty()) && (btnDepressedId == null)) {
            btnDepressedId = toggleGroupBookSearch.getSelectedToggle().getUserData().toString();
            
            System.out.println(btnDepressedId);
        }
        
        System.out.println("search query>>"+searchQuery);

        if (!searchQuery.isEmpty()) {
            BookObject[] bucher = new BookObject[1000];
            JDBC_Controller socket = new JDBC_Controller();

            bucher = socket.jdbc_search_book(bucher, toggleGroupBookSearch.getSelectedToggle().getUserData().toString(), fxsearchtab_search.getText());

            if (bucher == null) {
                this.search_cloud_notification(toggleGroupBookSearch.getSelectedToggle().getUserData().toString() + ": " + fxsearchtab_search.getText());
            } else {
                System.out.println("<<<<<<hello");
                this.insert_book_entry_searchtab(bucher);
            }
            Thread.sleep(1000);
        }
    }

    ;

    @FXML
    private void switch_tab() {
        books_tab_pane.getTabs().addAll(search_tab, newsearchtext, studentsearchqueryss, teturn_tab, borrows_tabs);
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
        fx_borrowpage_isbn.setText(buchs.getISBN1());
        fx_borrowpage_description.setText(buchs.getDescription());
        fx_availability_status.setText(buchs.getStatus());
        fx_borrowpage_overview.setText(buchs.getOverview());
        fx_borrowpage_borrower.setText("");
        fx_borrowpage_school_level.setText("");
        fx_borrowpage_id.setText("");

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
                select_search_item_return();
            } else {
                popupwindow.close();
            }
        }

    }

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
    public void server_connection_issue() {

        Stage popupwindow = new Stage();

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Network Timeout");
        alert.setHeaderText("SERVER CONNECTION ISSUE");
        alert.setContentText("Your connection with the servers has been lost. Please make sure have a reliable network connection and try again. Riverting to local stored databases.");
        alert.showAndWait();
    }

    ;
    
    @FXML
    public void load_image() {
        System.out.println("hello");
        String url = "https://books.google.com.gh/books/content?id=YG9okGt4Wt4C&printsec=frontcover&img=1&zoom=1&imgtk=AFLRE70byCnPACD-0f58YqwlX2UmQudfhGYu12SOWgFaiHer6paDzpX5TB2g_8lachuu4XB5MND2zpglrJbIN3OmsOn66AC_9w3DTgw5wtVo7iQpyBoXAnVJ3kOgskojMy8kmw8nvZLz";
        String imagePath = "image1.jpeg";

        File file = new File("/Users/kwadwooteng-amoako/NetBeansProjects/UserInterface/src/userinterface/images/image2.jpeg");
        boolean backgroundLoading = true;
        Image image2 = new Image(file.toURI().toString(), backgroundLoading);

        borrow_image_box.setImage(image2);
        borrow_image_box.setPreserveRatio(true);

    }

    ;

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

}
