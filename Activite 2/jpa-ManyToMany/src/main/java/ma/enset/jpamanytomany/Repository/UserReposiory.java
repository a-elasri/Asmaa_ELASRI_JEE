package ma.enset.jpamanytomany.Repository;

import ma.enset.jpamanytomany.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiory extends JpaRepository<User, String> {
    User findByUsername(String username) ;
}
