/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cola;

import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 *
 * @author pedro
 */
public class ColaTest extends TestCase {

    public ColaTest(String testName) {
        super(testName);
    }

    /**
     * Test of GetNum method, of class Cola.
     */
    public void testGetNum() {
        System.out.println("GetNum");

        Cola instance = new Cola(3);
        try {
            instance.Acola(5);
            instance.Acola(77);
        } catch (Exception ex) {
            Logger.getLogger(ColaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        int expResult = 2;
        int result = instance.GetNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Acola method, of class Cola.
     */
    public void testAcola() throws Exception {
        System.out.println("Acola. Con la cola llena");
        Cola instance = new Cola(2);
        instance.Acola(55);
        instance.Acola(77);
        try {
            instance.Acola(99);  
            fail("Debería devolver una excepción");

        } catch (Exception ex) {
            
        }
    }

    /**
     * Test of Desacola method, of class Cola.
     */
    public void testDesacola() throws Exception {
        System.out.println("Desacola un elemento");
        Cola instance = new Cola(3);
        Object expResult = 55;
        instance.Acola(55);
        Object result = instance.Desacola();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void testDesacolavacia() throws Exception {
        System.out.println("Desacola con la cola vacia");
        Cola instance = new Cola(3);
        try {
            Object result= instance.Desacola();
            fail("Debería devolver una excepcion");
            
        }catch(Exception ex){
            
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Primero method, of class Cola.
     */
    public void testPrimero() throws Exception {
        System.out.println("Primero");
        Cola instance = new Cola(2);
        instance.Acola(55);
        Object expResult = 55;
        Object result = instance.Primero();
        assertEquals(expResult, result);
    }
}
