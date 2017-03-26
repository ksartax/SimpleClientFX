/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import ViewInterface.BasicConnectInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Damian Stępniak
 */
public class TopLayout {

    private LeftLayout layout;
    private BorderPane pane;
    private Button startServer;
    private TextField port;
    private TextField url;
    private Label urlLabel;
    private Button stopServer;
    private Button setName;
    private BasicConnectInterface basicConnectInterface;
    private TextField nick;
    private Label nicLabel;

    public TextField getNickField() {
        nick = new TextField();
        nick.setPrefSize(100, 20);
        return nick;
    }

    public Label getNicLabel() {
        nicLabel = new Label("Nick : ");
        nicLabel.setPrefSize(40, 20);
        nicLabel.setStyle("-fx-text-fill: #ffffff;");
        return nicLabel;
    }

    public TopLayout(BasicConnectInterface basicConnectInterface, LeftLayout layout) {
        this.layout = layout;
        this.basicConnectInterface = basicConnectInterface;
        pane = new BorderPane();
        pane.setRight(this.topRightBox());
        pane.setLeft(this.topLeftBox());
        pane.setStyle("-fx-background-color: #000000;");
    }

    private int getPortNr() {
        return Integer.valueOf(port.getText());
    }

    private String getNick() {
        return nick.getText();
    }

    private String getUrl() {
        return url.getText();
    }

    public BorderPane getPanel() {
        return pane;
    }

    private Button startButton() {
        startServer = new Button("Start");
        startServer.setPrefSize(100, 20);
        startServer.setStyle("-fx-background-color: #d6d6c2;");
        startServer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    basicConnectInterface.connect(getPortNr(), getUrl());
                    basicConnectInterface.setNick(getNick());
                    layout.start();

                    System.out.println("Połączono : " + getPortNr());

                    //stopServer.setDisable(false);
                    port.setStyle("-fx-background-color: #ffffff;");
                    // port.setDisable(true);
                    startServer.setStyle("-fx-background-color: #ffff33;");
                    //startServer.setDisable(true);
                    stopServer.setStyle("-fx-background-color: #d6d6c2;");

                } catch (NullPointerException e) {
                    port.setStyle("-fx-background-color: #ff6666;");
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } catch (NumberFormatException e) {
                    port.setStyle("-fx-background-color: #ff6666;");
                    JOptionPane.showMessageDialog(null, "Port : nie poprawne dane");
                } catch (Exception e) {
                    startServer.setStyle("-fx-background-color: #ffff33;");
                    //startServer.setDisable(true);
                    stopServer.setStyle("-fx-background-color: #d6d6c2;");
                }
            }
        });
        return startServer;
    }

    private Button stopButton() {

        stopServer = new Button("Stop");
        stopServer.setPrefSize(100, 20);
        stopServer.setStyle("-fx-background-color: #d6d6c2;");
        // stopServer.setDisable(true);
        stopServer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                basicConnectInterface.close();

                //startServer.setDisable(false);
                //stopServer.setDisable(true);
                // port.setDisable(false);
                startServer.setStyle("-fx-background-color: #d6d6c2;");
                stopServer.setStyle("-fx-background-color: #ffff33;");
                System.out.println("Server Stop");
            }
        });
        return stopServer;
    }

    private Button newName() {
        setName = new Button("Ustaw nick");
        setName.setPrefSize(100, 20);
        setName.setStyle("-fx-background-color: #d6d6c2;");
        setName.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                basicConnectInterface.setNick(getNick());
            }
        });
        return setName;
    }

    private TextField portTextField() {
        port = new TextField();
        port.setPrefSize(80, 20);
        return port;
    }

    private Label portLabel() {
        Label portLabel = new Label("Nr portu : ");
        portLabel.setPrefSize(60, 20);
        portLabel.setStyle("-fx-text-fill: #ffffff;");
        return portLabel;
    }

    private TextField urlTextField() {
        url = new TextField();
        url.setPrefSize(80, 20);
        return url;
    }

    private Label urlLabel() {
        urlLabel = new Label("Adres url : ");
        urlLabel.setPrefSize(60, 20);
        urlLabel.setStyle("-fx-text-fill: #ffffff;");
        return urlLabel;
    }

    private HBox topLeftBox() {
        HBox hboxLeft = new HBox();
        hboxLeft.setPadding(new Insets(15, 12, 15, 12));
        hboxLeft.setSpacing(10);
        hboxLeft.setStyle("-fx-background-color: #000000;");

        hboxLeft.getChildren().addAll(this.startButton(), this.stopButton());
        return hboxLeft;
    }

    private HBox topRightBox() {
        HBox hboxRight = new HBox();
        hboxRight.setPadding(new Insets(15, 12, 15, 12));
        hboxRight.setSpacing(10);
        hboxRight.setStyle("-fx-background-color: #000000;");

        hboxRight.getChildren().addAll(this.newName(), this.getNickField(), this.urlLabel(), this.urlTextField(), this.portLabel(), this.portTextField());
        return hboxRight;
    }

}
