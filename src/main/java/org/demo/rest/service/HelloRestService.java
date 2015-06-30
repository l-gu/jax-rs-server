package org.demo.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloRestService {

	// This method is called if nothing is requested  
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello Jersey";
	}
	
	// This method is called if XML is requested  
	@GET  
	@Produces(MediaType.TEXT_XML) // Request Header : "Accept : text/xml"
	public String sayHelloXML() {  
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";  
	}

	// This method is called if XML is requested  
	@GET  
	@Produces(MediaType.APPLICATION_JSON) // Request Header : "Accept : text/xml"
	public String sayHelloJSON() {  
		return "{ \"message\" : \"Hello Jersey\" }";  
	}
	
	// If "Accept : type" is not produced by the service : HTTP 406 Inacceptable
}
