package Probando;

//import java.util.concurrent.locks.ReentrantLock;

public class Main5 {

    private int contador = 0;

    //private ReentrantLock lock = new ReentrantLock();  

    public synchronized void realizarTarea(){

        int i;
        for (i = 0; i < 1000; i++) {

            contador++;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public int obtenerContador(){
        return contador;
    }

    public static void main(String[] args) {

        Main5 m1 = new Main5();

        Thread t1 = new Thread( () -> m1.realizarTarea() );
        Thread t2 = new Thread( () -> m1.realizarTarea() );
        //Thread t3 = new Thread( () -> m1.realizarTarea() );

        t1.start();
        t2.start();
        //t3.start();

        // try {
        //     t1.join();
        //     t2.join();
        //     t3.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // try {
        //     t3.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        System.out.println("Contador: " + m1.obtenerContador());
        
    }

}

