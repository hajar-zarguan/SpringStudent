package com.example.springstudent;


import com.example.springstudent.entities.Genre;
import com.example.springstudent.entities.Student;
import com.example.springstudent.repositories.StudentRepository;
import com.example.springstudent.security.Service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class SpringStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStudentApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandeLineRunner(StudentRepository studentRepository ) {
        return args -> {
            studentRepository.save(new Student(null,"Salwa","leila",new Date(),"@gmqil", Genre.FEMININ,true));
            studentRepository.save(new Student(null,"anas","hilal",new Date(),"@gmqil", Genre.MASCULIN,true));
            studentRepository.save(new Student(null,"Hanan","hilal",new Date(),"hanan@gmqil", Genre.FEMININ,true));
            studentRepository.save(new Student(null,"anas","Omar",new Date(),"@gmqil", Genre.MASCULIN,true));
            studentRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
    @Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveUser("fatima","1234","1234");
            securityService.saveUser("hassan", "1234", "1234");

            securityService.saveRole("USER", "role user");
            securityService.saveRole("ADMIN", "role admin");

            securityService.addRoleToUser("fatima", "USER");
            securityService.addRoleToUser("fatima", "ADMIN");
            securityService.addRoleToUser("hassan", "USER");
        };
    }

}

