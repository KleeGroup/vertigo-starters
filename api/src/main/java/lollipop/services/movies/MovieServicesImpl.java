package lollipop.services.movies;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListState;
import io.vertigo.dynamo.store.criteria.FilterCriteriaBuilder;
import io.vertigo.dynamo.transaction.Transactional;

import javax.inject.Inject;

import lollipop.dao.movies.MovieDAO;
import lollipop.domain.movies.Movie;

@Transactional
public class MovieServicesImpl implements MovieServices {

	@Inject
	private MovieDAO movieDAO;

	@Override
	public Movie get(final Long movId) {
		return movieDAO.get(movId);
	}

	@Override
	public void save(final Movie movie) {
		movieDAO.save(movie);
	}

	@Override
	public DtList<Movie> getMovies(final DtListState dtListState) {
		return movieDAO.getList(new FilterCriteriaBuilder().build(), dtListState.getMaxRows().getOrElse(50));
	}
}
