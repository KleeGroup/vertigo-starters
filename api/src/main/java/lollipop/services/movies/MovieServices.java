package lollipop.services.movies;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.lang.Component;
import lollipop.domain.movies.Movie;

public interface MovieServices extends Component {
	DtList<Movie> getAllMovies();
}
