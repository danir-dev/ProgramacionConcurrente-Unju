package C5.P5;

class MyThread extends Thread {

    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + i);
        }

        /*
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */

    }

}

public class Principal {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main: " + i);
        }

        /*
        for (int i = 0; i < 5; i++) {
            System.out.println("Main: " + i);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */

    }

}
