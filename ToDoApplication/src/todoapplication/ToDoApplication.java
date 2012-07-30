/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapplication;

import controller.TelaPrincipalController;
import javax.swing.JOptionPane;
import view.TelaPrincipal;

/**
 *
 * @author petcomp
 */
public class ToDoApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TelaPrincipal telaPrincipal = new TelaPrincipal();
       telaPrincipal.setVisible(true);
    }
}
