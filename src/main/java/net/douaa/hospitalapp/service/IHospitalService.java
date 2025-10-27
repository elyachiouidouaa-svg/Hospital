package net.douaa.hospitalapp.service;

import net.douaa.hospitalapp.entities.Consultation;
import net.douaa.hospitalapp.entities.Medecin;
import net.douaa.hospitalapp.entities.Patient;
import net.douaa.hospitalapp.entities.RendezVous;

public interface IHospitalService  {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);


}
