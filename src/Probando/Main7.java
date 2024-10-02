package Probando;

import java.util.concurrent.Semaphore;

class AccesoVentanillas implements Runnable {

    private final Semaphore semaforo;
    private final int id;

    public AccesoVentanillas(Semaphore semaforo, int id){
        this.semaforo = semaforo;
        this.id = id;
    }

    @Override
    public void run() {
        
        try {
            System.out.println("Hilo " + id + " esta esperando en la fila");
            semaforo.acquire();
            System.out.println("Hilo " + id + " esta en la ventanilla");
            Thread.sleep(2000);
            System.out.println("Hilo " + id + " esta saliendo de la ventanilla");
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

public class Main7 {

    public static void main(String[] args) {
        
        Semaphore semaforo = new Semaphore(2);

        for (int i = 0; i <= 5; i++) {
            Thread t = new Thread( new AccesoVentanillas(semaforo, i) );
            t.start();
        }

    }

}

