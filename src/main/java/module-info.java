module com.example.languagetest {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.languagetest to javafx.fxml;
    exports com.example.languagetest;
}