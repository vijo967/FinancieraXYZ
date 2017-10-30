package Registros;

import Transacciones.Transaccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FamiliaQuiroga
 */
public class RegistroTransacciones {
    private List<Transaccion> transacciones;
    
    public RegistroTransacciones() {
        transacciones = new ArrayList<>();
    }

    public void registrar(Transaccion transaccionDePrueba) {
        
    }

    void registrarDeposito(int i, int i0, int i1, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
