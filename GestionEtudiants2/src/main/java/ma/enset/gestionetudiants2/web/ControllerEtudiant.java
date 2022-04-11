package ma.enset.gestionetudiants2.web;

import lombok.AllArgsConstructor;
import ma.enset.gestionetudiants2.entities.Etudiant;
import ma.enset.gestionetudiants2.repositories.EtudiantRepesotory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor

public class ControllerEtudiant {
    private EtudiantRepesotory etudiantRepesotory;

    @GetMapping(path = "Home")
    public String etudiants(Model model,
                           @RequestParam(name ="page" ,defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "5") int size)
    {
        Page<Etudiant> pageEtudiant= etudiantRepesotory.findAll(PageRequest.of(page,size));
        model.addAttribute("PageEtudiant",pageEtudiant.getContent());
        model.addAttribute("nombrePages",new int[pageEtudiant.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "etudiant";
    }
    @GetMapping(path="/index")
    public String patiates(Model model ,
                           @RequestParam(name ="page" ,defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue ="") String keyword,
                           @RequestParam(name = "scor",defaultValue ="") int scor)

    {
        Page<Etudiant> pagePatient= etudiantRepesotory.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("PageEtudiant",pagePatient.getContent());
        model.addAttribute("nombrePages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "etudiant";
    }
    @GetMapping("/delete")
    public String delete(long id,String keyword,int page){
        etudiantRepesotory.deleteById(id);
        return "redirect:/index?page="+page+"&keyword=";
    }
    @GetMapping("/")
    public String Home(){
        return "redirect:/Home";
    }

}
