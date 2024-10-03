package C5.T5;

public class MostrarCeroUnoHiloRunnable {
  
    public static void main(String[] args) {
      
        HiloMostrarCeroRunnable h1 = new HiloMostrarCeroRunnable();
        HiloMostrarUnoRunnable h2 = new HiloMostrarUnoRunnable(); 

    } 
  
}

class HiloMostrarCeroRunnable implements Runnable {
  
    private Thread t;
    
    public HiloMostrarCeroRunnable() {
        t = new Thread(this);
        t.start();     
    }

    @Override
    public void run() {
        for (int f = 1; f <= 1000; f++)
        System.out.print("0-");   
    } 

}

class HiloMostrarUnoRunnable implements Runnable {
  
    private Thread t;
    
    public HiloMostrarUnoRunnable() {
        t = new Thread(this);
        t.start();     
    }

    @Override
    public void run() {
        for (int f = 1; f <= 1000; f++)
        System.out.print("1-");  
    } 
  
}
   
