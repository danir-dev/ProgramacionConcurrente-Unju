package C4.T4;

public class Try3 {

    public static void main(String arg[]) {

        int[] array = new int[20];
        try {
            int b = 0;
            int a = 23 / b; // Aquí es donde ocurre el error, dividir entre cero
        } catch (ArrayIndexOutOfBoundsException excepcion) {
            System.out.println("Error de índice en un array");
        } catch (ArithmeticException excepcion) {
            System.out.println("Error Aritmético");
        }
        
    }

}
