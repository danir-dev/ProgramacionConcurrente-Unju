package C3.T3;

public class TestHiloContador {
    public static void main(String[] args) {

        Contador cont = new Contador();
        HiloContador hc1 = new HiloContador("Hilo Uno", cont);
        HiloContador hc2 = new HiloContador("Hilo Dos", cont);
        hc1.start();
        hc2.start();
        try{ 
            hc1.join();
            hc2.join();
        } catch (InterruptedException e) {
            System.out.println("Error al ejecutar el método join"); 
        }
        System.out.println("El último valor que debe mostrarse es 10*2=20"); 
   
    } 

}
