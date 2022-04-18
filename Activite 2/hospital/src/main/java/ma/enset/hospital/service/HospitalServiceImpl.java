package ma.enset.hospital.service;

import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.repository.ConsultationRepository;
import ma.enset.hospital.repository.MedecinRepository;
import ma.enset.hospital.repository.PatienRepository;
import ma.enset.hospital.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService { private PatienRepository patienRepository ;
  private MedecinRepository medecinRepository ;
  private RendezVousRepository rendezVousRepository ;
  private ConsultationRepository consultationRepository ;

    public HospitalServiceImpl(PatienRepository patienRepository, MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patienRepository = patienRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patienRepository.save(patient);
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
