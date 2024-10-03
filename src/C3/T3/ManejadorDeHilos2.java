package C3.T3;

public class ManejadorDeHilos2 {
    public static void main(String[] args) {
        
        unaTareaEnUnHilob a, b, c, d;
        a = new unaTareaEnUnHilob();
        b = new unaTareaEnUnHilob();
        c = new unaTareaEnUnHilob();
        d = new unaTareaEnUnHilob();
        a.start();
        b.start();
        c.start();
        d.start();
    }
    
}

class unaTareaEnUnHilob extends Thread {
    public void run() {
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000000; j++) {
                for (int k = 0; k < 100000000; k++) {
                    for (int l = 0; l < 100000000; l++) {
                    }
                }
            }
        }
    }
}
    