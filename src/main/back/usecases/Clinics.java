package main.back.usecases;
import lombok.Getter;
import lombok.Setter;
import main.back.entities.Clinic;
import main.back.persistence.ClinicsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Clinics {

    @Inject
    private ClinicsDAO clinicsDAO;

    @Getter @Setter
    private Clinic clinicToCreate = new Clinic();

    @Getter
    private List<Clinic> allClinics;

    @PostConstruct
    public void init(){
        loadAllClinics();
    }

    @Transactional
    public String createClinic(){
        this.clinicsDAO.persist(clinicToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllClinics(){
        this.allClinics = clinicsDAO.loadAll();
    }
}