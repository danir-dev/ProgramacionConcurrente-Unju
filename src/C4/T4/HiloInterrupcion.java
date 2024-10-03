package C4.T4;

import java.util.concurrent.TimeUnit;

public class HiloInterrupcion {

    public static void main(String[] args) {
        HiloEsperador hiloEsperador = new HiloEsperador();
        Thread hilo = new Thread(hiloEsperador);
        hilo.start();

        try {
            // Simulamos que pasa un tiempo
            TimeUnit.SECONDS.sleep(2);

            // Interrumpimos el hilo
            hilo.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class HiloEsperador implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                try {
                    System.out.println("Hilo esperando...");
                    wait(); // El hilo se bloquea aquí
                    System.out.println("Hilo despertado");
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                    // Aquí puedes realizar alguna acción cuando el hilo es interrumpido
                }
            }
        }
    }
}
