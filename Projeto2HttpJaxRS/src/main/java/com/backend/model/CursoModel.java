package com.backend.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CursoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nome;
	private String diashorarios;
	
	private ProfessorModel professorModel;
	
	public CursoModel() {
	}
	
	public CursoModel(Integer codigo, String nome, String diashorarios, ProfessorModel professorModel) {
		this.codigo = codigo;
		this.nome = nome;
		this.diashorarios = diashorarios;
		this.professorModel = professorModel;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiashorarios() {
		return diashorarios;
	}

	public void setDiashorarios(String diashorarios) {
		this.diashorarios = diashorarios;
	}

	public ProfessorModel getProfessorModel() {
		return professorModel;
	}

	public void setProfessorModel(ProfessorModel professorModel) {
		this.professorModel = professorModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoModel other = (CursoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}