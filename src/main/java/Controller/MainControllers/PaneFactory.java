package Controller.MainControllers;

import Controller.AccountControllers.*;
import Controller.BudgetControllers.BudgetCharPageController;
import Controller.BudgetControllers.BudgetPageController;
import Controller.EntryControllers.EntryPageController;
import Controller.GoalsControllers.GoalsPageController;
import Controller.StatisticsController.StatisticsDetailController;
import Controller.StatisticsController.StatisticsOverViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


/**
 * A class that works as a factory for all the panes
 *
 * @author Oscar
 */
public class PaneFactory {

    //________________________________________________ VARIABLES _______________________________________________________

    private static MainController parent;

    //___________________________________-_____________ METHODS _______________________________________________________-

    /**
     * A generalized function for fetching root and controller from a function
     *
     * @param path a path to desired fxml
     */
    private static <T> Pane<T> loadInPane(String path) {
        Pane<T> pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PaneFactory.class.getClassLoader().getResource(path));
            AnchorPane anchorPane = fxmlLoader.load();
            T controller = fxmlLoader.getController();
            pane = new Pane<T>(anchorPane, controller);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return pane;
    }

    /**
     * Down below are similar functions that loads in different panes using fxml files
     */
    public static Parent initMain() {   //TODO PUBLIC????
        Pane<MainController> pane = loadInPane("org/openjfx/mainAnchor.fxml");
        PaneFactory.parent = pane.controller;
        pane.controller.init();
        return pane.anchorPane;
    }

    public static AnchorPane initHeader() {  //TODO PUBLIC????
        Pane<HeaderController> pane = loadInPane("org/openjfx/header.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initLoginPane() {
        Pane<LogInPageController> pane = loadInPane("org/openjfx/logInPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initFirstPane() {
        Pane<FirstPageController> pane = loadInPane("org/openjfx/firstPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initAccountPane() {
        Pane<AccountPageController> pane = loadInPane("org/openjfx/accountPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }


    static AnchorPane initBudgetPane() {
        Pane<BudgetPageController> pane = loadInPane("org/openjfx/budgetPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initSignUpPopUp() {
        Pane<SignUpPageController> pane = loadInPane("org/openjfx/signUpPopUp.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initBudgetCharPane() {
        Pane<BudgetCharPageController> pane = loadInPane("org/openjfx/budgetCharPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initEntryPane() {
        Pane<EntryPageController> pane = loadInPane("org/openjfx/entryPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initStatisticsOverviewPane() {
        Pane<StatisticsOverViewController> pane = loadInPane("org/openjfx/statisticsOverviewPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initGoalsPane() {
        Pane<GoalsPageController> pane = loadInPane("org/openjfx/goalsPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static Pane<StatisticsDetailController> initStatisticsDetailPane() {
        Pane<StatisticsDetailController> pane = loadInPane("org/openjfx/statisticsDetailPage.fxml");
        pane.controller.initPane(parent);
        return pane;
    }

    static AnchorPane initDelAccPopup() {
        Pane<DeleteAccountPopUpController> pane = loadInPane("org/openjfx/deleteAccountPopUp.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initChangePasswordPopUp() {
        Pane<ChangePasswordPopUpController> pane = loadInPane("org/openjfx/changePasswordPopUp.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    /**
     * A private class that let us store controllers and anchor panes as one.
     */
    static class Pane<T> {
        AnchorPane anchorPane;
        T controller;

        Pane(AnchorPane anchorPane, T controller) {
            this.anchorPane = anchorPane;
            this.controller = controller;
        }
    }
}