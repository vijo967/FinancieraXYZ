package CajeroAutomatico;

/**
 *
 * @author FamiliaQuiroga
 */
public class Pin {
    private int pin;
    
    public Pin(int pin) {
        this.pin = pin;
    }

    public void cambiarPin(int pin) {
        this.pin = pin;
    }
    
    public boolean validarPin(int pin) {
        return this.pin == pin;
    }
}
