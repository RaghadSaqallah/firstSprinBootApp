/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Raghad.springbootapp.Controller;

import com.Raghad.springbootapp.Model.Student;
import com.Raghad.springbootapp.Repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AL
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/add")
    public String addٍStudent(@RequestParam String name, @RequestParam String major, @RequestParam String grade) {
        Student s = new Student();
        s.setName(name);
        s.setGrade(grade);
        s.setMajor(major);
        repository.save(s);
        return "Studetn " + name + " saved";
    }

    // لعرض كل الطلاب (GET)
    @GetMapping("/all")
    public List<Student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
        return "studetn with " + id + "has been deleted";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable int id,
            @RequestParam String name,
            @RequestParam String major,
            @RequestParam String grade) {
        Student s = repository.findById(id).get();

            if (s != null) {

                s.setName(name);
                s.setMajor(major);
                s.setGrade(grade);
                repository.save(s);
                return "Student with id " + id + " has been updated";
            } else {
                return "Student with" + id + "is not exist";
            }
    }
}
