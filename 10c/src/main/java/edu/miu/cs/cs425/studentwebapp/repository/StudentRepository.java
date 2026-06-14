package edu.miu.cs.cs425.studentwebapp.repository;

import edu.miu.cs.cs425.studentwebapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
