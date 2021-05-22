package com.backend.model.rest.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.backend.model.ProfessorModel;

@Path("/professores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessoresFacade {
	
	private static List<ProfessorModel> listaProfessores = new ArrayList<ProfessorModel>();
	
	static {
		listaProfessores.add(new ProfessorModel(1, "William", "william@gmail.com", "(55)9988776655"));
		listaProfessores.add(new ProfessorModel(2, "Will", "will@gmail.com", "(55)9988776655"));
		listaProfessores.add(new ProfessorModel(3, "Willi", "willi@gmail.com", "(55)9988776655"));
	}
	
	@GET
	public List<ProfessorModel> getProfessores() {
		return listaProfessores;
	}
	
	@POST
	public ProfessorModel salvar (ProfessorModel professor) {
		System.out.println("salvar @POST");
		System.out.println("codigo="+professor.getCodigo());
		System.out.println("nome="+professor.getNome());
		System.out.println("Email="+professor.getEmail());
		System.out.println("Fone="+professor.getCelular());
		listaProfessores.add(professor);
		return null;
	}
	
	@PUT
	public void atualizar (ProfessorModel professor) {
		System.out.println("atualizar @PUT");
		System.out.println("codigo="+professor.getCodigo());
		System.out.println("nome="+professor.getNome());
		System.out.println("Email="+professor.getEmail());
		System.out.println("Fone="+professor.getCelular());
		listaProfessores.remove(professor);
		listaProfessores.add(professor);
	}
	
	@DELETE
	@Path("/{codigoProfessor}")
	public void excluir(@PathParam("codigoProfessor") Integer codigoProfessor) {
		System.out.println("excluir @DELETE");
		ProfessorModel professor = new ProfessorModel();
		professor.setCodigo(codigoProfessor);
		listaProfessores.remove(professor);
	}

}
