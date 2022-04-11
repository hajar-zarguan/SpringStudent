package com.example.springstudent.security.Service;

import com.example.springstudent.security.entities.AppRole;
import com.example.springstudent.security.entities.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
    AppUser saveUser(String username, String password, String verifyPassword);
    AppRole saveRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);

}
