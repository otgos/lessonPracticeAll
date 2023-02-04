package com.tpe.service;

import com.tpe.controller.StudentController;
import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import com.tpe.exception.ConflictExeption;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    public void updateStudent(Long id, StudentDTO studentDTO) {
        boolean existEamil = studentRepository.existsByEmail(studentDTO.getEmail());
        Student student = findStudentById(id);
        //what we need control here???
        //email needs to be checked:
            //1. if email is the same??
            //2. if different then the email exist in database...
        if(existEamil && !studentDTO.getEmail().equals(student.getEmail())){
            throw new ConflictExeption("Email is already exist");
        }
        /*
             1. dto -> otgo@gmail, DB -> otgo@gmail
                otgo@gmail True and not true ---> updates
            2. DB --> otgo and DTO otgos@gmail.com but there is someone else whose email is otgos@gmailc,om
                T && Not False --> exception

            3. DB --> otgo , DTO --> xxx@gmail.com (not in DB)
                F && updates


         */

        student.setGrade(studentDTO.getGrade());
        student.setLastName(studentDTO.getLastName());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());

        studentRepository.save(student);
    }

    public Page<Student> getAllStudentWithPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public List<Student> findStudent(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    public List<Student> getStudentByGrade(Integer grade) {
        return studentRepository.findByStudentByGrade(grade);
    }

    public StudentDTO findStudentDTOById(Long id) {
        return studentRepository.findStudentDTOById(id).orElseThrow(()->
                new ResourceNotFoundException("Student not found with id: "+id));
    }
}
