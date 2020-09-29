package controllers;

import Model.AccountHandler;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignUpPageController {

    public AnchorPane signUpPopUp;
    MainController parent;

    User user = User.getInstance();

    @FXML
    private TextField signUpName;
    @FXML
    private TextField signUpUsername;
    @FXML
    private PasswordField signUpPassword;
    @FXML
    private PasswordField signUpConfirmPassword;
    @FXML
    private TextField signUpEmail;
    @FXML
    private Button createAccount;


    public void initPane(MainController parent) {
        this.parent = parent;
    }

    @FXML
    private void handleCreateAccountAction(ActionEvent event) {

        AccountHandler accountHandler = new AccountHandler() {
            @Override
            public User createUser(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                                   TextField signUpPassword, TextField signUpConfirmPassword) {
                return super.createUser(signUpName, signUpUsername, signUpEmail, signUpPassword, signUpConfirmPassword);
            }
        };

        if (accountHandler.createUser(signUpName, signUpUsername, signUpEmail, signUpPassword, signUpConfirmPassword) != null) {
            user.notifyListeners();
            clearTextFields();

        } else System.out.println("Invalid user inputs! ");

    }


    private void clearTextFields() {

        signUpName.clear();
        signUpEmail.clear();
        signUpPassword.clear();
        signUpConfirmPassword.clear();

    }


}


