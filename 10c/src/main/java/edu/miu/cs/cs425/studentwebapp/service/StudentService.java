package edu.miu.cs.cs425.studentwebapp.service;

import edu.miu.cs.cs425.studentwebapp.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudents();

    Optional<Student> findStudentById(Long studentId);

    Student saveStudent(Student student);

    void deleteStudentById(Long studentId);
}
