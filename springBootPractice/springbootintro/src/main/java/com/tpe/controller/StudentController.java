package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//i am goig to use rest
@RequestMapping("/students") //http://localhostL8080/students dispatcher servlet will send it here
public class StudentController {


    @Autowired
    private StudentService studentService;


    //which http methods i am going to use to get  list of students? it should be not [] bu list
    // we are going to create json data
    // return json + http status code
    @GetMapping //http://localhost:8080/students +Get
    public ResponseEntity<List<Student>> getAll(){ // i will aslo return http status code
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students); // OK is for 200 status code
    }

    @PostMapping //http://localhost:8080/students + Post +JSON
    //what do we need ore
    public  ResponseEntity<Map<String, String>> createStudent(@Valid @RequestBody Student student){
        //@Valid --> validates fields of student object
        //@RequestBody--> maps the Student obj
        studentService.saveStudent(student);

        Map<String, String> map= new HashMap<>(); // why we are not autowiring this?? because this is used once
        map.put("message", "Student is created successfully");
        map.put("status", "ture");
        return new ResponseEntity<>(map, HttpStatus.CREATED);

    }

    //get student by id
    //does it need endpoint? yes.. we have already endpoint with get
    @GetMapping ("/query") //http://localhost:8080/students/query ?id=1 //when it is with request param
    //if there is one data we do not set id in request param, but if we need more then we must have many
    public ResponseEntity<Student> getStudentById(@RequestParam ("id") Long id){
        Student student = studentService.findStudentById(id);
        return ResponseEntity.ok(student);
    }

    //both of them can be used for getting multiple variables... !
    // RequestParam is better because we can see the variable name

    //get by id using @PathVariable

    @GetMapping("/{id}")  //http://localhost:8080/students/1 +get
    public ResponseEntity<Student> getStudentByIdUsingPath(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        return ResponseEntity.ok(student);
    }


    //delete
    @DeleteMapping("{id}")//http://localhost:8080/students/1 +Delete
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable Long id){ //optional w
        studentService.deleteStudent(id);
        Map<String, String> map= new HashMap<>(); // why we are not autowiring this?? because this is used once
        map.put("message", "Student is delete successfully");
        map.put("status", "ture");
        return new ResponseEntity<>(map, HttpStatus.OK); //return ResponseEntity.ok(map)
    }

}
