package com.backend.model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.backend.model.model.ProfessorModel;
import com.backend.model.model.service.ProfessorServiceInterface;

@Path("/professores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessoresRestFacade {
	
	/* Sem o uso de servicos
	@Inject
	private ProfessorDaoImplementation professorDaoImplement;
	
	@GET
	public List<ProfessorModel> getProfessores(){
		return professorDaoImplement.getProfessores();
	}
	 */
	
	@Inject
	private ProfessorServiceInterface professorServiceInterface;
	
	@GET
	public List<ProfessorModel> getProfessores(){
		return professorServiceInterface.getProfessores();
	}
	
	@POST
	public ProfessorModel salvarProfessores(ProfessorModel professorModel){
		return professorServiceInterface.salvarProfessor(professorModel);
	}
	
	@PUT
	public void atualizar(ProfessorModel professorModel) {
		professorServiceInterface.alterar(professorModel);
	}
	
	@DELETE
	@Path("/{codigoProfessor}")
	public void deletar(@PathParam("codigoProfessor") Integer codigoProfessor) {
		ProfessorModel professorModel = new ProfessorModel();
		professorModel.setCodigo(codigoProfessor);
		professorServiceInterface.excluir(professorModel);
		
	}
	
}