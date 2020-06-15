package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemBooks;

    @FXML
    private MenuItem menuItemSubject;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemBooksAction() {
        System.out.println("onMenuItemBooksAction");
    }

    @FXML
    public void onMenuItemSubjectAction() {
        System.out.println("onMenuItemSubjectAction");
    }

    @FXML
    public void onMenuItemAboutAction() {
        System.out.println("onMenuItemAboutAction");
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {

    }

    private void loadView(String absoluteName){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();
        }catch (IOException e){
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
