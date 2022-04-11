package ma.enset.gestionetudiants2.repositories;

import ma.enset.gestionetudiants2.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepesotory extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByNomContains(String nom, Pageable pageable);
}
