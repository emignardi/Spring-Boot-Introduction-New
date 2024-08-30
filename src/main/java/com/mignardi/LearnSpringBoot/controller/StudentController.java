package com.mignardi.LearnSpringBoot.controller;

import com.mignardi.LearnSpringBoot.model.Student;
import com.mignardi.LearnSpringBoot.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/student/save/gc")
    public Student createStudent() {
        Student student = new Student();
        student.setName("Bubs Mignardi");
        student.setEmail("bubs@outlook.com");
        return studentRepository.save(student);
    }

    @RequestMapping("/student/find/{email}")
    public Student findStudent(@PathVariable String email) {
        return studentRepository.findByEmail(email);
    }

    @RequestMapping("/student/find{name}")
    public List<Student> findStudentByName(@RequestParam String name) {
        return studentRepository.findByName(name);
    }

    @PutMapping("/student/update")
    public Student findStudent(@RequestParam("id") Long id, @RequestParam("email") String email) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student student1 = student.get();
            student1.setEmail(email);
            return studentRepository.save(student1);
        } else {
            return null;
        }
    }

    @GetMapping("/student/findByEmailDomain")
    public List<Student> findStudentByEmailDomain(@RequestParam("domain") String domain) {
        return studentRepository.findByDomain(domain);
    }

    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @PostMapping("/student/save")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        var student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }
}
