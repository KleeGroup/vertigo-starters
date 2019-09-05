package ${package}.${businessModuleLowerCase}.webservices;

import java.util.stream.Stream;

import javax.inject.Inject;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.util.VCollectors;
import io.vertigo.vega.webservice.WebServices;
import io.vertigo.vega.webservice.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.webservice.stereotype.GET;
import io.vertigo.vega.webservice.stereotype.PathPrefix;

import ${package}.${businessModuleLowerCase}.domain.Movie;
import ${package}.${businessModuleLowerCase}.services.MovieServices;

@PathPrefix("/movies")
public class MovieWebServices implements WebServices {
	
	@Inject
	private MovieServices movieServices;

	@AnonymousAccessAllowed
	@GET("/")
	public DtList<Movie> getMovies() {
		//final DtList<Movie> movies = personServices.getPersons(dtListState)); real code
		// here is some test code just to have a working example
		final Movie aMovie = new Movie();
		aMovie.setMovId(1000L);
		aMovie.setName("Pulp Fiction");
		aMovie.setYear(1994);
		aMovie.setImdbid("tt0110912");
		final DtList<Movie> movies = Stream.of(aMovie).collect(VCollectors.toDtList(Movie.class));
		return movies;
	}



}

