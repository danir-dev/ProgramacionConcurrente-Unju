package C5.P5;

public class App {

    private CalculoConcurrente[] multiplicadores;

    public App(Matriz A, Matriz B, Matriz C) {
        multiplicadores = new CalculoConcurrente[A.rows()];
        for (int row = 0; row < A.rows(); row++) {
            multiplicadores[row] = new CalculoConcurrente(A, B, C, row);
        }
    }

    public void showMatrices(Matriz... matrices) {
        for (Matriz matrix : matrices) {
            matrix.show();
        }
    }

    public long secuencial() {
        return cronometrar(() -> {
            for (var multiplicador : multiplicadores) {
                multiplicador.run();
            }
        });
    }

    public long concurrente() {
        return cronometrar(() -> {
            Thread[] threads = new Thread[multiplicadores.length];
            for (int i = 0; i < multiplicadores.length; i++) {
                threads[i] = new Thread(multiplicadores[i]);
                threads[i].start();
            }

            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private long cronometrar(Runnable proceso) {
        long startTime = System.currentTimeMillis();
        proceso.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) throws Exception {
        // Crear matrices A, B y C con dimensiones y nombres específicos
        Matriz A = new Matriz(20, 15, "A");
        Matriz B = new Matriz(15, 20, "B");
        Matriz C = new Matriz(20, 20, "C");

        // Rellenar las matrices A y B con valores aleatorios
        A.randomize();
        B.randomize();

        // Crear una instancia de la clase App
        App app = new App(A, B, C);

        // Medir el tiempo de ejecución de las operaciones concurrentes y secuenciales
        long tiempoConcurrente = app.concurrente();
        long tiempoSecuencial = app.secuencial();

        // Mostrar las matrices resultantes
        //app.show(A, B, C);

        // Imprimir los tiempos de ejecución
        System.out.println("Tiempo secuencial: " + tiempoSecuencial + " ms");
        System.out.println("Tiempo concurrente: " + tiempoConcurrente + " ms");
    }

}
