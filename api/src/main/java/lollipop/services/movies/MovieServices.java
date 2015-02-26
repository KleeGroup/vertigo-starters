package lollipop.services.movies;

import io.vertigo.lang.Component;

import java.util.List;

import lollipop.domain.movies.Movie;

public interface MovieServices extends Component {
	List<Movie> getAllMovies();
}
