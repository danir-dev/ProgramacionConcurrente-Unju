package C5.P5;

public class Operaciones {
    public static double sumRootN(int root) {
        double result = 0;
        for (int i = 1; i <= 1000000; i++) {
            result += Math.exp(Math.log(i) / root);
        }
        return result;
    }
}
