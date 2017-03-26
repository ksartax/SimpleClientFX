/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Damian Stępniak
 */
public class BorderPanel {
    
    private BorderPane panel;
    
    public BorderPanel() {
        panel = new BorderPane();
    }
    
    public BorderPane getPanel() {
        return panel;
    }
    
    public void setTop(Object o) {
        panel.setTop((Node) o);
    }
    
    public void setBottom(Object o) {
        panel.setBottom((Node) o);
    }
    
    public void setLeft(Object o) {
        panel.setLeft((Node) o);
    }
    
    public void setRight(Object o) {
        panel.setRight((Node) o);
    }
    
    public void setCeter(Object o) {
        panel.setCenter((Node) o);
    }
}
