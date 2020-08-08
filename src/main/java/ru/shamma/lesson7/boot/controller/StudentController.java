package ru.shamma.lesson7.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shamma.lesson7.Student;
import ru.shamma.lesson7.service.StudentService;


@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("")
    public String showStudents(Model model){
        model.addAttribute("students",service.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String editStudents(Model model, @PathVariable("id") Long id){
        model.addAttribute("student",service.findById(id).get());
        return "edit-students";
    }
    @PostMapping("/edit/{id}")
    public String saveEditStudent(@ModelAttribute("student") Student student, @PathVariable("id") Long id){
        service.save(student);
        return "redirect:/students";
    }

    @GetMapping("/remove/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "add-student";
    }
    @PostMapping("/add")
    public String saveStudent(Student student){
        service.save(student);
        return "redirect:/students";
    }
}
