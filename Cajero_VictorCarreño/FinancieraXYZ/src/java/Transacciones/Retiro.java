package Transacciones;

import Transacciones.Transaccion;

/**
 *
 * @author FamiliaQuiroga
 */
public class Retiro extends Transaccion{

    public Retiro(int cuentaOrigen, int cuentaDestino, int monto, String fecha) {
        super(cuentaOrigen, cuentaDestino, monto, fecha);
    }
    
}
