package C5.T5;

public class TareaRb implements Runnable {
    
    public void run() {

        for (int i=1; i<=100; i++) {
            System.out.println("Nombre " + Thread.currentThread().getName());
            try { 
                Thread.sleep(100); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            }  
        }  
        
    }  

}
