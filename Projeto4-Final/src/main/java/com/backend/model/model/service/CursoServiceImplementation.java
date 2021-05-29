package com.backend.model.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.backend.model.dao.CursoDaoInterface;
import com.backend.model.model.CursoModel;

public class CursoServiceImplementation implements CursoServiceInterface {
	
	@Inject
	private CursoDaoInterface cursoDaoInterface;

	@Override
	@Transactional
	public CursoModel salvarCurso(CursoModel cursoModel) {
		return cursoDaoInterface.salvarCurso(cursoModel);
	}

	@Override
	@Transactional
	public void alterar(CursoModel cursoModel) {
		cursoDaoInterface.alterar(cursoModel);
	}

	@Override
	@Transactional
	public void excluir(CursoModel cursoModel) {
		cursoDaoInterface.excluir(cursoModel);

	}

	@Override
	public List<CursoModel> getCursos() {
		return cursoDaoInterface.getCursos();
	}

}
