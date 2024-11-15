/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola_hilos;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author REFIA
 */
public class ColaApplet extends JFrame {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    private Productor p;
    private Consumidor c;
    private Thread h;

    public void init() {
        // TODO start asynchronous download of heavy resources
        this.setSize(500, 500);//para controlar el tamaño del applet
        this.setBackground(Color.red);// para colorear el fondo
        CanvasCola canv = new CanvasCola(500, 500);
        add(canv);//para que salga en el applet
        ColaLenta d = new ColaLenta(4, canv);
        p = new Productor(d);
        c = new Consumidor(d);
        h = new Thread(c);


    }

    public void start() {
        p.start();
        h.start();
    }

    public void stop() {
        p.interrupt();
        h.interrupt();
    }
}
