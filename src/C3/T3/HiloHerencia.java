package C3.T3;

public class HiloHerencia extends Thread {

    public static void main(String[] args) {
        HiloHerencia hilo = new HiloHerencia();
        hilo.setName("un hilo que hereda de Thread.");
        hilo.start();
    }

    public void run() {
        System.out.println("Soy " + getName() + " Hola mundo!!!");
    }

}
