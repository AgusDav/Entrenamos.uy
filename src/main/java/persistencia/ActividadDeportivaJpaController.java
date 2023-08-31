/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.ActividadDeportiva;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author USUARIO
 */
public class ActividadDeportivaJpaController implements Serializable {

    public ActividadDeportivaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ActividadDeportivaJpaController (){
        emf = Persistence.createEntityManagerFactory("Entrenamos.uyPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ActividadDeportiva actividadDeportiva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(actividadDeportiva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ActividadDeportiva actividadDeportiva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            actividadDeportiva = em.merge(actividadDeportiva);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = actividadDeportiva.getNombre();
                if (findActividadDeportiva(id) == null) {
                    throw new NonexistentEntityException("The actividadDeportiva with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ActividadDeportiva actividadDeportiva;
            try {
                actividadDeportiva = em.getReference(ActividadDeportiva.class, id);
                actividadDeportiva.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The actividadDeportiva with id " + id + " no longer exists.", enfe);
            }
            em.remove(actividadDeportiva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ActividadDeportiva> findActividadDeportivaEntities() {
        return findActividadDeportivaEntities(true, -1, -1);
    }

    public List<ActividadDeportiva> findActividadDeportivaEntities(int maxResults, int firstResult) {
        return findActividadDeportivaEntities(false, maxResults, firstResult);
    }

    private List<ActividadDeportiva> findActividadDeportivaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ActividadDeportiva.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ActividadDeportiva findActividadDeportiva(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ActividadDeportiva.class, id);
        } finally {
            em.close();
        }
    }

    public int getActividadDeportivaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ActividadDeportiva> rt = cq.from(ActividadDeportiva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
