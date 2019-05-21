package ${package}.${projectNameLowerCase}.${businessModuleLowerCase}.controllers;

import java.util.stream.Stream;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ${package}.${projectNameLowerCase}.${businessModuleLowerCase}.domain.Movie;
import ${package}.${projectNameLowerCase}.${businessModuleLowerCase}.services.MovieServices;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.util.VCollectors;
import io.vertigo.ui.core.ViewContext;
import io.vertigo.ui.core.ViewContextKey;
import io.vertigo.ui.impl.springmvc.controller.AbstractVSpringMvcController;

@Controller
@RequestMapping("/${businessModuleLowerCase}/movies")
public class MovieListController extends AbstractVSpringMvcController {

	private static final ViewContextKey<Movie> moviesKey = ViewContextKey.of("movies");

	@Inject
	private MovieServices movieServices;

	@GetMapping("/")
	public void initContext(final ViewContext viewContext) {
		//final DtList<Movie> movies = personServices.getPersons(dtListState)); real code
		// here is some test code just to have a working example
		final Movie aMovie = new Movie();
		aMovie.setMovId(1000L);
		aMovie.setName("Pulp Fiction");
		aMovie.setYear(1994);
		aMovie.setImdbid("tt0110912");
		final DtList<Movie> movies = Stream.of(aMovie).collect(VCollectors.toDtList(Movie.class));
		viewContext.publishDtList(moviesKey, movies);
	}

}

