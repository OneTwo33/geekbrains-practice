package ru.onetwo33.practice.homework7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.onetwo33.practice.homework7.model.Student;
import ru.onetwo33.practice.homework7.repository.StudentRepository;

import java.util.List;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        List<Student> students = (List<Student>) studentRepository.findAll();
        model.addAttribute("list", students);
        return "index";
    }

    @GetMapping("/{id}")
    public String showStudent(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id).get();
        model.addAttribute("student", student);
        return "show";
    }

    @PostMapping("/save")
    public String add(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        studentRepository.deleteById(id);
        return "redirect:/index";
    }
}
