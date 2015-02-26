package lollipop.services.movies;

import io.vertigo.util.ListBuilder;

import java.util.List;

import lollipop.domain.movies.Movie;

public final class MovieServicesImpl implements MovieServices {

	@Override
	public List<Movie> getAllMovies() {
		return new ListBuilder<Movie>()
				.add(new Movie(1, "Pulp Fiction", 1994))
				.add(new Movie(2, "The Good, the Bad and the Ugly", 1966))
				.add(new Movie(3, "The Godfather", 1972))
				.build();
	}
}
