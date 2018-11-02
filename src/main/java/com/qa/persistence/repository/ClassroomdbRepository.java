package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import java.util.Collection;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class ClassroomdbRepository implements IClassroomRepository {
	
	/*private static final Logger LOGGER = Logger.getLogger()(ClassroomdbRepository.class);*/

	@PersistenceContext(unitName = "primary")
	private EntityManager crManager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllClassrooms() {
		Query query = crManager.createQuery("SELECT a FROM Classroom a");
		Collection<Classroom> classroom = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classroom);
	}

	@Override
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom anClassroom = util.getObjectForJSON(classroom, Classroom.class);
		crManager.persist(anClassroom);
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String updateClassroom(String classroomToUpdate) {
		Classroom updatedClassroom = util.getObjectForJSON(classroomToUpdate, Classroom.class);
		Classroom classroomFromDB = findClassroom(updatedClassroom.getClassroomId());
		if (classroomFromDB != null) {
			crManager.merge(updatedClassroom);
			return "{\"message\": \"account sucessfully updated\"}";
		}
		else return "{\"message\": \"account does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			crManager.remove(classroomInDB);
			return "Account " + id + " has been removed";
		} else
			return "Account not found";
	}

	private Classroom findClassroom(Long id) {
		return crManager.find(Classroom.class, id);
	}


}
