/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass")
    , @NamedQuery(name = "Usuario.findByPuntos", query = "SELECT u FROM Usuario u WHERE u.puntos = :puntos")
    , @NamedQuery(name = "Usuario.findAllOrder", query = "SELECT u FROM Usuario u order by u.puntos desc")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @JoinColumn(name = "ruler", referencedColumnName = "idruler")
    @ManyToOne(optional = false)
    private Ruler ruler;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador1")
    private Collection<Batalla> batallaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador2")
    private Collection<Batalla> batallaCollection1;
    @OneToMany(mappedBy = "ganador")
    private Collection<Batalla> batallaCollection2;

    public Usuario() {
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, String pass, int puntos, Ruler ruler) {
        this.nombre = nombre;
        this.pass = pass;
        this.puntos = puntos;
        this.ruler = ruler;

    }

    public Usuario(String nombre, String pass, int puntos) {
        this.nombre = nombre;
        this.pass = pass;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Ruler getRuler() {
        return ruler;
    }

    public void setRuler(Ruler ruler) {
        this.ruler = ruler;
    }

    @XmlTransient
    public Collection<Batalla> getBatallaCollection() {
        return batallaCollection;
    }

    public void setBatallaCollection(Collection<Batalla> batallaCollection) {
        this.batallaCollection = batallaCollection;
    }

    @XmlTransient
    public Collection<Batalla> getBatallaCollection1() {
        return batallaCollection1;
    }

    public void setBatallaCollection1(Collection<Batalla> batallaCollection1) {
        this.batallaCollection1 = batallaCollection1;
    }

    @XmlTransient
    public Collection<Batalla> getBatallaCollection2() {
        return batallaCollection2;
    }

    public void setBatallaCollection2(Collection<Batalla> batallaCollection2) {
        this.batallaCollection2 = batallaCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<td> " + nombre + " </td><td> " + puntos + " </td>";
    }

}
