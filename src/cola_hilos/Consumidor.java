/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola_hilos;

/**
 *
 * @author pedro
 */
class Consumidor implements Runnable {

    private ColaLenta lacola;
   
    public Consumidor(ColaLenta lacola) {
        System.out.println("Consumidor salvaje aparecio!!");
        this.lacola = lacola;
        
    }

    @Override
    public void run() {


        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Hilo Consumidor uso Desacola -->" + lacola.Desacola());
            } catch (Exception ex) {
                System.out.println("Pero fallo!! " + ex.getMessage());
            }
        }
        System.out.println("Consumidor se ha debilitado");
    }
}