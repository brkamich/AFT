/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michal
 */
public class MainMenuController implements Initializable {
        @FXML
    public Button reportsChecker;
    @FXML
    private Button runAft;
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        //configureFileChooser(fileChooser);
    }

    /*
    
    
    private Stage stage;
    private final FileChooser fileChooser = new FileChooser();
 */
    /**
     * Initializes the controller class.
     */
    
 /*
    @FXML
    private void uploadFile() {
        stage = new Stage();
        List<File> list = fileChooser.showOpenMultipleDialog(stage);
        if (list != null) {
            for (File file : list) {
                System.out.println("File name: " + file.getName());
            }
        }
    }*/
    
    private static void configureFileChooser(final FileChooser fileChooser){
        fileChooser.setTitle("Upload CSV file");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All files","*.*"),
            new FileChooser.ExtensionFilter("CSV","*.CSV"));
        
    }
    
    public void changeStage(javafx.event.ActionEvent event) throws IOException{
        if(event.getSource()==runAft){
            
        }else{
            Parent parent = FXMLLoader.load(getClass().getResource("ReportsMenu.fxml"));
            Scene scene = new Scene(parent);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }

}


