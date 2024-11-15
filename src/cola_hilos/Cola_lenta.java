/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola_hilos;

/**
 *
 * @author pedro
 */
public class Cola_lenta implements ICola {

    private int head, tail, capacidad, numelementos;
    Object datos[];
    
    /**
     * Constructor de la clase. Inicializa la cola y los atributos de la clase.
     * 
     * @param capacidad que será la cantidad de elementos con que se inicializa
     * el vector
     * 
     */
    public Cola_lenta(int capacidad){
        datos = new Object[capacidad];
        this.capacidad=capacidad;
        numelementos=0;
        head=0;
        tail=0;
    }

    /**
     * Devuelve el número de elementos que hay en la cola 
     * 
     * @return numelementos
     */
    @Override
    public int GetNum(){
        return numelementos;
    }
    
    /**
     * Añade el elemento a la cola si no está llena
     * @param elemento que se desea acolar
     * @throws Exception si la cola está llena
     */
    @Override
    public void Acola(Object elemento) throws Exception{
        if(!colallena()){
            datos[head]=elemento;
            Thread.sleep(10);
            head=(head+1)%capacidad;
            Thread.sleep(10);
            numelementos++;
        }
        else{
            throw new Exception("COLA LLENA");
        }
    }

    /**
     * Extrae el primer elemento de la cola si existe
     * @return elemento que se extrae
     * @throws Exception si la cola está vacia
     */
    @Override
    public Object Desacola() throws Exception{
        if(!colavacia()){
            Object valor=datos[tail];
            Thread.sleep(10);
            tail=(tail+1)%capacidad;
            Thread.sleep(10);
            numelementos--;
            return valor;
        }
        else{
            throw new Exception("COLA VACIA");
        }
    }

    /**
     * Devuelve el primer elemento de la cola sin extraerlo
     * @return elemento que está el primero en la cola
     * @throws Exception si la cola está vacia
     */
    @Override
    public Object Primero() throws Exception{
        if(!colavacia()){
            return datos[tail];
        }
        else{
            throw new Exception("cola vacia");
        }
    }
    
    /**
     * Comprueba si la cola está vacia
     * @return cierto o falso
     */
    private boolean colavacia(){
        if(numelementos==0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Comprueba si la cola está llena
     * @return cierto o falso
     */
    private boolean colallena(){
        if(numelementos==capacidad){
            return true;
        }
        else{
            return false;
        }
    }
 
}
