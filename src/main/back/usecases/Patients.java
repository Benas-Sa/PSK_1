package main.back.usecases;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import lombok.*;
import main.back.entities.Patient;
import main.back.persistence.PatientsDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class Patients implements Serializable {

    @Inject
    private PatientsDAO patientsDAO;

    private Patient patientsToCreate = new Patient();

    private List<Patient> allPatients;
    @PostConstruct
    public void init() {
        loadPatients();
    }

    public void loadPatients() {
        // TODO this is a mock implementation - later we will connect it to real data store
        //this.allPatients = patientsDAO.loadAll();
    }

    public List<Patient> getAllPatients() {
        return allPatients;
    }

    public Patient getPatientsToCreate() {
        return patientsToCreate;
    }

    public void setPatientsToCreate(Patient patientsToCreate) {
        this.patientsToCreate = patientsToCreate;
    }

    @Transactional
    public String createPatient(){
        this.patientsDAO.persist(patientsToCreate);
        return "success";
    }
}
