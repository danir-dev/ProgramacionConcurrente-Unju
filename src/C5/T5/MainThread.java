package C5.T5;

public class MainThread {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        long initialTime = System.currentTimeMillis(); // Tiempo inicial de referencia
        CajeraThreads cajera1 = new CajeraThreads("Cajera 1", cliente1, initialTime);
        CajeraThreads cajera2 = new CajeraThreads("Cajera 2", cliente2, initialTime);
        cajera1.start();
        cajera2.start(); 
    
    }  

}
