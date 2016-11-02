package lollipop.services.movies;

import java.util.List;

import io.vertigo.dynamo.collections.ListFilter;
import io.vertigo.dynamo.collections.model.FacetedQueryResult;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListState;
import io.vertigo.dynamo.search.model.SearchQuery;
import io.vertigo.lang.Component;
import lollipop.domain.movies.Movie;
import lollipop.domain.search.Dummy;

public interface MovieServices extends Component {

	DtList<Movie> getMovies(DtListState dtListState);

	void save(Movie movie);

	Movie get(Long movId);

	FacetedQueryResult<Movie, SearchQuery> searchMovies(String criteria, List<ListFilter> listFilters, DtListState dtListState);

	DtList<Movie> getMovieIndex(final DtList<Dummy> dtcMovieIds);
}
