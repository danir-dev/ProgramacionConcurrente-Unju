package C5.T5;

public class CajeraThreads extends Thread {

    private String nombre;
    private Cliente cliente;
    private long initialTime;

    // Constructor, getter & setter
    public CajeraThreads(String nombre, Cliente cliente, long initialTime) {
        super();
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime; 
    }
    
    @Override
    public void run() {

        System.out.println("La cajera " + this.nombre + " comienza a procesar la compra del cliente " + this.cliente.getNombre() + " en el tiempo: " + (System.currentTimeMillis()-this.initialTime)/1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) { 
            this.esperarXsegundos(cliente.getCarroCompra()[i]); 
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + " -> Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg"); }
            System.out.println("La cajera "+this.nombre+" TERMINO DE PROCESAR "+this.cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");  
            
    }
    
    private void esperarXsegundos(int segundos) {
            try {  
                Thread.sleep(segundos * 1000);   
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();  
            }  
    }

}
