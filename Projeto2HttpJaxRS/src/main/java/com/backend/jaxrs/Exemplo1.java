package com.backend.jaxrs;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/exemplowsrs")
public class Exemplo1 {
	
	@GET
	public String executarGet() {
		return "Video aula back end, executou um GET";
	}
	
	@POST
	public String executaPost() {
		return "Video aula back end, executou um POST";
	}
	
	@DELETE
	public String deletar() {
		return "Video aula back end, executou um DELETE";
	}

}
