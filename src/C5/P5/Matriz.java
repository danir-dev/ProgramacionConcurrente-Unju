package C5.P5;

import java.util.Random;
import java.util.function.Consumer;

public class Matriz {
    private String name;
    private int rows;
    private int cols;
    public final double[][] data; // Matriz bidimensional para almacenar los datos
    private int digits = 3; // Número máximo de dígitos por elemento (inicializado en 3)

    // Constructor
    public Matriz(int rows, int cols, String name) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols]; // Inicializa la matriz con las dimensiones especificadas
    }

    // Método para obtener el valor de una celda
    public double cell(int row, int col) {
        return data[row][col];
    }

    // Método para establecer el valor de una celda y actualizar el número máximo de dígitos
    public void cell(int row, int col, double val) {
        digits = Math.max(digits, String.valueOf(val).length() + 1);
        data[row][col] = val;
    }

    // Método para obtener el número de filas
    public int rows() {
        return rows;
    }

    // Método para obtener el número de columnas
    public int cols() {
        return cols;
    }

    // Método para rellenar la matriz con valores aleatorios
    public void randomize() {
        Random random = new Random();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cell(row, col, random.nextInt(16)); // Valores aleatorios entre 0 y 15
            }
        }
    }

    public void show() {
        String[] rowStrings = new String[rows];

        // Construye una cadena para cada fila de la matriz
        onRow(row -> {
            String rowString = "";
            for (int col = 0; col < cols; col++) {
                rowString += String.format("%" + digits + "d ", cell(row, col));
            }
            rowStrings[row] = rowString;
        });

        // Imprime la matriz formateada
        System.out.println("Matriz: " + name);
        System.out.println(String.join("\n", rowStrings));
    }

    private void onRow(Consumer<Integer> consumer) {
        Thread[] threads = new Thread[rows];

        // Crea un hilo para cada fila y ejecuta la función 'consumer'
        for (int i = 0; i < rows; i++) {
            int row = i; // Captura el valor de 'i' para cada hilo
            threads[i] = new Thread(() -> consumer.accept(row));
            threads[i].start();
        }

        // Espera a que todos los hilos terminen
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
