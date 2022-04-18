package ma.enset.hospital.repository;

import ma.enset.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatienRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom) ;
}
