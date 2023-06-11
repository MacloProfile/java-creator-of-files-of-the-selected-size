package com.example.languagetest;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField copies;

    @FXML
    private CheckBox gbyte;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //create button
    @FXML
    private Button intel;

    @FXML
    private CheckBox byteOne;

    @FXML
    private TextField filePath;

    @FXML
    private CheckBox kilobyte;

    @FXML
    private CheckBox megabyte;

    @FXML
    private TextField sizeFile;

    @FXML
    private TextField nameOfFile;

    @FXML
    private TextArea outputTable;

    @FXML
    void initialize() {
        assert intel != null : "fx:id=\"intel\" was not injected: check your FXML file 'hello-view.fxml'.";
        AtomicReference<String> t = new AtomicReference<>();
        intel.setOnAction(event -> {
            AddSizeForFinalFile sizeForFinalFile = new AddSizeForFinalFile(sizeFile.getText(), filePath.getText(),
                    getCheckBox(), nameOfFile.getText(), copies.getText());
            outputTable.setText(sizeForFinalFile.startAll());
        });
    }
    //which checkbox the user selected
    private int getCheckBox() {
        if (byteOne.isSelected())
            return 1;
        if (kilobyte.isSelected())
            return 2;
        if (megabyte.isSelected())
            return 3;
        if (gbyte.isSelected())
            return 4;
        return 0;
    }
}
