package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository ;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent (){
        return  studentRepository.findAll();

    }

    public void addNewStudent(Student student)  {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail()) ;
        if(studentOptional.isPresent()){
            try {
                throw new IllegalAccessException("This email already exist");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        studentRepository.save(student);


    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            try {
                throw new IllegalAccessException("student with id :"+ studentId + "is exist") ;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        studentRepository.deleteById(studentId);

    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email){


    }
}
