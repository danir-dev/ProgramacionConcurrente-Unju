package C5.P5;

class SharedResourceTask implements Runnable {
    private int sharedValue = 0;

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + (++sharedValue));
        }
    }
}

public class ResourceSharingExample {
    public static void main(String[] args) {

        SharedResourceTask sharedTask = new SharedResourceTask();
        //SharedResourceTask sharedTask2 = new SharedResourceTask();

        Thread thread1 = new Thread(sharedTask);
        thread1.start();

        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        Thread thread2 = new Thread(sharedTask);
        thread2.start();

        //Thread thread2 = new Thread(sharedTask);
        //thread2.start();

    }
}
