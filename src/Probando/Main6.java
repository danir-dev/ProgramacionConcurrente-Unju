package Probando;

class EsperandoNoti {

    public synchronized void Esperar() throws InterruptedException {
        System.out.println("Esperando...");
        wait();
        System.out.println("Liberado...");
    }

    public synchronized void Liberar() throws InterruptedException {
        System.out.println("Llegando a liberar");
        Thread.sleep(2000);
        notify();
        System.out.println("El hilo a sido liberado");
    }

}

public class Main6 {

    public static void main(String[] args) {

        EsperandoNoti en = new EsperandoNoti();

        Thread espera = new Thread(() -> {
            try {
                en.Esperar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread liberar = new Thread(() -> {
            try {
                en.Liberar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        espera.start();
        liberar.start();
        
    }

}
