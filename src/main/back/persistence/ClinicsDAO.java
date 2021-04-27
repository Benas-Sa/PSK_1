package main.back.persistence;

import main.back.entities.Clinic;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ClinicsDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Clinic> loadAll() {
        return em.createNamedQuery("Clinic.findAll", Clinic.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Clinic clinic){
        this.em.persist(clinic);
    }

    public Clinic findOne(Integer id) { return em.find(Clinic.class, id); }
}