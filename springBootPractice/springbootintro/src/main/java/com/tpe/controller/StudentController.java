package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import com.tpe.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//i am goig to use rest
@RequestMapping("/students") //http://localhostL8080/students dispatcher servlet will send it here
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

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
    //what we need for update student???
    //1. id
    //2. student object from user side

    @PutMapping("{id}") //http://localhost:8080/students/1 +put +JSON
    public ResponseEntity<Map<String, String>> updateStudent(@PathVariable("id") Long id,
                                                             @Valid @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(id, studentDTO);
        Map<String, String> map= new HashMap<>(); // why we are not autowiring this?? because this is used once
        map.put("message", "Student is updated successfully");
        map.put("status", "ture");
        return new ResponseEntity<>(map, HttpStatus.OK); //return ResponseEntity.ok(map)
    }

    //pageable

    @GetMapping("/page")
    public ResponseEntity<Page<Student>> getAllWithPage(@RequestParam ("page")int page, //page numbers starting from 0
                                                        @RequestParam ("size") int size, //how many students per page
                                                        @RequestParam("sort") String prop, //sorting filed
                                                        @RequestParam("direction")Sort.Direction direction){ //assecning or desce
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<Student> studentPage = studentService.getAllStudentWithPage(pageable);
        return ResponseEntity.ok(studentPage);
    }
    //get by lastName

    @GetMapping("/querylastname")     //http://localhost:8080/students/querylastname +GET
    public ResponseEntity<List<Student>> getStudentByLastName(@RequestParam ("lastName") String lastName){
        List<Student> list = studentService.findStudent(lastName);
        return ResponseEntity.ok(list);

    }

    //get all student by grade (JPQL) Java Persistence Query Language

    @GetMapping("/grade/{grade}")  //http://localhost:8080/students/grade/89 + GET
    public ResponseEntity<List<Student>> getStudentByGrade(@PathVariable ("grade") Integer grade){

        List<Student> list = studentService.getStudentByGrade(grade);
        return ResponseEntity.ok(list);

    }

    //Can we get data as DTO from fram DB?

    @GetMapping("/query/dtp")  //http://localhost:8080/students/query/dtp?id=1
    public ResponseEntity<StudentDTO> getStudentDTO(@RequestParam("id") Long id){
        StudentDTO studentDTO = studentService.findStudentDTOById(id);
        return ResponseEntity.ok(studentDTO);
    }


    @GetMapping("/welcome")  //http://localhost:8080/students/welcome + get
    public String weclcome(HttpServletRequest request){
        logger.warn("--------------Welcome{}", request.getServletPath());
        return "Welcome to Student controller!";
    }



}
