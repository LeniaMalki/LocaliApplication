package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class firstPageController implements Initializable {

    @FXML
    private Button newEntryButton;

    @FXML
    private Button newBudgetButton;

    @FXML
    private AnchorPane headerAnchorPane;


    @FXML
    private void loadEntryPage(ActionEvent event) throws IOException {

        Parent startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/entryPage.fxml"));
        Scene startScene = new Scene(startParent);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();
    }

    //Takes user to from firstPage --> budgetPage when clicking on "New Budget"
    @FXML
    private void onAction_loadBudgetPage_CLICKED(ActionEvent event) throws IOException {

        Parent startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/budgetPage.fxml"));
        Scene startScene = new Scene(startParent);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();
    }

    //Loads the default header header.fxml and anchors it to top of page
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/header.fxml"));
            headerAnchorPane.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
