package com.example.demo.web.rest;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {
    @GetMapping("/students/all")
    public ResponseEntity getAll(){
        Student student = new Student(1L, "Jahongir", "Sherjonov", "Java Back-End");
        Student student2 = new Student(2L, "Zoxidjon", "Sherjonov", "Iqtisod");
        Student student3 = new Student(3L, "Abror", "Aminov", "Bank ishi");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        students.add(student3);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student = new Student(id, "Jahongir", "Sherjonov", "Java Back-End");
        return ResponseEntity.ok(student);
    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course){
        Student student = new Student(id, name, lastName, course);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Student studentNew){
        Student student = new Student(1L, "Jahongir", "Sherjonov", "Java Back-End");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Student student = new Student(1L, "Jahongir", "Sherjonov", "Java Back-End");
        return ResponseEntity.ok("Student with id: " + id + " is deleted");
    }
}
