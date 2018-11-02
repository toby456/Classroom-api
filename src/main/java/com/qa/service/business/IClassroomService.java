package com.qa.service.business;

public interface IClassroomService {
	
	String getAllClassrooms();
	
	String createClassroom(String classroom);
	
	String deleteClassroom(Long id);

	String updateClassroom(String classroom);

}
