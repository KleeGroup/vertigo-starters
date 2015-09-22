package lollipop.services.movies;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.util.DtListBuilder;
import lollipop.domain.movies.Movie;

public final class MovieServicesImpl implements MovieServices {

	@Override
	public DtList<Movie> getAllMovies() {
		return new DtListBuilder<>(Movie.class)
				.add(new Movie(1, "Pulp Fiction", 1994))
				.add(new Movie(2, "The Good, the Bad and the Ugly", 1966))
				.add(new Movie(3, "The Godfather", 1972))
				.add(new Movie(3, "Full metal jacket", 1987))
				.add(new Movie(3, "Shinning", 1980))
				.add(new Movie(3, "Misery", 1990))
				.add(new Movie(3, "L'exorciste", 1973))
				.build();
	}
}
