package C5.T5;

public class Principal {
    
    public static void main (String [] args) {
    
        //S crea 1único obj. tarearb q se comparte en c/thread
        TareaRb t = new TareaRb();
        // Las tareas son instancias de la clase Thread
        Thread t1 = new Thread(t,"pepe");
        Thread t2 = new Thread(t,"ana");
        Thread t3 = new Thread(t,"juan");
        // Los Threads se ponen en ejecución
        t1.start();
        t2.start();
        t3.start();  
    } 
 
}
