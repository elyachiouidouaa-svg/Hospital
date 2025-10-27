package net.douaa.hospitalapp.repositories;

import net.douaa.hospitalapp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
