package C3.T3;

// PROGRAMA PRINCIPAL ---
public class ManejadorDeHilos {

    public static void main(String[] args) {

        unaTareaEnUnHiloa a, b;
        a = new unaTareaEnUnHiloa();
        b = new unaTareaEnUnHiloa();
        a.start();
        b.start();

    }
    
}
// FIN DEL PROGRAMA PRINCIPAL ---



// Éste es un objeto q representa 1 tarea q se ejecuta en 1 hilo

class unaTareaEnUnHiloa extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i + ", ");
        }
    }
}

/*

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

 */