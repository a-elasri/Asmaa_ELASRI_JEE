package ma.enset.patientmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository ;
    @GetMapping(path = "/index")
    public  String patients(Model model,
                            @RequestParam(name="page",defaultValue = "0") int page ,
                            @RequestParam(name="size",defaultValue = "10") int size,
                            @RequestParam(name="keyword",defaultValue = "") String keyword){
       Page<Patient> patientPage = patientRepository.findByNomContains(keyword,PageRequest.of(page,size)) ;
       model.addAttribute("listPatients" ,patientPage.getContent()) ;
       model.addAttribute("pages",new int[patientPage.getTotalPages()]) ;
        model.addAttribute("currentPage",page) ;
        model.addAttribute("keyword",keyword) ;

        return "patient" ;
    }

    @GetMapping(path = "/delete")
    public  String delete(Long id,String keyword , int page){
        patientRepository.deleteById(id);
    return "redirect:/index?page="+page+"&keyword="+keyword ;
    }
}
