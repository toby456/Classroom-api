package com.qa.persistence.repository;

public interface IClassroomRepository {
	
	String getAllClassrooms();
	
	String createClassroom(String classroom);
	
	String updateClassroom(String classroomToUpdate);
	
	String deleteClassroom(Long id);
	
}
