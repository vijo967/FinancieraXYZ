package principal;

import GUI.LoginNroDeCuenta;
import GUI.LoginPin;
import GUI.VistaPrincipal;
import GUI.VistaRetiro;
import GUI.VistaRetiroRapido;
import Registros.AdministradorRegistroClientes;

/**
 *
 * @author FamiliaQuiroga
 */
public class Cajero {
    private AdministradorRegistroClientes adminClientes;
    private LoginNroDeCuenta loginNroDeCuenta;
    private LoginPin loginPin;
    private VistaPrincipal vistaPrincipal;
    private VistaRetiro vistaRetiro;
    private VistaRetiroRapido vistaRetiroRapido;
    
    private int numeroDeCuenta;
    
    
    public Cajero() {
        adminClientes = new AdministradorRegistroClientes();
        adminClientes.registrarCliente("Derp", "Herp", 1234567);
        loginNroDeCuenta = new LoginNroDeCuenta(this);
        loginPin = new LoginPin(this);
        loginNroDeCuenta.setVisible(true);
        vistaPrincipal = new VistaPrincipal(this);
        vistaRetiro = new VistaRetiro(this);
        vistaRetiroRapido = new VistaRetiroRapido(this);
    }
    
    public boolean validarNroCuenta(int nroCuenta) {
        this.numeroDeCuenta = nroCuenta;
        return adminClientes.existeCliente(nroCuenta);
    }
    
    public boolean validarPin(int pin) {
                realizarDeposito(1000);
        return adminClientes.validarAcceso(this.numeroDeCuenta, pin);
    }
    
    public void realizarRetiro(int monto) {
        adminClientes.realizarRetiro(this.numeroDeCuenta,monto);
    }
    
    public void realizarDeposito(int monto) {
        adminClientes.realziarDeposito(this.numeroDeCuenta, monto);
    }
    
    public void mostrarLoginPin() {
        loginNroDeCuenta.setVisible(false);
        loginPin.setVisible(true);
    }
    
    public void mostrarVistaPrincipal() {
        loginPin.setVisible(false);
        vistaPrincipal.setVisible(true);
        vistaRetiro.setVisible(false);
        vistaRetiroRapido.setVisible(false);
    }
    
    public void mostrarVistaRetiro() {
        vistaPrincipal.setVisible(false);
        vistaRetiro.setVisible(true);
        vistaRetiroRapido.setVisible(false);
    }
    
    public void mostrarVistaRetiroRapido() {
        vistaPrincipal.setVisible(false);
        vistaRetiroRapido.setVisible(true);
    }

    
}
