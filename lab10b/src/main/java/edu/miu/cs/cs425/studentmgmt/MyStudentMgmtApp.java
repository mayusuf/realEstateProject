package edu.miu.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {
	private final StudentRepository studentRepository;

	public MyStudentMgmtApp(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) {
		Transcript transcript = new Transcript(1L, "BS Computer Science");
		Classroom classroom = new Classroom(1L, "McLaughlin building", "M105");
		Course course = new Course(1L, "CS401", "Modern Prog Practices");
		Student student = new Student(1L, "000-61-0001", "Anna", "Lynn", "Smith", 3.45,
				LocalDate.of(2019, 5, 24));

		student.setTranscript(transcript);
		student.setClassroom(classroom);
		student.addCourse(course);

		saveStudent(student);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
