package Probando;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main9 {

    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        for(int i = 0; i <= 5; i++) {
            Runnable tarea = new MiTarea("Tarea: " + i);
            executorService.execute(tarea);
        }
        
        executorService.shutdown();

    }

}

class MiTarea implements Runnable {

    private String mensaje;

    public MiTarea(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + mensaje);
    }

}

