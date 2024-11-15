/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola_hilos;

/**
 *
 * @author pedro
 */
public class UsaCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ejecutando principal ....");
        Cola_lenta micola = new Cola_lenta(10);
        System.out.printf("En la cola hay %d elementos\n", micola.GetNum());

        Productor hiloproductor = new Productor(micola);
        Thread hiloconsumidor1 = new Thread(new Consumidor(micola, 1));
        Thread hiloconsumidor2 = new Thread(new Consumidor(micola, 2));

        hiloproductor.start();

        try {
            hiloproductor.join();
        } catch (Exception ex) {
            System.out.println("Capturada execpcion de join " + ex.getMessage());
        }

        hiloconsumidor1.start();
        hiloconsumidor2.start();
        try {
            hiloconsumidor1.join();
            hiloconsumidor2.join();
        } catch (Exception ex) {
            System.out.println("Capturada execpcion de join " + ex.getMessage());
        }

        System.out.printf("En la cola hay %d elementos\n", micola.GetNum());

    }
}





