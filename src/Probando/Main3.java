package Probando;

public class Main3 {

    private int contador = 0;

    private final Object lock = new Object();   

    public void realizarTarea(){

        int i;
        for (i = 0; i < 1000; i++) {
            synchronized(lock) {
                contador++;     // h1 -> 19 -> 20
                                // h1 -> 19 -> 20                
            }

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

        Main3 m1 = new Main3();

        Thread t1 = new Thread( () -> m1.realizarTarea() );
        Thread t2 = new Thread( () -> m1.realizarTarea() );

        t1.start();
        t2.start();

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

        System.out.println("Contador: " + m1.obtenerContador());
        
    }

}
