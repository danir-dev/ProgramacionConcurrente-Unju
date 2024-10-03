package C3.T3;

public class TestDosHilos {

    public static void main (String[] args) {

        UnHilo hiloUno = new UnHilo("HiloUno");
        UnHilo hiloDos = new UnHilo("HiloDos");
        
        hiloUno.start();
        hiloDos.start();
        
        try {
        hiloUno.join();
        hiloDos.join();
        } catch (InterruptedException ie) { }
        System.out.println("El programa ha finalizado"); 

    } 

}
