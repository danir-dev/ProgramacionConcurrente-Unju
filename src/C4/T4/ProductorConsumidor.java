package C4.T4;

import java.util.LinkedList;

public class ProductorConsumidor {
    private LinkedList<Object> lista = new LinkedList<>();

    public synchronized void addDato(Object dato) {
        lista.add(dato);
        lista.notify(); // Despertar a un consumidor si está esperando
    }

    public synchronized Object getDato() {
        while (lista.size() == 0) {
            try {
                wait(); // Esperar si la lista está vacía
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object dato = lista.get(0);
        lista.remove(0);
        return dato;
    }

    public static void main(String[] args) {
        ProductorConsumidor pc = new ProductorConsumidor();

        // Hilo productor
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                pc.addDato(i);
                System.out.println("Productor: Añadido " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Hilo consumidor
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Object dato = pc.getDato();
                System.out.println("Consumidor: Obtenido " + dato);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
