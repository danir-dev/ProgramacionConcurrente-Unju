package C3.T3;

public class UnHilo extends Thread {

    public UnHilo(String nombreHilo) {
        super(nombreHilo);
    }

    public void run() {
        System.out.println(getName());
    } 

}
