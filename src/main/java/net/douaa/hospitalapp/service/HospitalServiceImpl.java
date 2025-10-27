package net.douaa.hospitalapp.service;

import jakarta.transaction.Transactional;
import net.douaa.hospitalapp.entities.Consultation;
import net.douaa.hospitalapp.entities.Medecin;
import net.douaa.hospitalapp.entities.Patient;
import net.douaa.hospitalapp.entities.RendezVous;
import net.douaa.hospitalapp.repositories.ConsultationRepository;
import net.douaa.hospitalapp.repositories.MedecinRepository;
import net.douaa.hospitalapp.repositories.PatientRepository;
import net.douaa.hospitalapp.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

//Couche service de l'application
@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService{
    //Injection des dépendances @Autowired
    // Constructeur
    private PatientRepository patientRepository ;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
