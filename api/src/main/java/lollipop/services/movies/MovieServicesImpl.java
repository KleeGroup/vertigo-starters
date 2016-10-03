package lollipop.services.movies;

import java.util.List;

import javax.inject.Inject;

import io.vertigo.dynamo.collections.ListFilter;
import io.vertigo.dynamo.collections.model.FacetedQueryResult;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListState;
import io.vertigo.dynamo.search.model.SearchQuery;
import io.vertigo.dynamo.search.model.SearchQueryBuilder;
import io.vertigo.dynamo.store.criteria.FilterCriteriaBuilder;
import io.vertigo.dynamo.transaction.Transactional;
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
		return movieDAO.getList(new FilterCriteriaBuilder().build(), dtListState.getMaxRows().orElse(50));
	}

	@Override
	public FacetedQueryResult<Movie, SearchQuery> searchMovies(final String criteria, final List<ListFilter> listFilters, final DtListState dtListState) {
		final SearchQueryBuilder searchQueryBuilder = movieDAO.createSearchQueryBuilderMovie(criteria, listFilters);
		return movieDAO.loadList(searchQueryBuilder.build(), dtListState);
	}
}
