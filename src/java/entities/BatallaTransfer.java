/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author dergenburn
 */
public class BatallaTransfer {

    private int victorias = 0;
    private String usuario = "";

    public BatallaTransfer(int victorias, String usuario) {
        this.victorias = victorias;
        this.usuario = usuario;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Victorias=" + victorias + ", Usuario=" + usuario;
    }
}
