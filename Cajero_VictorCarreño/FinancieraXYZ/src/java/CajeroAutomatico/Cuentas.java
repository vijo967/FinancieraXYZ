package CajeroAutomatico;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author FamiliaQuiroga
 */
public class Cuentas {
   private Map<String,Cuenta> cuentas; 
   private int nroCuentasCorrientes,nroCuentasDeAhorro;
   private Iterator<String> keyIterator;
   public Cuentas() {
       cuentas = new HashMap<>();
       cuentas.put ("cuentaCorriente1", new CuentaCorriente());
       cuentas.put("cuentaDeAhorro1", new CuentaDeAhorros());
       nroCuentasCorrientes = 1;
       nroCuentasDeAhorro = 1;
   }
   
   public void depositar(int montoDeposito, String cuentaObjetivo) {
       Cuenta cuentaAux = cuentas.get(cuentaObjetivo);
       cuentaAux.depositar(montoDeposito);
       cuentas.put(cuentaObjetivo, cuentaAux);
   }

    public int mostrarSaldo(String cuentaObjetivo) {
        return cuentas.get(cuentaObjetivo).mostrarSaldo();
    }

    public void retirar(int montoRetiro, String cuentaObjetivo) {
        Cuenta cuentaAux = cuentas.get(cuentaObjetivo);
        cuentaAux.retirar(montoRetiro);
                                            System.out.println(cuentaAux.mostrarSaldo());
        cuentas.put(cuentaObjetivo, cuentaAux);
        
    }

    public void agregarCuentaCorriente() {
        nroCuentasCorrientes++;
        String numeroCuenta = ""+nroCuentasCorrientes;
        cuentas.put("cuentaCorriente"+numeroCuenta, new CuentaCorriente());
    }

    public void agregarCuentaDeAhorro() {
        nroCuentasDeAhorro++;
        String numeroCuenta = ""+nroCuentasDeAhorro;
        cuentas.put("cuentaDeAhorro"+numeroCuenta, new CuentaDeAhorros());
    }

    public int mostrarSaldoTotal() {
        int saldoTotal = 0;
        String key;
        keyIterator =  cuentas.keySet().iterator();
        while(keyIterator.hasNext()) {
            key = keyIterator.next();
            saldoTotal += cuentas.get(key).mostrarSaldo();
        }
        return saldoTotal;
    }
}
