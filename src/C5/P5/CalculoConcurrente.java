package C5.P5;

public class CalculoConcurrente extends Operaciones implements Runnable {
    private Matriz A;
    private Matriz B;
    private Matriz C;
    private Integer row;

    public CalculoConcurrente(Matriz A, Matriz B, Matriz C, int row) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
    }

    @Override
    public void run() {
        double[] result = new double[B.cols()];

        for (int column_b = 0; column_b < B.cols(); column_b++) {
            int sum = 0;
            for (int column_a = 0; column_a < A.cols(); column_a++) {
                sum += A.cell(row, column_a) * B.cell(column_a, column_b);
            }
            result[column_b] = sumRootN(sum);
        }

        synchronized (C) {
            for (int col = 0; col < result.length; col++) {
                C.cell(row, col, result[col]);
            }
        }
    }
}
