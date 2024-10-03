package C5.T5;

public class MostrarCeroUno {

    public void mostrar0() {
        for (int f = 1; f <= 1000; f++)
        System.out.print("0-");
    }

    public void mostrar1() {
        for (int f = 1; f <= 1000; f++)
        System.out.print("1-");
    }

    public static void main(String[] args) {
        MostrarCeroUno m=new MostrarCeroUno();
        m.mostrar0();
        m.mostrar1();
    }
    
}
