package Controller.AccountControllers;//NOPMD

import Controller.Interfaces.ControllerInterface;
import StairwayInterfaces.iAccountFacade;
import Model.AccountLogic.AccountFacade;
import View.AccountView.SignUpView;

import java.util.ArrayList;

/**
 * @author : Lenia Malki
 * Responsibility: Updates and handles the SignUpPage through the logic in AccountFacade
 * Used by: PaneFactory
 * Uses: ControllerInterface, iAccountFacade, SignUpView
 */
public class SignUpPageController implements ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________
    private final iAccountFacade accountFacade = AccountFacade.getInstance();
    private final SignUpView signUpView = SignUpView.getInstance();

    //________________________________________________ Methods _________________________________________________________
    /**
     * Constructor
     */
    public SignUpPageController() {
        setAllViewListeners();

    }

    /**
     * Sets all relevant components of the SignUpView as listeners
     */
    @Override
    public void setAllViewListeners() {
        signUpView.createAccount.setOnAction(event -> onCreateAccountClicked());
    }
    /**
     * Handles the mouse action of creating an account. The logic of creating and checking valid inputs is implemented
     * through the AccountFacade
     */
    private void onCreateAccountClicked() {
        if (areInputsMissing()) {
            signUpView.setMessage("Missing inputs!");

        } else if (accountFacade.createAccount(signUpView.signUpName.getText(), signUpView.signUpUsername.getText(),
                signUpView.signUpPassword.getText(),
                signUpView.signUpConfirmPassword.getText(),
                signUpView.signUpEmail.getText())) {
            accountFacade.notifyListeners();
            signUpView.clearTextFields();
            signUpView.setMessage("");
        } else {
            signUpView.setMessage("Invalid input(s)!");
        }
    }

    /**
     * Checks whether all fields of the sign up page are entered and none is left blank
     */
    private boolean areInputsMissing() {
        final ArrayList<String> textFieldStrings = new ArrayList<>();

        textFieldStrings.add(signUpView.signUpName.getText());
        textFieldStrings.add(signUpView.signUpUsername.getText());
        textFieldStrings.add(signUpView.signUpEmail.getText());
        textFieldStrings.add(signUpView.signUpPassword.getText());
        textFieldStrings.add(signUpView.signUpConfirmPassword.getText());


        for (final String textFieldInput : textFieldStrings) {
            if ("".equals(textFieldInput)) {
                return true;
            }
        }
        return false;
    }

}


