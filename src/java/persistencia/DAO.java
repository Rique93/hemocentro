/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Henrique Marques dos Santos
 * @param <T>
 */
public class DAO<T> {
    
    private EntityManager em;
    
    public DAO(String pu) {
        if (this.em == null) {
            this.em = Persistence.createEntityManagerFactory(pu).createEntityManager();
        }

    }
   
    public void insert(T object){  
        this.em.getTransaction().begin();
        this.em.persist(object);
        this.em.getTransaction().commit();
    }
    
    public void update(T object){
        this.em.getTransaction().begin();
        this.em.merge(object);
        this.em.getTransaction().commit();        
    }    
    
    public void delete(T object){
        this.em.getTransaction().begin();
        this.em.remove(object);
        this.em.getTransaction().commit();        
    }
    
    public T get(Class<T> c, int id){
        return this.em.find(c, id);
    }
    
    public List<T> getPretriagensHabilitadas(Class<T> c, boolean habilitadoTriagem, String sql){
        Query query = this.em.createNamedQuery(sql, c);
        query.setParameter("habilitado_triagem", habilitadoTriagem);
        return query.getResultList();
    }
    
    public List<T> getTriagensHabilitadas(Class<T> c, boolean habilitadoDoacao, String sql){
        Query query = this.em.createNamedQuery(sql, c);
        query.setParameter("habilitado_doacao", habilitadoDoacao);
        return query.getResultList();
    }
    
//    public T getByName(Class<T> c, String sql){
//        Query query = this.em.createNamedQuery(sql, c);
//        return (T) query.getSingleResult();
//    }
    
    public List<T> getAll(Class<T> c, String sql){
        Query query = this.em.createNamedQuery(sql, c);
        return query.getResultList();
    }
    

    
    public void close(){
        this.em.close();
    }

}
