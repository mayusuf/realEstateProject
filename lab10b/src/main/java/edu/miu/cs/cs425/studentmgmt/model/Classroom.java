package edu.miu.cs.cs425.studentmgmt.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "classrooms")
public class Classroom {
	@Id
	private Long classroomId;

	@Column(nullable = false)
	private String buildingName;

	@Column(nullable = false)
	private String roomNumber;

	@OneToMany(mappedBy = "classroom")
	private List<Student> students = new ArrayList<>();

	public Classroom() {
	}

	public Classroom(Long classroomId, String buildingName, String roomNumber) {
		this.classroomId = classroomId;
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
