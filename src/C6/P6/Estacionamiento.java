package C6.P6;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estacionamiento {
    // Capacidad máxima del estacionamiento
     static final int CAPACIDAD = 20;
    
    // Semáforo para controlar la cantidad de autos en el estacionamiento
    static final Semaphore semaforoEstacionamiento = new Semaphore(CAPACIDAD, true);
    
    // Semáforos para controlar las dos entradas y dos salidas
    private static final Semaphore semaforoEntrada = new Semaphore(2, true); // 2 entradas
    private static final Semaphore semaforoSalida = new Semaphore(2, true);  // 2 salidas
    
    // Simulamos la entrada de un auto al estacionamiento
    public static void entrarEstacionamiento(int idAuto) {
            // Intentar acceder a una de las entradas (si están disponibles)
            try {
            	semaforoEntrada.acquire();
                System.out.println("Auto "+ idAuto + " está entrando por una de las entradas...");
                Thread.sleep(new Random().nextInt(500) + 700); // Tiempo aleatorio en la entrada
                System.out.println("\033[32m Auto " + idAuto + " ha ingresado al estacionamiento.");
                // Simular que el auto permanece dentro del estacionamiento
                Thread.sleep(new Random().nextInt(2000) + 500); // Tiempo aleatorio de permanencia
			} catch (InterruptedException e) {
				e.printStackTrace();    
			}
            finally {
            	semaforoEntrada.release();  // Liberar la entrada
            }

    }

    // Simulamos la salida de un auto del estacionamiento
    public static void salirEstacionamiento(int idAuto) {
        	try {
        		// Intentar acceder a una de las salidas (si están disponibles)
                semaforoSalida.acquire();
                System.out.println("\033[33m Auto " + idAuto + " está saliendo por una de las salidas...");
                Thread.sleep(new Random().nextInt(500) + 700); // Tiempo aleatorio en la salida
                System.out.println(" \033[31m Auto " + idAuto + " ha salido del estacionamiento.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            finally {
            	 semaforoSalida.release();  // Liberar la salida
            }
    }
}

/*

Descripción General de la Clase
La clase Estacionamiento simula el comportamiento de un estacionamiento, controlando el flujo de entrada y salida de vehículos. Utiliza semáforos para sincronizar los hilos que representan los autos y garantizar que no se exceda la capacidad del estacionamiento.

Atributos y su Significado
CAPACIDAD: Un valor constante que define el número máximo de autos que pueden estar estacionados simultáneamente.
semaforoEstacionamiento: Un semáforo que controla la cantidad total de autos dentro del estacionamiento.
semaforoEntrada: Un semáforo que controla el acceso a las entradas del estacionamiento.
semaforoSalida: Un semáforo que controla el acceso a las salidas del estacionamiento.
Métodos y su Funcionamiento
entrarEstacionamiento(int idAuto):

Adquiere un permiso: Intenta obtener un permiso del semáforo de entrada. Si hay un espacio disponible, continúa.
Simula la entrada: Imprime un mensaje indicando que el auto está entrando por una de las entradas y simula un tiempo aleatorio para la entrada.
Simula la permanencia: Imprime un mensaje indicando que el auto ha ingresado al estacionamiento y simula un tiempo aleatorio de permanencia.
Libera la entrada: Libera el permiso del semáforo de entrada para que otro auto pueda entrar.
salirEstacionamiento(int idAuto):

Adquiere un permiso: Intenta obtener un permiso del semáforo de salida. Si hay una salida disponible, continúa.
Simula la salida: Imprime un mensaje indicando que el auto está saliendo por una de las salidas y simula un tiempo aleatorio para la salida.
Libera la salida: Libera el permiso del semáforo de salida para que otro auto pueda salir.
Funcionamiento General
Control de Capacidad: El semáforo semaforoEstacionamiento garantiza que no se exceda la capacidad máxima del estacionamiento.
Control de Entradas y Salidas: Los semáforos semaforoEntrada y semaforoSalida controlan el acceso a las entradas y salidas, evitando que múltiples autos intenten entrar o salir al mismo tiempo.
Simulación: Los métodos utilizan Thread.sleep() con tiempos aleatorios para simular las acciones de los autos (entrada, permanencia y salida).

Uso de Semáforos
Los semáforos son fundamentales para sincronizar los hilos que representan los autos. Al adquirir un permiso de un semáforo, un hilo se asegura de que tiene acceso exclusivo a un recurso (entrada o salida) y evita conflictos con otros hilos.

 */