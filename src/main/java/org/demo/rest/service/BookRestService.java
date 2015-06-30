package org.demo.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.demo.bean.Book;
import org.demo.env.RepositoryProvider;
import org.demo.repository.BookRepository;

@Path("/book")
public class BookRestService {

	BookRepository bookRepository = RepositoryProvider.getBookRepository(); 
			
	/**
	 * Get all 'Book' resources (http GET) 
	 * @return
	 */
	@GET
	// No @PATH @Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Book> list = bookRepository.getAll();
		GenericEntity<List<Book>> wrapper = 
			new GenericEntity<List<Book>>(list) {
		};
		return Response.ok(wrapper).build();
	}
	
	/**
	 * Get 'Book' resource by id (http GET) 
	 * If id not integer : 404 not found
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById( final @PathParam("id") int id ) {
		Book book = bookRepository.getById(id);
		ResponseBuilder responseBuilder = Response.ok(book) ;
		return responseBuilder.build();
	}
	
	/**
	 * Save the given 'Book' (http POST)
	 * @param book
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveBook(final Book book) {
		Book bookSaved = bookRepository.save(book);
		return Response.ok(bookSaved).build();
	}
	
	/**
	 * Delete 'Book' resource by id (http DELETE) 
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	public Response deleteBook(final @PathParam("id") int id) {
		bookRepository.deleteById(id);
		return Response.ok().build();
	}
}
