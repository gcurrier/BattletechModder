package com.BTEditor.controller.main;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.InputStreamReader;
import java.io.Reader;

public class AboutController {
    public TextArea aboutTextArea;

    @FXML
    private void initialize() {
        aboutTextArea.setText(fileReader());
    }

    private String fileReader() {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Reader reader = new InputStreamReader(getClass().getResourceAsStream("/files/readme.txt"));
            char[] buffer = new char[512];

            for (int charsRead; (charsRead = reader.read(buffer)) != -1;) {
                stringBuilder.append(buffer, 0, charsRead);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
