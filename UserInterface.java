/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @description main start page for the script
 * @date 5 September 2019
 * @author kwadwooteng-amoako
 */
public class UserInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        //Google_Socket gs = new Google_Socket();
        //BookObject bo = gs.google_find_book("The Art of War");
        //Start the user interface
        //System.out.println(">>>>>"+bo.getBook());
        //System.out.println(">>>>>"+bo.getAuthor());
        PrinterService printerService = new PrinterService();
		

        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
