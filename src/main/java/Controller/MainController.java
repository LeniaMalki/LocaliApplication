package Controller;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
/**
 * The main controller in the program. Shows different pages
 *
 * @author Oscar
 */

public class MainController {

    //________________________________________________ VARIABLES _______________________________________________________
    private AnchorPane logInPage;
    private AnchorPane firstPage;
    private AnchorPane entryPage;
    private AnchorPane statisticsOverviewPage;
    private AnchorPane budgetOverviewPage;
    private AnchorPane budgetPage;
    private AnchorPane budgetCharPage;
    private AnchorPane accountPage;
    private AnchorPane goalsPage;
    private AnchorPane signUpPopUp;
    private AnchorPane deleteAccountPopUp;
    private AnchorPane changePasswordPopUp;
    private AnchorPane detailStatistics;
    private StatisticsDetailController detailStatisticsController;

    //________________________________________________ FXML ____________________________________________________________
    @FXML
    private AnchorPane mainAnchor;

    //______________________________________________ METHODS ___________________________________________________________
    public void init() {
        signUpPopUp = PaneFactory.initSignUpPopUp();
        deleteAccountPopUp = PaneFactory.initDelAccPopup();
        logInPage = PaneFactory.initLoginPane();
        firstPage = PaneFactory.initFirstPane();
        accountPage = PaneFactory.initAccountPane();
        entryPage = PaneFactory.initEntryPane();
        goalsPage = PaneFactory.initGoalsPane();
        budgetCharPage = PaneFactory.initBudgetCharPane();
        budgetPage = PaneFactory.initBudgetPane();
        statisticsOverviewPage = PaneFactory.initStatisticsOverviewPane();
        changePasswordPopUp = PaneFactory.initChangePasswordPopUp();
        PaneFactory.Pane<StatisticsDetailController> detailPane = PaneFactory.initStatisticsDetailPane();
        detailStatistics = detailPane.anchorPane;
        detailStatisticsController = detailPane.controller;
        showPage(logInPage);
    }

    void showLogInPage() {
        showPage(logInPage);
    }

    void showFirstPage() {
        showPage(firstPage);
    }

    void showAccountPage() {
        showPage(accountPage);

    }

    void showEntryPage() {
        showPage(entryPage);
    }

    void showBudgetPage() {
        showPage(budgetPage);
    }

    void showGoalsPage() {
        showPage(goalsPage);
    }


    void showStatisticsOverviewPage() {
        showPage(statisticsOverviewPage);
    }

    void showStatisticsDetailPage(String text) {
        detailStatisticsController.setLabelPieChart(text);
        showPage(detailStatistics);
    }

    void showBudgetCharPage() {
        showPage(budgetCharPage);
    }
    /**
     * A function that shows us our desired AnchorPane
     *
     * @param pane an AnchorPane that is one of our visible pages in our program
     */
    private void showPage(AnchorPane pane) {
        mainAnchor.getChildren().clear();
        mainAnchor.getChildren().add(pane);
        mainAnchor.toFront();
    }

    //____________________________________________ GETTERS / SETTERS ___________________________________________________

    AnchorPane getSignUpPopUp() {
        return signUpPopUp;
    }

    AnchorPane getLogInPage() {
        return logInPage;
    }

    AnchorPane getAccountPage() {
        return accountPage;
    }

    AnchorPane getDeleteAccountPopUp() {
        return deleteAccountPopUp;
    }

    public Node getChangePasswordPopUp() {
        return changePasswordPopUp;
    }


}


