package C6.P6;

public class Principal {

    //Semaforo como atributo

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Semaforo sem = new Semaforo();
            sem.start();
        }
    }

    //Semaforo como parametro
    /*

    public static void main(String[] args) {
        Semaforo sem0 = new Semaforo(3);
        for (int i = 0; i < 10; i++) {
            Semaforo sem = new Semaforo(sem0);
            sem.start();
        }
    }

     */

}
