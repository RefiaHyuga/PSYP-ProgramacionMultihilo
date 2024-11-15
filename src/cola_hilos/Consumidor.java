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

    private Cola_lenta lacola;
    private int num;

    public Consumidor(Cola_lenta lacola, int num) {
        System.out.println("Soy el consumidor " + num);
        this.lacola = lacola;
        this.num = num;
    }

    @Override
    public void run() {


        for (int i = 1; i <= 10; i++) {
            try {
                System.out.printf("Hilo %d Extraigo %d\n", num, lacola.Desacola());
            } catch (Exception ex) {
                System.out.println("Hilo " + num + " " + ex.getMessage());
            }
        }
    }
}