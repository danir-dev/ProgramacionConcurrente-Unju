package Probando;

public class Main {

    public static void main(String[] args) {

        MiTarea1 m1 = new MiTarea1();
        Thread h1  = new Thread(m1);

        MiTarea2 m2 = new MiTarea2();
        Thread h2 = new Thread(m2);

        h1.start();
        h2.start();
        
    }

    public Object realizarTarea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'realizarTarea'");
    }

    public String obtenerContador() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerContador'");
    }

}

class MiTarea1 implements Runnable {
    public void run () {
        System.out.println("Hola, soy el hilo 1");
    }
}

class MiTarea2 implements Runnable {
    public void run () {
        System.out.println("Hola, soy el hilo 2");
    }
}
