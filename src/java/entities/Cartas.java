/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dergenburn
 */
@Entity
@Table(name = "cartas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartas.findAll", query = "SELECT c FROM Cartas c")
    , @NamedQuery(name = "Cartas.findByIdcartas", query = "SELECT c FROM Cartas c WHERE c.idcartas = :idcartas")
    , @NamedQuery(name = "Cartas.findByNombre", query = "SELECT c FROM Cartas c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cartas.findByCoste", query = "SELECT c FROM Cartas c WHERE c.coste = :coste")
    , @NamedQuery(name = "Cartas.findByTipo", query = "SELECT c FROM Cartas c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Cartas.findByEfecto", query = "SELECT c FROM Cartas c WHERE c.efecto = :efecto")
    , @NamedQuery(name = "Cartas.findByAtaque", query = "SELECT c FROM Cartas c WHERE c.ataque = :ataque")
    , @NamedQuery(name = "Cartas.findByDefensa", query = "SELECT c FROM Cartas c WHERE c.defensa = :defensa")
    , @NamedQuery(name = "Cartas.findByDisponibilidad", query = "SELECT c FROM Cartas c WHERE c.disponibilidad = 1")})
public class Cartas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcartas")
    private Integer idcartas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "coste")
    private Integer coste;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "efecto")
    private String efecto;
    @Column(name = "ataque")
    private Integer ataque;
    @Column(name = "defensa")
    private Integer defensa;
    @Column(name = "disponibilidad")
    private Integer disponibilidad;

    public Cartas() {
    }

    public Cartas(Integer idcartas) {
        this.idcartas = idcartas;
    }

    public Cartas(Integer idcartas, String nombre, String tipo, Integer disponibilidad) {
        this.idcartas = idcartas;
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }

    public Integer getIdcartas() {
        return idcartas;
    }

    public void setIdcartas(Integer idcartas) {
        this.idcartas = idcartas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public Integer getdisponibilidad() {
        return coste;
    }

    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefensa() {
        return defensa;
    }

    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcartas != null ? idcartas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartas)) {
            return false;
        }
        Cartas other = (Cartas) object;
        if ((this.idcartas == null && other.idcartas != null) || (this.idcartas != null && !this.idcartas.equals(other.idcartas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<td>nombre: " + this.nombre + "</td>";
    }

}
