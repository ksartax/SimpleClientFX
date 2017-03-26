package RMI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.control.ListView;

/**
 *
 * @author Damian Stępniak
 */
public interface RMI extends Remote {

    public LinkedList<String> get() throws RemoteException;

}
