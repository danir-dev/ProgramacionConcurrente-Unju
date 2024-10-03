package C3.P3;

public class Main2 {

    public static void main(String[] args) {
        
        long inicio, fin;

        inicio = System.currentTimeMillis();

        Thread misHilosX[] = new Thread[10];
        Thread misHilosY[] = new Thread[10];    

        for (int i = 0; i < 10; i++) {

            misHilosX[i] = new Thread(new PrintX(i));
            misHilosX[i].start();
            try {
                misHilosX[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }

            misHilosY[i] = new Thread(new PrintY(i));
            misHilosY[i].start();
            try {
                misHilosY[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("");

        }

        for (int i = 0; i < misHilosY.length; i++) {
            try {
                misHilosX[i].join();
                misHilosY[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */

        fin = System.currentTimeMillis();

        System.out.println("");
        System.out.println("Total ejecución: " + (fin-inicio));

    }

}
