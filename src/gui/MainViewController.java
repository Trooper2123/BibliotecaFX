package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
}
