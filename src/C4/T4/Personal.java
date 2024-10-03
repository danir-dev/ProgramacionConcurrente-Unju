package C4.T4;

import java.util.logging.Level; import java.util.logging.Logger;

public class Personal extends Thread {

    private String nombre;
    private Saludo saludo;
    private boolean esJefe;

    public Personal(String nombre, Saludo saludo, boolean esJefe) {
        this.nombre = nombre;
        this.saludo = saludo;
        this.esJefe = esJefe;
    }

    @Override
    public void run() {
        System.out.println(nombre + " llegó");
        try {
            
            Thread.sleep(1000);
            if (esJefe) {   //Verifico si el personal que esta es jefe o no
                saludo.saludoJefe(nombre);
            } else {
                saludo.saludoEmpleado(nombre);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
