package Transacciones;

import Transacciones.Transaccion;

/**
 *
 * @author FamiliaQuiroga
 */
public class Deposito extends Transaccion{

    public Deposito(int cuentaOrigen, int cuentaDestino, int monto, String fecha) {
        super(cuentaOrigen, cuentaDestino, monto, fecha);
    }
    
}
