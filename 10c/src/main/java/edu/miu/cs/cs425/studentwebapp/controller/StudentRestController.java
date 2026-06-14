package edu.miu.cs.cs425.studentwebapp.controller;

import edu.miu.cs.cs425.studentwebapp.model.Student;
import edu.miu.cs.cs425.studentwebapp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> getStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        return studentService.findStudentById(studentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setStudentId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        if (studentService.findStudentById(studentId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        student.setStudentId(studentId);
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        if (studentService.findStudentById(studentId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        studentService.deleteStudentById(studentId);
        return ResponseEntity.noContent().build();
    }
}
