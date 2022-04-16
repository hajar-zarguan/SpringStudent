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
        //au démarrage crée moi un PasswordEncoder et tu le place dans context
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

  // @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            studentRepository.save(new Student(null,"Zarguan","Hajar",new Date(),"hajar@gmail", Genre.feminin,true));
            studentRepository.save(new Student(null,"Soufian","Leila",new Date(),"anas@gmail", Genre.feminin,true));
            studentRepository.save(new Student(null,"Saadaoui","hilal",new Date(),"hanan@gmail", Genre.masculin,true));
            studentRepository.save(new Student(null,"Omar","Hiba",new Date(),"omar@gmail", Genre.feminin,true));

            studentRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }
   // @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveUser("hajar","1234","1234");
            securityService.saveUser("mohammed","1234","1234");

            securityService.saveRole("USER","");
            securityService.saveRole("ADMIN","");

            securityService.addRoleToUser("hajar","USER");
            securityService.addRoleToUser("hajar","ADMIN");
            securityService.addRoleToUser("mohammed","USER");


        };
    }
}