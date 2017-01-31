/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michal
 */
public class ReportsMenuController implements Initializable {

    @FXML
    private Button back;
    @FXML 
    private Button uploadCSV;
    @FXML
    private Button removeCSV;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void goToMainMenu(javafx.event.ActionEvent event) throws IOException{
            Parent parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(parent);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
    }
    
}
