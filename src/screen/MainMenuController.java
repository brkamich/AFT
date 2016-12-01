/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Button uploadCSV;
    @FXML
    private Button removeCSV;
    @FXML
    private Button graphs;
    private Stage stage;
    private final FileChooser fileChooser = new FileChooser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configureFileChooser(fileChooser);
    }

    @FXML
    private void uploadFile() {
        stage = new Stage();
        List<File> list = fileChooser.showOpenMultipleDialog(stage);
        if (list != null) {
            for (File file : list) {
                System.out.println("File name: " + file.getName());
            }
        }
    }
    
    private static void configureFileChooser(final FileChooser fileChooser){
        fileChooser.setTitle("Upload CSV file");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All files","*.*"),
            new FileChooser.ExtensionFilter("CSV","*.CSV"));
        
    }

}
