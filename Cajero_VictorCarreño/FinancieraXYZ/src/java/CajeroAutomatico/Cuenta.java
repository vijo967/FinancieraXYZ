package CajeroAutomatico;

/**
 *
 * @author FamiliaQuiroga
 */
public abstract class Cuenta {
    private int saldo;
    private String tipoDeCuenta;
    private int tasaInteres;
    private int montoMaximoRetiro;
    
    public Cuenta(int saldo, String tipoDeCuenta, int tasaInteres) {
        this.saldo = saldo;
        this.tipoDeCuenta = tipoDeCuenta;
        this.tasaInteres = tasaInteres;
        this.montoMaximoRetiro = 1500;
    }

    public int mostrarSaldo() {
        return saldo;
    }

    public String mostrarTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public int mostarTasaDeInteres() {
        return tasaInteres;
    }

    public void depositar(int montoDeposito) {
        saldo += montoDeposito;
    }

    public void retirar(int montoRetiro) {
        if(retiroValido(montoRetiro))  
            saldo-= montoRetiro;
    }

    private boolean retiroValido(int montoRetiro) {
        return (saldo >= montoRetiro && montoRetiro <= montoMaximoRetiro);
    }
}