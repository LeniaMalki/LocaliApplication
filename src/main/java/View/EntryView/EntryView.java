package View.EntryView;

import View.Interfaces.iPane;
import Service.PaneFactory;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 * @author : Artin Abiri
 * Responsibility: In charge of showing entries
 * Used by: PaneFactory, EntryPageController
 * Uses: JavaFX, iPane, MainView
 */
public class EntryView implements iPane {

    //________________________________________________ VARIABLES _______________________________________________________

    @FXML
    public Button submitButton;
    @FXML
    public Button addButton;
    @FXML
    public Button expencesButton;
    @FXML
    public Button incomebutton;
    @FXML
    public Button savingButton;
    @FXML
    public TextField nameTextField;
    @FXML
    public ComboBox<String> categoryComboBox;
    @FXML
    public TextField costTextField;
    @FXML
    public ScrollPane entryPageScrollPane;
    @FXML
    public FlowPane entryFlowPlane;
    @FXML
    public AnchorPane headerAnchorPane;

    private MainView parent;
    static EntryView entryView;

    //______________________________________________ METHODS ___________________________________________________________

    /**
     * Constructor
     */
    public EntryView() {
        entryView = this;
    }

    /**
     * Method for obtaining the EntryView instance. Handles the creation of a new account object.
     */
    public static EntryView getInstance() {
        if (entryView == null) {
            entryView = new EntryView();
        }
        return entryView;
    }
    /**
     * Method that initializes pane and sets header
     * @param parent a MainView
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
    /**
     * Method that hides the income category
     */
    public void hideIncomeCategory() {
        categoryComboBox.setVisible(false);
        costTextField.setLayoutY(282);
    }
    /**
     * Method that shows the category
     */
    public void showCategory() {
        entryView.categoryComboBox.setVisible(true);
        entryView.costTextField.setLayoutY(391);
    }
    /**
     * Method that sets textfield to red
     */
    public void setRedColor(final TextField textField) {
        textField.setStyle(" -fx-border-color: Red;");
    }
    /**
     * Method that sets textfield to grey
     */
    public void setGreyColor(final TextField textField) {
        textField.setStyle(" -fx-border-color: Grey;");
    }
    /**
     * Method that sets combobox to red
     */
    public void setRedColor(final ComboBox<String> categoryComboBox) {
        categoryComboBox.setStyle(" -fx-border-color: Red;");
    }
    /**
     * Method that sets combobox to grey
     */
    public void setGreyColor(final ComboBox<String> categoryComboBox) {
        categoryComboBox.setStyle(" -fx-border-color: Grey;");
    }
}
