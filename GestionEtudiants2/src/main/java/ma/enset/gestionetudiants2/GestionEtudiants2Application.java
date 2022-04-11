package ma.enset.gestionetudiants2;

import ma.enset.gestionetudiants2.entities.Etudiant;
import ma.enset.gestionetudiants2.entities.Genre;
import ma.enset.gestionetudiants2.repositories.EtudiantRepesotory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GestionEtudiants2Application {

    public static void main(String[] args) {
        SpringApplication.run(GestionEtudiants2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepesotory etudiantRepesotory){
        return args -> {
            etudiantRepesotory.save(new Etudiant(null,"Elasri1","Asmaa","asmaa@gmail.com",new Date(), Genre.Feminin,true)) ;
            etudiantRepesotory.save(new Etudiant(null,"Elasri2","Hind","hind@gmail.com",new Date(), Genre.Feminin,false)) ;
            etudiantRepesotory.save(new Etudiant(null,"Elasri3","Zakaria","zakaria@gmail.com",new Date(), Genre.Masculin,false)) ;
            etudiantRepesotory.save(new Etudiant(null,"Elasri4","Hicham","hicham@gmail.com",new Date(), Genre.Feminin,true)) ;

            etudiantRepesotory.findAll().forEach(etudiant -> {
                System.out.println(etudiant.getNom());
            });

        };
    }

}
