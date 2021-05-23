package com.backend.model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.backend.model.dao.ProfessorDaoImplementation;
import com.backend.model.model.ProfessorModel;

@Path("/professores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessoresFacade {
	
	@Inject
	private ProfessorDaoImplementation professorDaoImplement;
	
	@GET
	public List<ProfessorModel> getProfessores(){
		return professorDaoImplement.getProfessores();
	}
	
}
