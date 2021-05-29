package com.backend.model.dao;

import java.util.List;

import com.backend.model.model.CursoModel;

public interface CursoDaoInterface {
	
	public CursoModel salvarCurso(CursoModel cursoModel);
	
	public void alterar(CursoModel cursoModel);
	
	public void excluir(CursoModel cursoModel);
	
	public List<CursoModel> getCursos();

}
