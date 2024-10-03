package C6.P6;

import java.util.Random;
//import java.util.concurrent.Semaphore;
//Clase que simula el comportamiento de un automóvil
class Auto extends Estacionamiento implements Runnable {
    private final int idAuto;

    public Auto(int idAuto) {
        this.idAuto = idAuto;   
    }

    @Override
    public void run() {
    	try {
    		// Intentar acceder al semáforo del estacionamiento (si hay espacio disponible)
            semaforoEstacionamiento.acquire();
            // Intentar entrar al estacionamiento
            entrarEstacionamiento(idAuto);
            
            // Una vez dentro, intentar salir
            salirEstacionamiento(idAuto);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	finally {
    		// Liberar un lugar en el estacionamiento
            semaforoEstacionamiento.release();
    	}
       
    }
// Método principal
public static void main(String[] args) {
    // Crear 100 autos
    Thread[] autos = new Thread[100];
    for (int i = 0; i < 100; i++) {
        autos[i] = new Thread(new Auto(i + 1)); // Cada auto tiene un id único
        autos[i].start();

        // Simular intervalos aleatorios entre la llegada de autos
        try {
            Thread.sleep(new Random().nextInt(300) + 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Esperar a que todos los autos terminen su ejecución
    for (int i = 0; i < 100; i++) {
        try {
            autos[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println("Simulación finalizada.");
}
}

/*

Clase Auto
Propósito:
La clase Auto representa un vehículo individual que intenta entrar y salir de un estacionamiento. Cada instancia de Auto es un hilo (thread) que se ejecuta concurrentemente, simulando el comportamiento de un auto real.

Atributos:

idAuto: Un identificador único para cada auto.
Métodos:

Constructor: Inicializa el atributo idAuto.
run(): Este es el método principal de un hilo. Aquí es donde se define el comportamiento del auto:
Intentar acceder al semáforo: Al igual que en la clase Estacionamiento, se utiliza un semáforo para controlar el acceso al estacionamiento. Si hay espacio disponible, el auto puede entrar.
Entrar al estacionamiento: Llama al método entrarEstacionamiento de la clase Estacionamiento para simular la entrada del auto.
Salir del estacionamiento: Llama al método salirEstacionamiento de la clase Estacionamiento para simular la salida del auto.
Manejo de excepciones: Se utiliza un bloque try-catch para capturar posibles excepciones que puedan ocurrir durante la ejecución del hilo.
Relación con la Clase Estacionamiento
La clase Auto está estrechamente relacionada con la clase Estacionamiento. Cada auto necesita interactuar con el estacionamiento para poder entrar y salir. Los métodos entrarEstacionamiento y salirEstacionamiento de la clase Auto llaman a los métodos correspondientes de la clase Estacionamiento para realizar estas acciones.

Funcionamiento General
Creación de autos: En el método main de la clase principal (no mostrado en este fragmento), se crean múltiples instancias de la clase Auto, cada una representando un vehículo diferente.
Ejecución de hilos: Cada instancia de Auto se inicia como un hilo separado.
Concurrencia: Los hilos de los autos se ejecutan concurrentemente, compitiendo por los recursos del estacionamiento (espacios).
Sincronización: Los semáforos en la clase Estacionamiento se utilizan para sincronizar el acceso al estacionamiento, asegurando que no haya más autos de los permitidos y que los autos entren y salgan de manera ordenada.
En Resumen
La clase Auto representa la unidad básica de la simulación. Cada auto es un hilo independiente que interactúa con el estacionamiento utilizando semáforos para sincronizar su acceso. La clase Estacionamiento, por su parte, proporciona la lógica para controlar la capacidad del estacionamiento y gestionar el flujo de vehículos.

En conjunto, estas dos clases simulan un escenario real donde múltiples vehículos compiten por un espacio limitado en un estacionamiento.

 */