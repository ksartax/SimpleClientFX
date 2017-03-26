package Views;

import ViewInterface.BasicConnectInterface;
import ViewInterface.ViewLogic;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Damian Stępniak
 */
public class main extends Application {

    private BorderPanel panel;
    private BasicConnectInterface basicConnectInterface;

    @Override
    public void start(Stage primaryStage) throws RemoteException, NotBoundException {

        try {
            basicConnectInterface = new ViewLogic();

            LeftLayout layout = new LeftLayout(basicConnectInterface);

            panel = new BorderPanel();
            panel.setTop(new TopLayout(basicConnectInterface, layout).getPanel());
            panel.setLeft(layout.addVBox());
            panel.setCeter(new CenterLayout(basicConnectInterface).addGridPane());

            Scene scene = new Scene(panel.getPanel(), 750, 550);

            primaryStage.setTitle("Client");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
