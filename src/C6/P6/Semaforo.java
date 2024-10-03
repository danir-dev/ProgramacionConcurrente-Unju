package C6.P6;

import java.util.concurrent.Semaphore;

public class Semaforo extends Thread {

    // Se puede definir al semaforo como un atributo estatico o  se puede pasar por parametro 
    static Semaphore sem = new Semaphore(3); //probar con 1

    public void run() {
        try {
            System.out.println("Antes de dormir: " + Thread.currentThread().getName());
            sem.acquire(); // Adquiere un permiso del semáforo
            //probar 2 (no funcionara)
            //System.out.println("Permisos: " + sem.availablePermits() + ". " + Thread.currentThread().getName()); //dice cuántos hilos pueden adquirir el permiso del semáforo sin bloquearse.
            System.out.println("Me duermo: " + Thread.currentThread().getName());
            Thread.sleep(5000); // Duerme durante 5 segundos
            System.out.println("Me despierto: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release(); // Libera el permiso del semáforo, siempre se libera en finally
            //probar con 2  
        }
    }
}
