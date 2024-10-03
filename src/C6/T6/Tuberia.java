package C6.T6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Tuberia {
    
    class Hilo extends Thread {

        int id;

        public Hilo(int id){
            this.id=id;    
        }

        @Override
        public void run() {
            hil(id); 
        }
    }

    Semaphore guardia;
    AtomicInteger count = new AtomicInteger(0);
    
    public Tuberia(int limite){
        guardia = new Semaphore(limite, true);
    }

    public void hil (int id) {
        try {
            guardia.acquire();
        } catch (InterruptedException e) {}
        synchronized(count){
            System.out.println(String.format("Hilo %d entró (%d)", id, count.incrementAndGet()));   
        } 
        synchronized(count){
            System.out.println(String.format("Hilo %d salió (%d)", id, count.decrementAndGet()));    
        }
        guardia.release();
 
    }
    
    public void creaHilos(int num){
        
        for (int i = 1; i<=num; i++){
            new Hilo(i).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
    
    public static void main(String[] args) {
        Tuberia tub = new Tuberia(5);
        tub.creaHilos(10);
    }
    
}

