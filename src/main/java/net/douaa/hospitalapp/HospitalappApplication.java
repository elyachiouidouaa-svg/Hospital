package net.douaa.hospitalapp;

import net.douaa.hospitalapp.entities.*;
import net.douaa.hospitalapp.repositories.ConsultationRepository;
import net.douaa.hospitalapp.repositories.MedecinRepository;
import net.douaa.hospitalapp.repositories.PatientRepository;
import net.douaa.hospitalapp.repositories.RendezVousRepository;
import net.douaa.hospitalapp.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalappApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalappApplication.class, args);

    }
    @Bean
    //Injecter les interfaces Repository
    //CommandLineRunner start(PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository)
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository)
    {
        return args -> {
            //methode1
            // patientRepository.save(new Patient(null,"Douaa", new Date(),false,null));
            //methode2
            Stream.of("Wafae","Ikram","kawtar")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        //patientRepository.save(patient);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Hajar","Mohcine","Mohamed")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecin.setEmail(name+"@gmail.com");
                        //medecinRepository.save(medecin);
                        hospitalService.saveMedecin(medecin);
                    });
            //methode1
            //Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient = patientRepository.findById(1L).orElse(null);
            //methode2
            //Patient patient1 = patientRepository.findByNom("Ikram");

            Medecin medecin = medecinRepository.findByNom("Mohcine");
            //Creer un rendez-vous
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            //rendezVousRepository.save(rendezVous);
            RendezVous saveDRDV=hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());

            //Creer une consultation
            RendezVous rendezVous1 = rendezVousRepository.findById("71f32110-9c95-4448-be2c-d0b03467e5fd").orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new java.sql.Date(new Date().getTime()));
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation: ");
            hospitalService.saveConsultation(consultation);



        };

    }

}
