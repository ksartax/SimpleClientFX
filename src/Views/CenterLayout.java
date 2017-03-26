/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import ViewInterface.BasicConnectInterface;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Damian Stępniak
 */
public class CenterLayout {

    private TextField textField;
    private Button send;
    private TextArea cssEditorFld;
    private Label label = new Label("    Czat Globalna    *Wiadomosc prywatna : private=Do=tresc");

    private BasicConnectInterface basicConnectInterface;

    public CenterLayout(BasicConnectInterface basicConnectInterface) {
        this.basicConnectInterface = basicConnectInterface;
    }

    public TextField getTextField() {
        textField = new TextField();
        return textField;
    }

    public TextArea getCssEditorFld() {
        cssEditorFld = new TextArea();
        cssEditorFld.setPrefRowCount(10);
        cssEditorFld.setPrefColumnCount(100);
        cssEditorFld.setWrapText(true);
        return cssEditorFld;
    }

    public GridPane addGridPane() {
        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.add(label, 0, 0);

        grid.add(getCssEditorFld(), 0, 1);
        grid.add(getTextField(), 0, 2);
        grid.add(this.send(), 0, 3);

        GridPane.setHalignment(cssEditorFld, HPos.CENTER);
        GridPane.setHalignment(send, HPos.CENTER);

        basicConnectInterface.getRequest(cssEditorFld);

        return grid;
    }

    private boolean getDataToSend() {
        if (textField.getText() == null || textField.getText().trim().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private Button send() {
        send = new Button("Wyślij");
        send.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                basicConnectInterface.send(textField.getText());
            }
        });
        return send;
    }

}
