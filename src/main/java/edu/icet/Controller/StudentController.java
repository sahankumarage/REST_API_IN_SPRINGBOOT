package edu.icet.Controller;

import edu.icet.dao.GuardianEntity;
import edu.icet.dao.StudentEntity;
import edu.icet.service.StudentService;
import edu.icet.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    //Dependency Injection
    //Spring Boot Framework

    @Autowired
    StudentService service;


    @PostMapping
    public void createStudent(@RequestBody Student student){
        service.registerStudent(student);
    }

    @GetMapping
    public List<Student> retrieveAllStudents(){
        return service.retrieveAllStudents();
    }

    @GetMapping("/retrieve-student/{name}")
    public Iterable<StudentEntity> retrieveStudentByAddress(
            @RequestParam String name) {
        return service.retrieveStudentByAddress(name);
    }

}


