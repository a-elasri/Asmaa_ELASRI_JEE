package ma.enset.patientmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data // data génére un constructeur sans parametre
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;
    private boolean malade ;
    private int score ;
}
