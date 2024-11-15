/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Refia Hyuga
 */
public class UsaCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ejecutando principal ....");
        Cola micola = new Cola(4);

        Random rnd = new Random();
        rnd.setSeed((new Date().getTime()));

        for (int i = 1; i < 50; i++) {
            int ale = rnd.nextInt(99);
            try {
                if (ale % 2 == 0) {
                    System.out.print("Trato de insertar " + ale + " ");
                    micola.Acola(ale);
                    System.out.println("++ Acolado el elemento " + ale + " la cola tiene " + micola.GetNum() + " elementos");
                } else {
                    System.out.print("Trato de extraer ");

                    System.out.println("-- Extraigo el elemento " + micola.Desacola() + " la cola tiene " + micola.GetNum() + " elementos");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
