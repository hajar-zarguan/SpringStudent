package com.example.springstudent.Web;

import com.example.springstudent.entities.Student;
import com.example.springstudent.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentRepository studentRepository ;
    @GetMapping(path = "/user/index")
    public String students(Model model,
                           @RequestParam(name= "page", defaultValue = "0") int page,
                           @RequestParam(name= "size", defaultValue = "8") int size,
                           @RequestParam(name= "keyword", defaultValue = "") String keyword) {

        Page<Student> pageStudents = studentRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListStudents",pageStudents.getContent());
        model.addAttribute("pages", new int[pageStudents.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "students";
    }
    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page) {
        studentRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/add")
    public String add(Model model) {
        model.addAttribute("student",new Student());
        return "addStudent";
    }
    @PostMapping("/admin/save")
    public String save(Model model, @Valid Student student, BindingResult bindingResult,
                       @RequestParam(defaultValue ="0" ) int page,
                       @RequestParam(defaultValue ="" ) String keyword) {
        if(bindingResult.hasErrors()) return "addStudent";
        studentRepository.save(student);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/update")
    public String update(Model model, Long id, int page, String keyword) {
        Student student=studentRepository.findById(id).get();
        model.addAttribute("student",student);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "updateStudent";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**/
}
