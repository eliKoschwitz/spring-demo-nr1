package com.example.FullSpringBasic.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
        //return List.of( new Student(1L, "Elias", "e.koschwitz@googlemail.com", LocalDate.of(1992, Month.APRIL, 6),30));
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByMail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
        //System.out.println(student);
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id" + studentId + " does not exists")


    }
    /*
    SO HÄTTE ICH DIE AUFGABE VERSUCHT ZU LÖSEN ...
    @Autowired
    private final Student student;
    // put is used to update name and email form the student. @Transactional leads to that you have not to implement sql Query.
    @Transactional
    public void updateStudent(){
        student.setEmail();
        student.setName();
    }
     */



}
