package ma.enset.patientmvc;

import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
    @Bean // executer la methode au démarrage
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Hassan" , new Date(),false ,12));
            patientRepository.save(new Patient(null,"Mohammed" , new Date(),true ,14));
            patientRepository.save(new Patient(null,"Yassamin" , new Date(),true ,20));
            patientRepository.save(new Patient(null,"Oumayma" , new Date(),false ,19));

            patientRepository.findAll().forEach((patient -> {
               // System.out.printf(patient.getNom() + "\n");
            }));

        };
    }
}
