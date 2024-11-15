/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola_hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */

class Productor extends Thread {

    private Cola_lenta lacola;

    public Productor(Cola_lenta lacola) {
        System.out.println("Soy el prodcutor");
        this.lacola = lacola;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            try {
                lacola.Acola(i);
            } catch (Exception ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
