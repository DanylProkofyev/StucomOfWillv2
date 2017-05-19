/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.BatallaTransfer;
import entities.Cartas;
import entities.Ruler;
import entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class willEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

    public List<Ruler> selectRulers() {
        return emf.createEntityManager().createNamedQuery("Ruler.findAll").getResultList();
    }

    public boolean altaUsuario(Usuario u) {
        if (!existeUsuario(u)) {
            EntityManager em = emf.createEntityManager();
            em.persist(u);
            em.close();
            return true;
        }
        return false;
    }

    public boolean existeUsuario(Usuario u) {
        EntityManager em = emf.createEntityManager();
        Usuario entrenadorEncontrado = em.find(Usuario.class, u.getNombre());
        em.close();
        return entrenadorEncontrado != null;
    }

    public Ruler rulerById(int r) {
        return (Ruler) emf.createEntityManager().createNamedQuery("Ruler.findByIdruler").setParameter("idruler", r).getSingleResult();
    }

    public List<Cartas> seleccionarTodasCartas() {
        return emf.createEntityManager().createNamedQuery("Cartas.findAll").getResultList();
    }

    public List<Usuario> seleccionarTodosUsuariosOrden() {
        return emf.createEntityManager().createNamedQuery("Usuario.findAllOrder").getResultList();
    }

    public List<BatallaTransfer> getBattleRanking() {
        List<BatallaTransfer> myDTO = new ArrayList<>();
        List<Object[]> results = emf.createEntityManager().createNamedQuery("Batalla.findRanking").getResultList();
        results.stream().map((result) -> {
            int count = ((Number) result[0]).intValue();
            Usuario u = (Usuario) result[1];
            BatallaTransfer bdto = new BatallaTransfer(count, u.getNombre());
            return bdto;
        }).forEachOrdered((bdto) -> {
            myDTO.add(bdto);
        });
        return myDTO;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
