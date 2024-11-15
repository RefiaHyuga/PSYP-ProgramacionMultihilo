/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola_hilos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author REFIA
 */
public class CanvasCola extends JPanel {

    private int ancho, alto, aviso = 0, head, tail, capacidad, elementos;
    private Object datos[];

    CanvasCola(int ancho, int alto) {
        this.setSize(ancho, alto);//para controlar el tamaño del applet
        this.setBackground(Color.orange);// para colorear el fondo
        this.ancho = ancho;
        this.alto = alto;
    }

    public void paint(Graphics g) {
        Image buffer = createImage(ancho, alto);
        Graphics b = buffer.getGraphics();
        b.draw3DRect(80, 150, 300, 80, true);
        b.drawRect(80, 150, 75, 80);
        b.drawRect(80, 150, 150, 80);
        b.drawRect(80, 150, 225, 80);

        Font f1 = new Font("Helvetica", Font.ITALIC + Font.BOLD, 20);

        b.setFont(f1);
        b.setColor(Color.blue);
        
        
        b.drawString("Head", 40, 120);

        switch (head) {
            case 0:
                b.fillOval(105, 100, 20, 20);
                break;
            case 1:
                b.fillOval(180, 100, 20, 20);
                break;
            case 2:
                b.fillOval(255, 100, 20, 20);
                break;
            case 3:
                b.fillOval(330, 100, 20, 20);
                break;
        }
        
        b.drawString("Tail", 40, 270);

        switch (tail) {
            case 0:
                b.fillOval(105, 250, 20, 20);
                break;
            case 1:
                b.fillOval(180, 250, 20, 20);
                break;
            case 2:
                b.fillOval(255, 250, 20, 20);
                break;
            case 3:
                b.fillOval(330, 250, 20, 20);
                break;
        }


        if (datos != null) {
            int c = 105;
            for (int i = 0; i < capacidad; i++) {
                if (((head < tail) && (head <= i && tail > i)) || ((head > tail) && (tail < i && head <=i))) {
                    b.drawString(" " + datos[i], c, 200);
                }
                else{
                    if (elementos == capacidad){
                        b.drawString(" " + datos[i], c, 200);
                    }
                    if (elementos==0){
                        aviso=2;
                    }
                }
                c = c + 75;
            }
        }

        b.drawString("ColaApplet", 200, 80);
        b.drawString("Cola LLena", 300, 300);
        b.drawString("Cola Vacia", 80, 300);
        

        if (aviso == 1) {
            b.setColor(Color.red);
            b.drawString("Cola LLena", 300, 300);
            aviso = 0;
        }
        if (aviso == 2) {
            b.setColor(Color.red);
            b.drawString("Cola Vacia", 80, 300);
            aviso = 0;
        }


        g.drawImage(buffer, 0, 0, null);
    }

    void representa(Object[] i, int h, int t, int cap, int e) {
        datos = i;
        head = t;
        tail = h;
        capacidad = cap;
        elementos = e;
        repaint();
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void avisa(boolean colallena) {
        if (colallena) {
            aviso = 1;
        } else {
            aviso = 2;
        }
        repaint();
    }
}
