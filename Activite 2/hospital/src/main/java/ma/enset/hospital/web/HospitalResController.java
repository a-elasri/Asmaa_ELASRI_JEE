package ma.enset.hospital.web;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repository.PatienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class HospitalResController {
    @Autowired
    private PatienRepository patienRepository ;

    @GetMapping("/patients")
    public List<Patient> patiensList(){
        return  patienRepository.findAll();
    }
}
