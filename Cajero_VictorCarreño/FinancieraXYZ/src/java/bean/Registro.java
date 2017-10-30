/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import db.ConnectionDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author roddycorrea
 */
@ManagedBean(name="loguin")
@RequestScoped
public class Registro {

    private String usuario;
    private String contrasena;
    private String nombres;
    private String apellidos;
    private String saldo;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage faceMessage;
    
    public Registro() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public FacesMessage getFaceMessage() {
        return faceMessage;
    }

    public void setFaceMessage(FacesMessage faceMessage) {
        this.faceMessage = faceMessage;
    }
    
    public String loguin_x() throws ClassNotFoundException {
        ConnectionDb db = new ConnectionDb();
        String nro_cta="";
        String pass="";
        String retorna="";
        String sql="SELECT * FROM cuenta, cliente WHERE id_cuenta="+usuario+" AND contrasenia="+contrasena;
        System.out.println(sql);
        Connection dbCon = db.conexion();
        try{
            Statement s = dbCon.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                nro_cta = rs.getString("id_cuenta");
                pass = rs.getString("contrasenia");
                setNombres(rs.getString("nombres"));
                setApellidos(rs.getString("apellidost"));
                setSaldo(rs.getString("saldo"));
            }
            rs.close();
            if(usuario.equals(nro_cta) && contrasena.equals(pass))
            {
                httpServletRequest.getSession().setAttribute("sessionUsuario", usuario);
                faceMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
                facesContext.addMessage(null, faceMessage);
                
                retorna="retiro";
            }
            else
            {
                faceMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);
                facesContext.addMessage(null, faceMessage);
                retorna="index";
            }
        }catch(Exception ex){
            System.out.println("Excepcion = "+ex);
        }
        //saldoActual(usuario);
        return retorna;
    }
    
    public double saldoActual(String usuario){
        ConnectionDb db = new ConnectionDb();
        String nro_cta="";
        String pass="";
        
        double retorna = 0;
        String sql="SELECT * FROM cuenta, cliente WHERE id_cuenta="+usuario;
        System.out.println(sql);
        Connection dbCon = null;
        try {
            dbCon = db.conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Statement s = dbCon.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                retorna = rs.getDouble("saldo");
            }
            rs.close();
            
            
        }catch(Exception ex){
            System.out.println("Excepcion = "+ex);
        }
        return retorna;
    }
    public int persona(int nro_cta){
        ConnectionDb db = new ConnectionDb();
        int id_cliente=0;
        String pass="";
        
        double retorna = 0;
        String sql="SELECT * FROM cuenta, cliente WHERE id_cuenta="+nro_cta;
        System.out.println(sql);
        Connection dbCon = null;
        try {
            dbCon = db.conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Statement s = dbCon.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                id_cliente = rs.getInt("id_cliente");
            }
            rs.close();
            
            
        }catch(Exception ex){
            System.out.println("Excepcion = "+ex);
        }
        System.out.println("id_cliente" + id_cliente);
        return id_cliente;
    }
    public void guardaRetiro(double saldoRestante, int nro_cta, int id_cliente, double cantRetirada){
        ConnectionDb db = new ConnectionDb();
        
        double retorna = 0;
        String sql="INSERT INTO transacciones(id_cuenta, id_cliente, retiro, saldo) VALUES ("+nro_cta+", "+id_cliente+", "+cantRetirada+ ", "+ saldoRestante+")";
        System.out.println(sql);
        Connection dbCon = null;
        try {
            dbCon = db.conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Statement s = dbCon.createStatement();
            s.execute(sql);
            
        }catch(Exception ex){
            System.out.println("Excepcion = "+ex);
        }
        actualizaCuenta(saldoRestante, nro_cta);
    }
    public void actualizaCuenta(double saldoRestante, int nro_cta){
        ConnectionDb db = new ConnectionDb();
        String sql="UPDATE cuenta SET saldo="+saldoRestante+"WHERE id_cuenta="+nro_cta;
        System.out.println(sql);
        Connection dbCon = null;
        try {
            dbCon = db.conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Statement s = dbCon.createStatement();
            s.execute(sql);
            
        }catch(Exception ex){
            System.out.println("Excepcion = "+ex);
        }
    }
    
    
}
