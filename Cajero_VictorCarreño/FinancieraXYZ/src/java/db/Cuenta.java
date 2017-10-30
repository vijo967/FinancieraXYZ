/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utpl
 */
@Entity
@Table(name = "cuenta")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "Cuenta.findByTipoCuenta", query = "SELECT c FROM Cuenta c WHERE c.tipoCuenta = :tipoCuenta"),
    @NamedQuery(name = "Cuenta.findByNroCuenta", query = "SELECT c FROM Cuenta c WHERE c.nroCuenta = :nroCuenta"),
    @NamedQuery(name = "Cuenta.findBySaldoActual", query = "SELECT c FROM Cuenta c WHERE c.saldoActual = :saldoActual"),
    @NamedQuery(name = "Cuenta.findBySaldoAnterior", query = "SELECT c FROM Cuenta c WHERE c.saldoAnterior = :saldoAnterior"),
    @NamedQuery(name = "Cuenta.findByCantRetiro", query = "SELECT c FROM Cuenta c WHERE c.cantRetiro = :cantRetiro"),
    @NamedQuery(name = "Cuenta.findByNombBanco", query = "SELECT c FROM Cuenta c WHERE c.nombBanco = :nombBanco")})
@XmlRootElement
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta")
    private Integer idCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nro_cuenta")
    private String nroCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_actual")
    private double saldoActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_anterior")
    private double saldoAnterior;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cant_retiro")
    private Double cantRetiro;
    @Size(max = 200)
    @Column(name = "nomb_banco")
    private String nombBanco;

    public Cuenta() {
    }

    public Cuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cuenta(Integer idCuenta, String tipoCuenta, String nroCuenta, double saldoActual, double saldoAnterior) {
        this.idCuenta = idCuenta;
        this.tipoCuenta = tipoCuenta;
        this.nroCuenta = nroCuenta;
        this.saldoActual = saldoActual;
        this.saldoAnterior = saldoAnterior;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Double getCantRetiro() {
        return cantRetiro;
    }

    public void setCantRetiro(Double cantRetiro) {
        this.cantRetiro = cantRetiro;
    }

    public String getNombBanco() {
        return nombBanco;
    }

    public void setNombBanco(String nombBanco) {
        this.nombBanco = nombBanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Cuenta[ idCuenta=" + idCuenta + " ]";
    }
    
}
