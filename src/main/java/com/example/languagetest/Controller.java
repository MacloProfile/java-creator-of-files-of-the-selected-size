package com.example.languagetest;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller {

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
    void initialize() {
        assert intel != null : "fx:id=\"intel\" was not injected: check your FXML file 'hello-view.fxml'.";
        AtomicReference<String> t = new AtomicReference<>();
        intel.setOnAction(event -> {
            AddSizeForFinalFile sizeForFinalFile = new AddSizeForFinalFile(sizeFile.getText(), filePath.getText(),
                    getCheckBox());
            sizeForFinalFile.startAll();
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
        return 0;
    }
}
