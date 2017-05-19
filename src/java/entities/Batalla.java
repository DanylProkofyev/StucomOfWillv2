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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dergenburn
 */
@Entity
@Table(name = "batalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Batalla.findAll", query = "SELECT b FROM Batalla b")
    , @NamedQuery(name = "Batalla.findByIdbatalla", query = "SELECT b FROM Batalla b WHERE b.idbatalla = :idbatalla")
, @NamedQuery(name = "Batalla.findRanking", query = "SELECT count(b) AS victorias ,b.ganador FROM Batalla b GROUP BY b.ganador order by victorias desc ")})
public class Batalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbatalla")
    private Integer idbatalla;
    @JoinColumn(name = "jugador1", referencedColumnName = "nombre")
    @ManyToOne(optional = false)
    private Usuario jugador1;
    @JoinColumn(name = "jugador2", referencedColumnName = "nombre")
    @ManyToOne(optional = false)
    private Usuario jugador2;
    @JoinColumn(name = "ganador", referencedColumnName = "nombre")
    @ManyToOne
    private Usuario ganador;

    public Batalla() {
    }

    public Batalla(Integer idbatalla) {
        this.idbatalla = idbatalla;
    }

    public Integer getIdbatalla() {
        return idbatalla;
    }

    public void setIdbatalla(Integer idbatalla) {
        this.idbatalla = idbatalla;
    }

    public Usuario getJugador1() {
        return jugador1;
    }

    public void setJugador1(Usuario jugador1) {
        this.jugador1 = jugador1;
    }

    public Usuario getJugador2() {
        return jugador2;
    }

    public void setJugador2(Usuario jugador2) {
        this.jugador2 = jugador2;
    }

    public Usuario getGanador() {
        return ganador;
    }

    public void setGanador(Usuario ganador) {
        this.ganador = ganador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbatalla != null ? idbatalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Batalla)) {
            return false;
        }
        Batalla other = (Batalla) object;
        if ((this.idbatalla == null && other.idbatalla != null) || (this.idbatalla != null && !this.idbatalla.equals(other.idbatalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Batalla[ idbatalla=" + idbatalla + " ]";
    }
    
}
