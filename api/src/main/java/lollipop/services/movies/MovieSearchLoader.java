package lollipop.services.movies;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.vertigo.dynamo.domain.metamodel.DtDefinition;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.domain.util.DtObjectUtil;
import io.vertigo.dynamo.search.SearchManager;
import io.vertigo.dynamo.search.metamodel.SearchChunk;
import io.vertigo.dynamo.search.metamodel.SearchIndexDefinition;
import io.vertigo.dynamo.search.model.SearchIndex;
import io.vertigo.dynamo.task.TaskManager;
import io.vertigo.dynamo.transaction.VTransactionManager;
import io.vertigo.dynamox.search.AbstractSqlSearchLoader;
import lollipop.domain.movies.Movie;
import lollipop.domain.search.Dummy;

public final class MovieSearchLoader extends AbstractSqlSearchLoader<Long, Movie, Movie> {
	private final SearchIndexDefinition indexDefinition;

	@Inject
	private MovieServices movieServices;

	/**
	 * Constructor.
	 * @param taskManager Task manager
	 * @param searchManager Search manager
	 */
	@Inject
	public MovieSearchLoader(final TaskManager taskManager, final SearchManager searchManager, final VTransactionManager transactionManager) {
		super(taskManager, transactionManager);
		indexDefinition = searchManager.findIndexDefinitionByKeyConcept(Movie.class);
	}

	/** {@inheritDoc} */
	@Override
	public List<SearchIndex<Movie, Movie>> loadData(final SearchChunk<Movie> searchChunk) {
		final List<URI<Movie>> uris = searchChunk.getAllURIs();
		final List<SearchIndex<Movie, Movie>> result = new ArrayList<>();
		final DtDefinition dtDefinition = DtObjectUtil.findDtDefinition(Movie.class);
		for (final Movie movie : loadMovieList(uris)) {
			final URI<Movie> movieUri = new URI<>(dtDefinition, movie.getMovId());
			result.add(SearchIndex.createIndex(indexDefinition, movieUri, movie));
		}
		return result;
	}

	private final DtList<Movie> loadMovieList(final List<URI<Movie>> uris) {
		final DtList<Dummy> dtcMovieIds = new DtList<>(Dummy.class);
		for (final URI<Movie> movieUri : uris) {
			final Dummy dummy = new Dummy();
			dummy.setDummyLong(Long.class.cast(movieUri.getId()));
			dtcMovieIds.add(dummy);
		}
		return movieServices.getMovieIndex(dtcMovieIds);
	}
}
