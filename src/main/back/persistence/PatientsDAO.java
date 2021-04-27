package main.back.persistence;

import main.back.entities.Patient;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PatientsDAO {
    @PersistenceContext
    private EntityManager em;


    public void persist(Patient patient) {
        this.em.persist(patient);
    }

}