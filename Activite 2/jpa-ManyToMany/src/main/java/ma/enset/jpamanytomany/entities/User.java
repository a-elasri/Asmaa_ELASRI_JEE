package ma.enset.jpamanytomany.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class User {
    @Id
    private String userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NAME",unique = true,length = 255)
    private String username ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password ;

    @ManyToMany(mappedBy = "users" ,fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>() ;
}
