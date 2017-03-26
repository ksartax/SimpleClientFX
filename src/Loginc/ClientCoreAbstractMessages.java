/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loginc;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Damian Stępniak
 */
public abstract class ClientCoreAbstractMessages {

    protected Socket socket;
    protected int port;
    protected String url;

    public ClientCoreAbstractMessages(int port, String url) {
        this.port = port;
        this.url = url;
    }

    public void initConnection() throws IOException {
        socket = new Socket(url, port);
    }

    public void initConnection(int port, String url) throws IOException {
        socket = new Socket(url, port);
    }
    
    public void closeConnection() throws IOException{
        socket.close();
    }

}
