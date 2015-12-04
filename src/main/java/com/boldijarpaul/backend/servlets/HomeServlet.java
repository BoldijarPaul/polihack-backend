package com.boldijarpaul.backend.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/info")
public class HomeServlet {

	@GET
	@Path("")
	public String getText() {
		return "Cool API";
	}
}
