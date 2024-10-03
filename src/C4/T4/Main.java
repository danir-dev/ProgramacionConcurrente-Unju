package C4.T4;

public class Main {

    public static void main(String[] args) {
        
        Saludo saludo = new Saludo();    // Objeto en común, se encarga del wait y notify
        
        // Creación de hilos para el jefe y los empleados
        Personal Empleado1 = new Personal("Pepe", saludo, false);
        Personal Empleado2 = new Personal("José", saludo, false);
        Personal Empleado3 = new Personal("Pedro", saludo, false);
        Personal Jefe1 = new Personal("JEFE", saludo, true);

         /*
            Instancio los hilos y paso como parámetros:
            Nombre del Hilo
            Objeto en común (Saludo)
            Booleano p/verificar si es jefe o empleado  
        */ 
        
        // Inicio de los hilos
        Empleado1.start();
        Empleado2.start();
        Empleado3.start();
        Jefe1.start();

    }

}
