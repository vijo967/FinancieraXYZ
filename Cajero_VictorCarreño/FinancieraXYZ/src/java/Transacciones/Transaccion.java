package Transacciones;

/**
 *
 * @author FamiliaQuiroga
 */
public abstract class Transaccion {
    private int cuentaOrigen;
    private int cuentaDestino;
    private int monto;
    private String fecha;
    
    public Transaccion(int cuentaOrigen, int cuentaDestino, int monto, String fecha) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.fecha = fecha;

    }
}
