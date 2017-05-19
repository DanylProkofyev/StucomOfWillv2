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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dergenburn
 */
@Entity
@Table(name = "ruler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruler.findAll", query = "SELECT r FROM Ruler r")
    , @NamedQuery(name = "Ruler.findByIdruler", query = "SELECT r FROM Ruler r WHERE r.idruler = :idruler")
    , @NamedQuery(name = "Ruler.findByNombre", query = "SELECT r FROM Ruler r WHERE r.nombre = :nombre")})
public class Ruler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idruler")
    private Integer idruler;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "efecto")
    private String efecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruler")
    private Collection<Usuario> usuarioCollection;

    public Ruler() {
    }

    public Ruler(Integer idruler) {
        this.idruler = idruler;
    }

    public Ruler(Integer idruler, String nombre) {
        this.idruler = idruler;
        this.nombre = nombre;
    }

    public Integer getIdruler() {
        return idruler;
    }

    public void setIdruler(Integer idruler) {
        this.idruler = idruler;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idruler != null ? idruler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruler)) {
            return false;
        }
        Ruler other = (Ruler) object;
        if ((this.idruler == null && other.idruler != null) || (this.idruler != null && !this.idruler.equals(other.idruler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ruler[ idruler=" + idruler + " ]";
    }
    
}
