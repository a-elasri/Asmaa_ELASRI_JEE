package ma.enset;


import ma.enset.entities.Etudiant;
import ma.enset.entities.Genre;
import ma.enset.repositories.EtudiantRepository;
import ma.enset.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class GestionEtudiantsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionEtudiantsApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository){
        return args ->{
            etudiantRepository.save(
                    new Etudiant(null,"ELASRI","Asmaa","asmaa@gmail.com",new Date(), Genre.feminin,true));
            etudiantRepository.save(
                    new Etudiant(null,"elasri","FATI","fati@gmail.com",new Date(), Genre.feminin,true));
            etudiantRepository.save(
                    new Etudiant(null,"elbahja","Hamza","Hamza@gmail.com",new Date(), Genre.masculin,false));
            etudiantRepository.save(
                    new Etudiant(null,"khouy","samira","khouy@gmail.com",new Date(), Genre.masculin,true));
            etudiantRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

//    @Bean
//    CommandLineRunner saveUsers(SecurityService securityService){
//        return args -> {
//            securityService.saveNewUser("asmaa","1234","1234");
//            securityService.saveNewUser("khadija","1234","1234");
//
//
//            securityService.saveNewRole("USER","");
//            securityService.saveNewRole("ADMIN","");
//
//            securityService.addRoleToUser("asmaa","USER");
//            securityService.addRoleToUser("asmaa","ADMIN");
//            securityService.addRoleToUser("khadija","USER");
//        };
//    }
}
