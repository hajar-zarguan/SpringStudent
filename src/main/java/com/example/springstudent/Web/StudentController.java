package com.example.springstudent.Web;

import com.example.springstudent.entities.Student;
import com.example.springstudent.repositories.StudentRepository;
import com.example.springstudent.security.entities.AppRole;
import com.example.springstudent.security.entities.AppUser;
import com.example.springstudent.security.repositories.AppRoleRepository;
import com.example.springstudent.security.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor @Controller
@Data
public class StudentController {
    private StudentRepository studentRepository;
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    @GetMapping(path = "/user/index")
    public String students(Model model,
                           //param d'url
                           @RequestParam(name="page", defaultValue = "0") int page1,
                           @RequestParam(name="size", defaultValue = "5") int size,
                           @RequestParam(name="keyword", defaultValue = "") String keyword){
        Page<Student> studentPage = studentRepository.findByNomContains(keyword, PageRequest.of(page1,size));
        model.addAttribute("listStudents",studentPage.getContent());
        model.addAttribute("pages",new int[studentPage.getTotalPages()]);
        model.addAttribute("currentPage",page1);
        model.addAttribute("keyword",keyword);
        return "students";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page){
        studentRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user/students")
    @ResponseBody
    public List<Student> listStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/admin/formStudents")
    public String formStudents(Model model,    //param d'url
                               @RequestParam(name="page", defaultValue = "0") int page,
                               @RequestParam(name="size", defaultValue = "5") int size,
                               @RequestParam(name="keyword", defaultValue = "") String keyword){
        Page<Student> studentPage = studentRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("pages",new int[studentPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("student",new Student());
        model.addAttribute("keyword",keyword);
        return "formStudents";
    }

    @GetMapping("/user/profile")
    public String profile(Model model, String username){
        AppUser appUser = appUserRepository.findByUsername(username);
        List<AppRole> roles = new ArrayList<>();
       // for (AppRole role: appUser.getAppRoles()) {roles.add(role);} Null Exeption pointer
        model.addAttribute("roles",roles);
        model.addAttribute("user",appUser);
        return "profile";
    }

    @PostMapping("/admin/save")
    //@Valid ==> je dis à spring mvc une fois tu fais l'ajout d'un etudiant au BDD tu fais la validation
    //si jamais il y a des erreurs tu les stockes dans BindingResult
    public String save(Model model, @Valid Student student, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "")String keyword){
        if (bindingResult.hasErrors())
            return "formStudents";
        studentRepository.save(student);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editStudent")
    public String editStudent(Model model,Long id,
                              @RequestParam(defaultValue = "") String keyword,
                              @RequestParam(defaultValue = "0") int page){
        Student student = studentRepository.findById(id).orElse(null);
        if (student==null) throw new RuntimeException("Student introuvable!!!");
        model.addAttribute("student",student);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        return "editStudent";
    }

    @GetMapping("/user/listStudent")
    public String listStudent(Model model, Long id,
                              @RequestParam(defaultValue = "") String keyword,
                              @RequestParam(defaultValue = "0") int page){
        Student student = studentRepository.findById(id).get();
        model.addAttribute("student",student);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        return "listStudent";
    }

    /*@GetMapping("/auth")
    public String login(){
        return "login";
    }*/
}
