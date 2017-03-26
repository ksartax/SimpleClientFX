/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewInterface;

import Loginc.KlientMessagesRequest;
import RMI.RMI;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;

/**
 *
 * @author Damian Stępniak
 */
public class ViewLogic extends KlientMessagesRequest implements BasicConnectInterface {

    protected Registry req = LocateRegistry.getRegistry("localhost", 1000);
    protected RMI rmi;
    protected Thread thread;

    public ViewLogic() throws IOException, RemoteException, NotBoundException {
        super(0, "");
        rmi = (RMI) req.lookup("server");
    }

    @Override
    public void connect(int port, String url) {
        try {
            super.initConnection(port, url);
            super.initMessages();
            thread = new Thread(this);
            thread.start();
        } catch (IOException ex) {
            Logger.getLogger(ViewLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() {
        try {
            super.sendMessages("disconect=" + "this" + "=");
            //thread.interrupt();
            //thread.destroy();
            //super.closeConnection();
        //} //catch (IOException ex) {
         //   Logger.getLogger(ViewLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

        }
    }

    @Override
    public void send(String text) {
        super.sendMessages(text);
    }

    @Override
    public void getRequest(TextArea textArea) {
        super.setAreaText(textArea);
    }

    @Override
    public void setNick(String nick) {
        super.sendMessages("newNick=" + nick + "=");
    }

    @Override
    public RMI geRMIClient() {
        return this.rmi;
    }

}
