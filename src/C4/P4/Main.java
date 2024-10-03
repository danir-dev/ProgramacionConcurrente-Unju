package C4.P4;

public class Main {

    static class Timbre {

        public void timbre(int numero) {

            try {
                System.out.println("Visitante " + numero + ", llegando al timbre");
                Thread.sleep(1500);
                System.out.println("Visitante " + numero + ", llegó");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized(this) {

                System.out.println("Ding (" + numero + ") ...");

                try {
                    Thread.sleep(1500);
                    System.out.println("Dong (" + numero + ")");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            try {
                System.out.println("Visitante " + numero + ", se está retirando");
                Thread.sleep(1500);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        //     try {
        //         System.out.println("Visitante " + numero + ", llegando al timbre");
        //         Thread.sleep(1500);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }

        //     System.out.println("Ding (" + numero + ") ...");

        //     try {
        //         Thread.sleep(1500);
        //         System.out.println("Dong (" + numero + ")");
        //     } catch (InterruptedException e) {   
        //         e.printStackTrace();
        //     }

        // }

        // public void timbre(int numero) {

        //     synchronized(this) {

        //         System.out.println("Ding (" + numero + ") ...");

        //         try {
        //             Thread.sleep(1500);
        //             System.out.println("Dong (" + numero + ")");
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }

        //     }

        // }

    }

    static class Visitante extends Thread {
    
        Timbre t;
        int numero;

        public Visitante(Timbre t, int numero) {
            this.t = t;
            this.numero = numero;
        }

        public void run() {
            t.timbre(numero);
        }
        
    }

    public static void main(String[] args) {

        Timbre t = new Timbre();
        Visitante v1 = new Visitante(t, 1);
        Visitante v2 = new Visitante(t, 2);
        Visitante v3 = new Visitante(t, 3);
        v1.start();
        v2.start();
        v3.start();
        
    }

}
