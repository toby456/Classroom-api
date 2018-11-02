package com.qa.service.business;

public interface IClassroomService {
	
	String getAllClassrooms();
	
	String createClassroom(String classroom);
	
	String updateClassroom(String classroom);
	
	String deleteClassroom(Long id);

}
