package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomdbRepository;

public class ClassroomServiceImpl implements IClassroomService{

	@Inject
	private ClassroomdbRepository repo;

	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);	
	}

	@Override
	public String updateClassroom(String classroomToUpdate) {
		return repo.updateClassroom(classroomToUpdate);
	}

	@Override
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

}
