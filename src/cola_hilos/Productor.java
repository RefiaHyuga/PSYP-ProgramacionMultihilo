/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola_hilos;

/**
 *
 * @author pedro
 */

class Productor extends Thread {

    private ColaLenta lacola;

    public Productor(ColaLenta lacola) {
        System.out.println("Prodcutor salvaje aparecio!!");
        this.lacola = lacola;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Hilo productor uso Acolar --> "+i);
                lacola.Acola(i);
            } catch (Exception ex) {
                System.out.println("Pero fallo "+ex.getMessage());
            }
        }
        System.out.println("Productor se ha debilitado");
    }
}
