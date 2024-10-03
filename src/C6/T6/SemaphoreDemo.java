package C6.T6;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    Semaphore semaphore = new Semaphore(10);
    
    public void printLock() { 
        try {
            semaphore.acquire();
            System.out.println("Locks acquired");
            System.out.println("Locks remaining >> " +semaphore.availablePermits()); 
        } catch(InterruptedException ie) {  
            ie.printStackTrace(); 
        } finally {  
            semaphore.release();
            System.out.println("Locks Released"); 
            System.out.println("Locks remaining >> " +semaphore.availablePermits());
        }       

    }

    public static void main(String[] args) {  
        final SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        Thread thread = new Thread(){
    
        @Override
        public void run() {  
            semaphoreDemo.printLock(); }};
            thread.start();    
        } 

}

