package com.tpe.service;

import com.tpe.controller.StudentController;
import com.tpe.domain.Student;
import com.tpe.exception.ConflictExeption;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//it will take long but updatign will be easy
@Service
public class StudentService {
    @Autowired //
    private StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //what we need to control ? we need to check if it exists or not?
    public void saveStudent(Student student) {
       if (studentRepository.existsByEmail(student.getEmail())){
           throw new ConflictExeption( "Email is already exist");
       }
        studentRepository.save(student);
    }

    public Student findStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Student with id: "+id+"is not found"));
        return student;
    }

    public void deleteStudent(Long id) {
        Student student = findStudentById(id); //if we get exception next line will run???
        studentRepository.delete(student);
    }




}
