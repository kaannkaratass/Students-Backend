package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
    private final StudentService studentService ;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;

    }

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();

    }

    @PostMapping
    public void  registerNewStudent(@RequestBody Student student){  //Burada yapılan verilen ricayı al. Studenta yaz gibi düşün.
        studentService.addNewStudent(student);

    }
    @DeleteMapping(path = {"studentId"})
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId) ;

    }
    @PutMapping(path = {"studentId"})
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
            studentService.updateStudent(studentId, name, email) ;
    }

    }


