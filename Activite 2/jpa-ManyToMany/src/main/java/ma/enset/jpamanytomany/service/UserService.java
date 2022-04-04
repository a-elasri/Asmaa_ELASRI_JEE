package ma.enset.jpamanytomany.service;


import ma.enset.jpamanytomany.entities.Role;
import ma.enset.jpamanytomany.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User addNewUser(User user) ;
    User findUserByUserName(String username) ;
    Role addNewRole(Role role);
    List<Role> findAllRoles() ;
    Role findRoleByRoleName(String rolename) ;
    void addRoleToUser(String username,String roleName) ;

    User authenticate(String username,String password);

}
