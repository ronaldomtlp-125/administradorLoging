package com.todocode.administradordelogins.persistencia;

import com.todocode.administradordelogins.logica.UsuarioCliente;
import com.todocode.administradordelogins.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UsuarioClienteJpaController implements Serializable {

    public UsuarioClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public UsuarioClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("AdministradorDeLoginsPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioCliente usuarioCliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioCliente usuarioCliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioCliente = em.merge(usuarioCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuarioCliente.getId();
                if (findUsuarioCliente(id) == null) {
                    throw new NonexistentEntityException("The usuarioCliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioCliente usuarioCliente;
            try {
                usuarioCliente = em.getReference(UsuarioCliente.class, id);
                usuarioCliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioCliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioCliente> findUsuarioClienteEntities() {
        return findUsuarioClienteEntities(true, -1, -1);
    }

    public List<UsuarioCliente> findUsuarioClienteEntities(int maxResults, int firstResult) {
        return findUsuarioClienteEntities(false, maxResults, firstResult);
    }

    private List<UsuarioCliente> findUsuarioClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioCliente.class));
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

    public UsuarioCliente findUsuarioCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioCliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioCliente> rt = cq.from(UsuarioCliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
