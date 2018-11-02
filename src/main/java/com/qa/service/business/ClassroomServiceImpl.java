package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.ClassroomdbRepository;

public class ClassroomServiceImpl implements IClassroomService{

	@Inject
	private ClassroomdbRepository repo;
	
	private static final Logger LOGGER = Logger.getLogger(IClassroomService.class);

	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);	
	}

	@Override
	public String updateClassroom(String classroom) {
		return repo.updateClassroom(classroom);
	}

	@Override
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

}
