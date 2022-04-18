package ma.enset.sec;

import ma.enset.sec.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
//va etre instancié en premier
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        /*
        String encodedPWD=passwordEncoder.encode("1234");
        System.out.println(encodedPWD);
        auth.inMemoryAuthentication().withUser("user1").password(encodedPWD).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1111")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("2345")).roles("USER","ADMIN");
        //stratégy pour les utilisateurs puisse connecter on défini les utilisateurs toléré à accéder

*/
        //On a creé 3 table dans phpmyadmin: -user -role et userRole
        //On va récupérer les donnée qu on a saisi manuellement pour comparer username et password saisi par utilisateur est ce qu'il sont juste ou pas
        //on fait as pour indiquer que c'est le username car il reconnait sous le nom de pricipal de meme pour password qui le cinnait en tant que credentials
        //si ils ont meme nom pas besoin de mettre as comme par expl active
     /*   auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
                .authoritiesByUsernameQuery("select username as pricipal, role as role from users_roles where username=?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder);
    */
         auth.userDetailsService(userDetailsService);
          //quand utilis sasi username et mdp spring doit appeler cette méthode
        //et cette methode va appeler la methode load dans userdetailServiceImpl

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.formLogin();
         http.authorizeRequests().antMatchers("/").permitAll();
         //On a changé de hasrole a hasauthority car une authotrité peut avoir plusieurs roles
         http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("USER");
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        //toutes les requetes http necessite une athentification
        http.exceptionHandling().accessDeniedPage("/403");
    }

}
