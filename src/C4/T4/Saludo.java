package C4.T4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Saludo {
    
    public Saludo(){ }
    /* 
    Si no es jefe, el empleado va a quedar esperando a q llegue el jefe. Se hace wait de el 
    hilo q está corriendo y se bloquea, hasta q s le avise q ya puede saludar
    */

    public synchronized void saludoEmpleado(String nombre){
        try {
            wait();
            System.out.println("\n"+nombre.toUpperCase() + "-: Buenos días jefe.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Saludo.class.getName()).log(Level.SEVERE, null, ex);  
        }  
    }

    //Si es jefe, saluda y luego avisa a los empleados p/q saluden
    // El notifyAll despierta a todos los hilos que estén bloqueados
    public synchronized void saludoJefe(String nombre){
        System.out.println("\n****** "+nombre + "-: Buenos días empleados. ******");
        notifyAll();
    }    

}
