package Registros;


/**
 *
 * @author FamiliaQuiroga
 */
public class AdministradorRegistroClientes {
    private RegistroClientes registroClientes;
    
    public AdministradorRegistroClientes() {
        registroClientes = new RegistroClientes();
    }

    public void registrarCliente(String nombres, String apellidos, int nroCuenta) {
        registroClientes.registrarCliente(nombres, apellidos, nroCuenta);
    }

    public boolean existeCliente(int nroDeCuenta) {
        return registroClientes.contieneCliente(nroDeCuenta);
    }
    
    public void cambianPin(int nroDeCuenta, int pin) {
        registroClientes.cambiarPin(nroDeCuenta, pin);
    }

    public boolean validarAcceso(int nroDeCuenta, int pin) {
        return registroClientes.validarAcceso(nroDeCuenta, pin);
    }

    public void realizarRetiro(int numeroDeCuenta, int monto) {
        
        registroClientes.realizarRetiro(numeroDeCuenta, monto);
    }
    
    public void realziarDeposito(int nroDeCuenta, int monto) {
        registroClientes.realizarDeposito(nroDeCuenta, monto);
    }

}
