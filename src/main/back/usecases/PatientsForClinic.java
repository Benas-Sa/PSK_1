package main.back.usecases;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import main.back.entities.Clinic;
import main.back.entities.Patient;
import main.back.persistence.ClinicsDAO;
import main.back.persistence.PatientsDAO;

@Model
public class PatientsForClinic implements Serializable {

    @Inject
    private ClinicsDAO clinicsDAO;

    @Inject
    private PatientsDAO patientsDAO;

    @Getter @Setter
    private Patient patientToCreate = new Patient();

    @Getter @Setter
    private Clinic clinic;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer clinicID = Integer.parseInt(requestParameters.get("clinicID"));
        this.clinic = clinicsDAO.findOne(clinicID);
    }

    @Transactional
    public String createPatient(){
        patientToCreate.setClinic(this.clinic);
        patientsDAO.persist(patientToCreate);
        return "patients?faces-redirect=true&clinicId=" + this.clinic.getId();
    }
}