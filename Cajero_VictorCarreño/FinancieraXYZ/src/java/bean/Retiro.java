/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.flow.Parameter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author utpl
 */
@ManagedBean(name="retiro")
@RequestScoped
public class Retiro {

    /**
     * Creates a new instance of Retiro
     */
    private double cantActual;
    private double cantAretirar;
    private double saldoResultante;
    private double saldoActual;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage faceMessage;
    

    public Retiro() {
        
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
    }

    
    
    
    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getCantActual() {
        return cantActual;
    }

    public void setCantActual(double cantActual) {
        this.cantActual = cantActual;
    }

    public double getCantAretirar() {
        return cantAretirar;
    }

    public void setCantAretirar(double cantAretirar) {
        this.cantAretirar = cantAretirar;
    }

    public double getSaldosaldoResultante() {
        return saldoResultante;
    }

    public void setSaldosaldoResultante(double saldoResultante) {
        this.saldoResultante = saldoResultante;
    }
    
    
    public void test(){
        String idEmpleado;
        //obtener parametros
        FacesContext facesContext = FacesContext.getCurrentInstance(); 
        Map params = facesContext.getExternalContext().getRequestParameterMap(); 
        Integer parametroObtenido= new Integer((String) params.get("usuarioParam")); 
        System.out.println("parametro obtenido = "+parametroObtenido);
        //obtener parametros        
    //idEmpleado = params.
        //cantActual = log.saldoActual();
        System.out.println("cantidaddddddd = "+cantActual);
    }
    public void Retiro_x() throws ClassNotFoundException{
        
        
        if (cantAretirar % 10 == 0) {
            FacesContext facesContext = FacesContext.getCurrentInstance(); 
            Map params = facesContext.getExternalContext().getRequestParameterMap(); 
            Integer parametroObtenido= new Integer((String) params.get("usuarioParam")); 
            System.out.println("parametro obtenido = "+parametroObtenido);
            Registro log = new Registro();
            String nro_cta = Integer.toString(parametroObtenido);
            double saldo_return = log.saldoActual(nro_cta);
            System.out.println("\ncantActual = " + saldo_return);
            System.out.println("cantAretirar= " + cantAretirar+"\n");
            if (saldo_return > cantAretirar) {
            saldoResultante = saldo_return - cantAretirar ;
            httpServletRequest.getSession().setAttribute("Saldo restante = ", saldoResultante);
            faceMessage=new FacesMessage("Saldo restante = "+ saldoResultante);
            facesContext.addMessage(null, faceMessage);
            Integer id_cliente = log.persona(parametroObtenido);
            log.guardaRetiro(saldoResultante, parametroObtenido, id_cliente, cantAretirar);
            }else{
                httpServletRequest.getSession().setAttribute("Ud. no cuenta con fondos disponibles para realizar esa transaccion  = ", cantActual);
                faceMessage=new FacesMessage("Ud. no cuenta con fondos disponibles para realizar esa transaccion = "+ cantActual);
                facesContext.addMessage(null, faceMessage);
            }
            
        }else{
            httpServletRequest.getSession().setAttribute("Ud. solo puede retirar cantidades que sean multiplos de 10 ", cantActual);
            faceMessage=new FacesMessage("Ud. solo puede retirar cantidades que sean multiplos de 10 "+ cantActual);
            facesContext.addMessage(null, faceMessage);
            
            try{
                LoguinSession ls = new LoguinSession();
               ls.cerrarSessionRedirect(); 
            }catch(Exception e){
                System.out.println("ex = "+e);
            }
            
        }
        
        
    }
    
    
}
