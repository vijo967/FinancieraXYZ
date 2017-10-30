package Registros;

import CajeroAutomatico.Cliente;
import CajeroAutomatico.NumeroDeCuenta;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author FamiliaQuiroga
 */
public class RegistroClientes {
    private Map <Integer, Cliente> clientes;
    
    public RegistroClientes() {
        clientes = new HashMap<>();
    }

    public void registrarCliente(String nombres, String apellidos,int nroCuenta) {
        Cliente cliente = new Cliente(nroCuenta,1010,nombres,apellidos);
        clientes.put(nroCuenta, cliente);
        
    }

    public boolean contieneCliente(int nroDeCuenta) {
        return clientes.containsKey((Integer)nroDeCuenta);
    }
    
    public void cambiarPin(int nroDeCuenta, int pin) {
        Cliente clienteAux = clientes.get(nroDeCuenta);
        clienteAux.cambiarPin(pin);
        clientes.put(nroDeCuenta, clienteAux);
    }

    public boolean validarAcceso(int nroCuenta, int pin) {
        Cliente clienteAux = clientes.get(nroCuenta);
        return clienteAux.validarPin(pin);
    }

    public void realizarRetiro(int numeroDeCuenta, int monto) {
        Cliente clienteAux = clientes.get(numeroDeCuenta);
        clienteAux.retirar(monto, "cuentaCorriente1");
        clientes.put(numeroDeCuenta, clienteAux);
    }
    public void realizarDeposito(int numeroDeCuenta, int monto) {
        Cliente clienteAux = clientes.get(numeroDeCuenta);
        clienteAux.depositar(monto, "cuentaCorriente1");
        clientes.put(numeroDeCuenta, clienteAux);
    }
}
