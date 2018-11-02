package com.qa.persistence.domain;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "classroom_Id")
	private Long classroomId;
	@Column(name = "classroom_Trainer", length = 200)
	private String trainer;
	/*@OneToMany(cascade=CascadeType.All)
	@JoinColumn(name = "trainees")
	private HashMap<> trainee;*/

	public Classroom() {
	}

	public Classroom(String trainer, HashMap<Long, Trainee> trainees) {
		this.trainer = trainer;
		/*this.trainees = trainees;*/
	}

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	/*public HashMap<Long, Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(HashMap<Long, Trainee> trainees) {
		this.trainees = trainees;
	}*/

}
