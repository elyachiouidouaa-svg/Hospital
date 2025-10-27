package net.douaa.hospitalapp.web;

import net.douaa.hospitalapp.entities.Patient;
import net.douaa.hospitalapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    //creer un contolleur permet de lister la liste de patients
    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }

}
