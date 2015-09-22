package lollipop.webservices.movies;

import io.vertigo.vega.webservice.WebServices;
import io.vertigo.vega.webservice.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.webservice.stereotype.GET;
import io.vertigo.vega.webservice.stereotype.PathParam;
import io.vertigo.vega.webservice.stereotype.PathPrefix;

import java.util.List;

import javax.inject.Inject;

import lollipop.domain.movies.Movie;
import lollipop.services.movies.MovieServices;

@PathPrefix("/movies")
public class MovieWebServices implements WebServices {
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
