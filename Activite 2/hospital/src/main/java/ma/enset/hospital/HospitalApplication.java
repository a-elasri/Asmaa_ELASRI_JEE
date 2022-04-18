package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.repository.ConsultationRepository;
import ma.enset.hospital.repository.MedecinRepository;
import ma.enset.hospital.repository.PatienRepository;
import ma.enset.hospital.repository.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(PatienRepository patienRepository, MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
		return args -> {
			Stream.of("Mohammed","Hassan","Najat")
					.forEach(name->{
						Patient p = new Patient();
						p.setDateNaissance(new Date());
						p.setNom(name) ;
						p.setMalade(false);
						patienRepository.save(p) ;
					});
			Stream.of("aymane","Fatima","Yassamine")
					.forEach(name->{
						Medecin m = new Medecin();
						m.setNom(name);
						m.setEmail(name+"@gmail.com");
						m.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						medecinRepository.save(m) ;

					});
			Patient patient = patienRepository.findById(1L).orElse(null) ;
			Patient paftient1 =patienRepository.findByNom("Mohammed");

			Medecin medecin = medecinRepository.findByNom("Yassamine") ;
			RendezVous rendezVous = new RendezVous() ;
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			rendezVousRepository.save(rendezVous);

			Consultation consultation = new Consultation() ;
			consultation.setRapport("Rapport de la consultation ..........");
			consultation.setRendezVous(rendezVous);
			consultation.setDateConsultation(new Date());
			consultationRepository.save(consultation);

		};


	}

	//on utilisant la couche service :

   /*
   @Bean
    CommandLineRunner start(IHospitalService iHospitalService,PatienRepository patienRepository ,MedecinRepository medecinRepository){
        return args -> {
        Stream.of("Mohammed","Hassan","Najat")
            .forEach(name->{
                Patient p = new Patient();
                p.setDateNaissance(new Date());
                p.setNom(name) ;
                p.setMalade(false);
                iHospitalService.savePatient(p) ;

            });

            Stream.of("ayman","Fatima","Yassamine")
                    .forEach(name->{
                        Medecin m = new Medecin();
                        m.setNom(name);
                        m.setEmail(name+"@gmail.com");
                        m.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        iHospitalService.saveMedecin(m) ;

                    });
            Patient patient = patienRepository.findById(1L).orElse(null) ;
                Patient paftient1 =patienRepository.findByNom("Mohammed");

            Medecin medecin = medecinRepository.findByNom("Yassamine") ;
            RendezVous rendezVous = new RendezVous() ;
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            iHospitalService.saveRDV(rendezVous);

            Consultation consultation = new Consultation() ;
            consultation.setRapport("Rapport de la consultation ..........");
            consultation.setRendezVous(rendezVous);
            consultation.setDateConsultation(new Date());
            iHospitalService.saveConsultation(consultation);

        };
    }
*/
}
