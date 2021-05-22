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

import com.backend.model.CursoModel;
import com.backend.model.ProfessorModel;

@Path("/cursos")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class CursosFacade {
	
	private static List<CursoModel> listaCursos = new ArrayList<CursoModel>();
	
	static {
		listaCursos.add(new CursoModel(1, "Java", "Segunda as 18 horas",
				new ProfessorModel(1, "William", "william@gmail.com", "(55)9988776655")));
		listaCursos.add(new CursoModel(2, "Delphi", "Tercas as 19 horas",
				new ProfessorModel(2, "Will", "will@gmail.com", "(55)9988776655")));
		listaCursos.add(new CursoModel(3, "Arduino", "Sextas as 18 horas", 
				new ProfessorModel(3, "Willi", "willi@gmail.com", "(55)9988776655")));
	}
	
	@GET
	public List<CursoModel> getCursos() {
		return listaCursos;
	}
	
	@POST
	public CursoModel salvar (CursoModel curso) {
		System.out.println("salvar @POST");
		listaCursos.add(curso);
		return curso;
	}
	
	@PUT
	public void atualizar (CursoModel curso) {
		System.out.println("atualizar @PUT");
		listaCursos.remove(curso);
		listaCursos.add(curso);
	}
	
	@DELETE
	@Path("/{codigoCurso}")
	public void excluir(@PathParam("codigoCurso") Integer codigoCurso) {
		System.out.println("excluir @DELETE");
		CursoModel curso = new CursoModel();
		curso.setCodigo(codigoCurso);
		listaCursos.remove(curso);
	}

}
