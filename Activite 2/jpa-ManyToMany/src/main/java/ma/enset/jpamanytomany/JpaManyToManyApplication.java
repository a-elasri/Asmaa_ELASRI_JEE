package ma.enset.jpamanytomany;

import ma.enset.jpamanytomany.entities.Role;
import ma.enset.jpamanytomany.entities.User;
import ma.enset.jpamanytomany.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService){
        return  args-> {
            User user =new User() ;
            user.setUsername("user1");
            user.setPassword("123456789");
            userService.addNewUser(user) ;

            User admin =new User() ;
            admin.setUsername("admin1");
            admin.setPassword("123456789");
            userService.addNewUser(admin) ;

            Stream.of("STUDENT","USER","ADMIN").forEach(r->{
                Role role1 = new Role() ;
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("admin1","ADMIN");
            try{
                User user1= userService.authenticate("user1","123456789");
                System.out.println(user1.getUsername());
                user1.getRoles().forEach(r->{
                    System.out.printf("Role:=> "+r.getRoleName());
                });
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } ;
    }
}
