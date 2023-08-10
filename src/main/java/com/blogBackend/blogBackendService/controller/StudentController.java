package com.blogBackend.blogBackendService.controller;

import com.blogBackend.blogBackendService.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/student")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student toReturn = new Student(1, "Prajwal", "Shenoy");
//        return new ResponseEntity<>(toReturn, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "custom value for header").body(toReturn);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Prajwal", "Shenoy"));
        students.add(new Student(2, "Paarthvi", "Sharma"));
        students.add(new Student(3, "Sanath", "Naik"));
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/student/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    @GetMapping("/students/{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName) {
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    @PostMapping("/student/create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student>  createStudent(@RequestBody Student student) {
        System.out.println(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}/update")
    public ResponseEntity<Student>  updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println("Updating student with id: " + id + " " + student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/student/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        String toReturn = "Deleting the student with user ID " + id;
        System.out.println(toReturn);
        return ResponseEntity.ok(toReturn);
    }
}
