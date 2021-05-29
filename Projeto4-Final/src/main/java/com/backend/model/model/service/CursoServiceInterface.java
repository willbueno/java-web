package com.backend.model.model.service;

import java.util.List;

import com.backend.model.model.CursoModel;

public interface CursoServiceInterface {
	
	public CursoModel salvarCurso(CursoModel cursoModel);
	
	public void alterar(CursoModel cursoModel);
	
	public void excluir(CursoModel cursoModel);
	
	public List<CursoModel> getCursos();

}
