package Probando;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main8 {

    public static void main(String[] args) {

        CyclicBarrier barrera = new CyclicBarrier(3, () -> {
            System.out.println("Todods los hilos han alcanzado la barrera");
        });

        new Thread(new Tarea(barrera, "H1")).start();
        new Thread(new Tarea(barrera, "H2")).start();
        new Thread(new Tarea(barrera, "H3")).start();
        
    }

}

class Tarea implements Runnable {

    private final CyclicBarrier barrera;
    private final String nombre;

    public Tarea (CyclicBarrier barrera, String nombre) {
        this.barrera = barrera;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        
        try {
            System.out.println(nombre + " esta realizando alguna tarea");
            Thread.sleep(2000);
            System.out.println(nombre + " ha llegado a la barrera");
            barrera.await();
            System.out.println(nombre + " continua con la siguiente tarea");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }

    

}