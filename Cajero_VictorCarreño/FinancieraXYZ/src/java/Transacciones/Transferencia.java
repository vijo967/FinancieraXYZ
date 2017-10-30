package Transacciones;

import Transacciones.Transaccion;

/**
 *
 * @author FamiliaQuiroga
 */
public class Transferencia extends Transaccion {

    public Transferencia(int cuentaOrigen, int cuentaDestino, int monto, String fecha) {
        super(cuentaOrigen, cuentaDestino, monto, fecha);
    }
    
}
