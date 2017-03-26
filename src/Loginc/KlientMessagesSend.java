/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loginc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Damian Stępniak
 */
public class KlientMessagesSend extends ClientCoreAbstractMessages {

    private OutputStream out;
    private String messages;

    public KlientMessagesSend(int port, String url) throws IOException{
        super(port, url);       
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
    
    public void initMessages() throws IOException{
        out = super.socket.getOutputStream();
    }

    public void sendMessages() {
        try {
            out.write(messages.getBytes());
            out.write("\n".getBytes());
        } catch (IOException ex) {
            Logger.getLogger(KlientMessagesSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessages(String text) {
        try {
            out.write(text.getBytes());
            out.write("\n".getBytes());
        } catch (IOException ex) {
            Logger.getLogger(KlientMessagesSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
