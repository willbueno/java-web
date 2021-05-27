package com.backend.model.model.service;

import java.util.List;

import com.backend.model.model.ProfessorModel;

public interface ProfessorServiceInterface {
	
public ProfessorModel salvarProfessor(ProfessorModel professorModel);
	
	public void alterar(ProfessorModel professorModel);
	
	public void excluir(ProfessorModel professorModel);
	
	public List<ProfessorModel> getProfessores();

}
