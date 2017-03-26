/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewInterface;

import RMI.RMI;
import javafx.scene.control.TextArea;

/**
 *
 * @author Damian Stępniak
 */
public interface BasicConnectInterface {

    public void connect(int port, String url);

    public void close();

    public void send(String text);

    public void getRequest(TextArea textArea);

    public void setNick(String nick);
    
    public RMI geRMIClient();

}
