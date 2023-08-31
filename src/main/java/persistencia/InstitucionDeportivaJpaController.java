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
import logica.InstitucionDeportiva;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author USUARIO
 */
public class InstitucionDeportivaJpaController implements Serializable {

    public InstitucionDeportivaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public InstitucionDeportivaJpaController (){
        emf = Persistence.createEntityManagerFactory("Entrenamos.uyPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InstitucionDeportiva institucionDeportiva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(institucionDeportiva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InstitucionDeportiva institucionDeportiva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            institucionDeportiva = em.merge(institucionDeportiva);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = institucionDeportiva.getNombre();
                if (findInstitucionDeportiva(id) == null) {
                    throw new NonexistentEntityException("The institucionDeportiva with id " + id + " no longer exists.");
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
            InstitucionDeportiva institucionDeportiva;
            try {
                institucionDeportiva = em.getReference(InstitucionDeportiva.class, id);
                institucionDeportiva.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The institucionDeportiva with id " + id + " no longer exists.", enfe);
            }
            em.remove(institucionDeportiva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InstitucionDeportiva> findInstitucionDeportivaEntities() {
        return findInstitucionDeportivaEntities(true, -1, -1);
    }

    public List<InstitucionDeportiva> findInstitucionDeportivaEntities(int maxResults, int firstResult) {
        return findInstitucionDeportivaEntities(false, maxResults, firstResult);
    }

    private List<InstitucionDeportiva> findInstitucionDeportivaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InstitucionDeportiva.class));
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

    public InstitucionDeportiva findInstitucionDeportiva(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InstitucionDeportiva.class, id);
        } finally {
            em.close();
        }
    }

    public int getInstitucionDeportivaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InstitucionDeportiva> rt = cq.from(InstitucionDeportiva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
