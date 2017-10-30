package CajeroAutomatico;

/**
 *
 * @author FamiliaQuiroga
 */
public class Cliente {
    private NumeroDeCuenta numeroDeCuenta;
    private Pin pin;
    private Nombre nombreCliente;
    private Apellido apellidosCliente;
    private Cuentas cuentas; 
    
    public Cliente(int numeroDeCuenta, int pin, String nombre, String apellido) {
        this.numeroDeCuenta = new NumeroDeCuenta(numeroDeCuenta);
        this.pin = new Pin(pin);
        this.nombreCliente = new Nombre (nombre);
        this.apellidosCliente = new Apellido (apellido);
        this.cuentas = new Cuentas();
    }
    
    public void depositar(int montoDeposito, String cuentaObjetivo) {
        cuentas.depositar(montoDeposito,cuentaObjetivo);
    }
    
    public int mostrarSaldo(String cuenta) {
       return  cuentas.mostrarSaldo(cuenta);
    }

    public void retirar(int montoRetiro, String cuentaObjetivo) {
        cuentas.retirar(montoRetiro, cuentaObjetivo);
    }

    public void agregarCuentaCorriente() {
        cuentas.agregarCuentaCorriente();
    }

    public void agregarCuentaDeAhorros() {
        cuentas.agregarCuentaDeAhorro();
    }

    public int mostrarSaldoTotal() {
        return cuentas.mostrarSaldoTotal();
    }
    
    public void cambiarPin(int pin) {
        this.pin.cambiarPin(pin);
    }

    public boolean validarPin(int pin) {
        return this.pin.validarPin(pin);
    }
}
