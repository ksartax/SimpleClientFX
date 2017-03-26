/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import ViewInterface.BasicConnectInterface;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Damian Stępniak
 */
public class LeftLayout extends Thread {

    private ListView listView;
    private BasicConnectInterface basicConnectInterface;

    public LeftLayout(BasicConnectInterface basicConnectInterface) {
        this.basicConnectInterface = basicConnectInterface;
    }

    public VBox addVBox() throws RemoteException {
        listView = new ListView();
        listView.setPrefSize(226, 550);
        VBox vbox = new VBox(listView);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        return vbox;
    }

    public void setData(String name) {
        listView.getItems().add(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.print("");
                try {
                    this.sleep(5000);
                    //if (basicConnectInterface.geRMIClient().get().size() != listView.getItems().size()) {
                    listView.getItems().clear();
                    for (String clientThrow : basicConnectInterface.geRMIClient().get()) {
                        setData(clientThrow);
                    }
                    // }
                } catch (NullPointerException e) {
                    System.err.print("");
                } catch (InterruptedException ex) {
                    Logger.getLogger(LeftLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(LeftLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
