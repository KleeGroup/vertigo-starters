package lollipop.webservices.movies;

import io.vertigo.vega.webservice.WebServices;
import io.vertigo.vega.webservice.model.UiListState;
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
	public Movie getMovie(@PathParam("id") final long id) {
		return movieServices.get(id);
	}

	@AnonymousAccessAllowed
	@GET("/")
	public List<Movie> getMovies(final UiListState uiListState) {
		return movieServices.getMovies(uiListState.toDtListState());
	}

}
