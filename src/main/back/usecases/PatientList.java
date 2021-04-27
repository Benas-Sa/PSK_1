package main.back.usecases;

import lombok.Getter;
import lombok.Setter;
import main.back.entities.Patient;
import main.back.persistence.PatientsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


//@Model
//@RequestScoped
public class PatientList {
   /* @Inject
    private PatientsDAO patientsDAO;
    @Getter
    @Setter
    private Patient patient = new Patient();
    @Getter
    private List<Patient> patientList;
    @PostConstruct
    public void init(){
        loadAllPatients();
    }
    private void loadAllPatients(){
        this.patientList = patientsDAO.loadAll();
    }
    @Transactional
    public String createPatient() {
        this.patientsDAO.persist(patient);
        return "index?faces-redirect=true";
    }*/
}