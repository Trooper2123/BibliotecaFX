package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Subject;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class SubjectListController implements Initializable {

    @FXML
    private TableView<Subject> tableViewSubject;

    @FXML
    private TableColumn<Subject, Integer> tableColumnId;

    @FXML
    private TableColumn<Subject, String> tableColumnName;

    @FXML
    private Button btNew;

    @FXML
    public void onBtNewAction(){
        System.out.println("onBtNewAction");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNode();
    }

    private void initializeNode(){
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new  PropertyValueFactory<>("name"));

        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewSubject.prefHeightProperty().bind(stage.heightProperty());


    }
}
