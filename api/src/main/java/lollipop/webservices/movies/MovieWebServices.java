package lollipop.webservices.movies;

import io.vertigo.vega.rest.RestfulService;
import io.vertigo.vega.rest.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.rest.stereotype.GET;
import io.vertigo.vega.rest.stereotype.PathParam;
import io.vertigo.vega.rest.stereotype.PathPrefix;

import java.util.List;

import javax.inject.Inject;

import lollipop.domain.movies.Movie;
import lollipop.services.movies.MovieServices;

@PathPrefix("/movies")
public class MovieWebServices implements RestfulService {
	@Inject
	private MovieServices movieServices;

	@GET("/{id}")
	@AnonymousAccessAllowed
	public String helloWorldWithNumber(@PathParam("id") final int id) {
		return movieServices.getAllMovies().get(id).getName();
	}

	//
	//	@GET("/index")
	//	@AnonymousAccessAllowed
	//	public String helloWorld() {
	//		return "Hello world";
	//	}

	@AnonymousAccessAllowed
	@GET("/")
	public List<Movie> getAllMovies() {
		return movieServices.getAllMovies();
	}

}
