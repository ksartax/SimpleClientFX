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
import javafx.scene.control.TextArea;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Damian Stępniak
 */
public class KlientMessagesRequest extends KlientMessagesSend implements Runnable {

    private InputStream in;
    private String tekst;
    private TextArea areaText;

    public KlientMessagesRequest(int port, String url) throws IOException {
        super(port, url);
    }

    public void setAreaText(TextArea areaText) {
        this.areaText = areaText;
    }

    @Override
    public void run() {
        try {
            in = super.socket.getInputStream();
            while (true) {
                this.setRequestData();
            }
        } catch (IOException ex) {
            Logger.getLogger(KlientMessagesRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KlientMessagesRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setRequestData() throws Exception {
        int k;
        tekst = "";
        while ((k = in.read()) != -1 && k != '\n') {
            tekst = tekst + (char) k;
        }
        this.areaText.setText(this.areaText.getText() + tekst + "\t\n");
    }

    public String getTekst() {
        return tekst;
    }

}
