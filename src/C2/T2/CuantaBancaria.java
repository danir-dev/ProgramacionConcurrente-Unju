package C2.T2;

public class CuantaBancaria {

}

/*

EJEMPLO MONITOR

monitor CuentaBancaria {
    int saldo;
    condition saldoPositivo;

    procedure ingresar(int cantidad) {
        saldo = saldo + cantidad;
        if (saldo > 0) {
            saldoPositivo.signal();
        }
    }

    procedure retirar(int cantidad) {
        saldoPositivo.wait(); // Espera hasta que el saldo sea positivo
        saldo = saldo - cantidad;
    }
}

En este ejemplo, el monitor CuentaBancaria protege el acceso al saldo de una cuenta. Solo un proceso puede acceder al saldo a la vez, y se utiliza una variable de condición para garantizar que no se retire dinero si el saldo es negativo.

 */