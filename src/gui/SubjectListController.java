package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Subject;
import model.services.SubjectService;
import sample.Main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SubjectListController implements Initializable {

    private SubjectService service;

    @FXML
    private TableView<Subject> tableViewSubject;

    @FXML
    private TableColumn<Subject, Integer> tableColumnId;

    @FXML
    private TableColumn<Subject, String> tableColumnName;

    @FXML
    private Button btNew;

    private ObservableList<Subject>obsList;

    @FXML
    public void onBtNewAction(){
        System.out.println("onBtNewAction");
    }

    public void setSubjectService(SubjectService service){
        this.service = service;
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

    public void updateTableView(){
        if (service == null){
            throw new IllegalStateException("Service was null");
        }
        List<Subject> list = service.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewSubject.setItems(obsList);
    }
}
