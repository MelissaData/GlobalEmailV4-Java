package melissadata.globalemail.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import melissadata.globalemail.model.GlobalEmailTransaction;
import melissadata.globalemail.model.GlobalEmailOptions;
import melissadata.globalemail.Main;

public class GlobalEmailController  {

    private Main main;
    private GlobalEmailOptions option;

    private GlobalEmailTransaction Transaction;

    @FXML
    private Button buttonSend;
    @FXML
    private Button buttonClear;
    @FXML
    private TabPane tabPane;
    private final int CONFIGURATION_TAB = 0;
    private final int RESPONSE_TAB = 1;



    @FXML
    private TextField inputLicenseKeyText;
    @FXML
    private TextField inputEmailText;

    @FXML
    private ComboBox<String> optionVerifyMailboxBox;
    @FXML
    private ComboBox<String> optionDomainCorrectionBox;
    @FXML
    private ComboBox<String> optionTimeToWaitBox;

    @FXML
    private TextArea RequestTextArea;
    @FXML
    private TextArea ResponseTextArea;

    @FXML
    private RadioButton jsonResponseFormatRadio;
    @FXML
    private RadioButton xmlResponseFormatRadio;
    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public GlobalEmailController() {
        Transaction = new GlobalEmailTransaction();
        option      = new GlobalEmailOptions();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        setupOptionSelections();
        initializeFormatRadioButtons();
        initializeTextFields();
        sendButtonAction();
        clearButtonAction();
        updateRequestText();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * //@param mainApp
     */
    public void setMainApp(Main main) {
        this.main = main;
    }

    public void sendButtonAction() {
        buttonSend.setOnAction((event) -> {
            ResponseTextArea.setText(Transaction.processTransaction(RequestTextArea.getText()));
            tabPane.getSelectionModel().select(RESPONSE_TAB);
        });
    }

    public void clearButtonAction(){
        buttonClear.setOnAction((event) -> {
            inputEmailText.clear();
            returnToConfiguration();
        });
    }

    public void initializeTextFields(){
        inputLicenseKeyText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setIdentNumber(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputEmailText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setEmail(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

    }
    // Define what values each combo box can hold
    private void setupOptionSelections() {
        optionVerifyMailboxBox.setItems(FXCollections.observableArrayList("", "Express", "Premium"));
        optionDomainCorrectionBox.setItems(FXCollections.observableArrayList("", "ON", "OFF"));
        optionTimeToWaitBox.setItems(FXCollections.observableArrayList("", "5", "15", "25", "45"));
    }

    public void setOptionVerifyMailboxBox() {
        option.setOptionVerifyMailBox(optionVerifyMailboxBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }
    public void setOptionDomainCorrectionBox() {
        option.setOptionDomainCorrection(optionDomainCorrectionBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void setOptionTimeToWaitBox() {
        option.setOptionTimeToWait(optionTimeToWaitBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }


    private void initializeFormatRadioButtons(){
        jsonResponseFormatRadio.setOnAction((event) -> {
            Transaction.setFormat("JSON");
            xmlResponseFormatRadio.setSelected(false);
            updateRequestText();
        });

        xmlResponseFormatRadio.setOnAction((event) -> {
            Transaction.setFormat("XML");
            jsonResponseFormatRadio.setSelected(false);
            updateRequestText();
        });
    }

    private void returnToConfiguration(){
        if(tabPane.getSelectionModel().getSelectedIndex() != 0)	tabPane.getSelectionModel().select(CONFIGURATION_TAB);
    }

    private void updateRequestText(){
        RequestTextArea.setText(Transaction.generateRequestString());
    }

    public TextField getInputLicenseKeyText() {
        return inputLicenseKeyText;
    }

    public void setInputLicenseKeyText(TextField inputLicenseKeyText) {
        this.inputLicenseKeyText = inputLicenseKeyText;
    }

    public TextField getInputEmailText() {
        return inputEmailText;
    }

    public void setInputEmailText(TextField inputEmailText) {
        this.inputEmailText = inputEmailText;
    }

    public ComboBox<String> getOptionVerifyMailboxBox() {
        return optionVerifyMailboxBox;
    }

    public void setOptionVerifyMailboxBox(ComboBox<String> optionVerifyMailboxBox) {
        this.optionVerifyMailboxBox = optionVerifyMailboxBox;
    }

    public ComboBox<String> getOptionDomainCorrectionBox() {
        return optionDomainCorrectionBox;
    }

    public void setOptionDomainCorrectionBox(ComboBox<String> optionDomainCorrectionBox) {
        this.optionDomainCorrectionBox = optionDomainCorrectionBox;
    }

    public ComboBox<String> getOptionTimeToWaitBox() {
        return optionTimeToWaitBox;
    }

    public void setOptionTimeToWaitBox(ComboBox<String> optionTimeToWaitBox) {
        this.optionTimeToWaitBox = optionTimeToWaitBox;
    }

}
