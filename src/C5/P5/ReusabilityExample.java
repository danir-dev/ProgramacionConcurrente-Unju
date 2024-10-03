package C5.P5;

import java.util.Random;

class ReusableTask implements Runnable {
    
    //probar con un PARAMETRO!!!
    //int number=1;

    // Random random = new Random();
    // int number = random.nextInt(10 - 1) + 1;

    public void run() {
        
        Random random = new Random();
        int number = random.nextInt(10 - 1) + 1;

        for (int i = 0; i < 5; i++) {
            //System.out.println("Reusable Task: " + i);
            System.out.println("Reusable Task (" + number + "): " + i);
        }
    }
}

public class ReusabilityExample {
    public static void main(String[] args) {
        ReusableTask reusableTask = new ReusableTask();

        Thread thread1 = new Thread(reusableTask);
        thread1.start();

        Thread thread2 = new Thread(reusableTask);
        thread2.start();
    }
}
