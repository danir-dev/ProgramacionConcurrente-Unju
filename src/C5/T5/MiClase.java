package C5.T5;

public class MiClase implements Runnable {

    Thread hilo;

    MiClase() {
        hilo = new Thread(this);
        hilo.start();
    }

    public void run() {
        // Código que se ejecutará en el hilo
        System.out.println("Hilo en ejecución");
    }
    
}
