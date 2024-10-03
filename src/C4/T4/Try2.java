package C4.T4;

public class Try2 {

    public static void main(String arg[]) {

        int[] array = new int[20];
        try {
            array[-3] = 24; // Aquí es donde ocurre el error
        } catch (ArrayIndexOutOfBoundsException excepcion) {
            System.out.println("Error de índice en un array");
        }
        
    }

  }
