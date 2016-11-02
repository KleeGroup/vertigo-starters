package lollipop.dao.movies;

import java.util.List;

import javax.inject.Inject;

import io.vertigo.app.Home;
import io.vertigo.core.component.di.injector.Injector;
import io.vertigo.dynamo.collections.ListFilter;
import io.vertigo.dynamo.collections.metamodel.FacetedQueryDefinition;
import io.vertigo.dynamo.collections.metamodel.ListFilterBuilder;
import io.vertigo.dynamo.collections.model.FacetedQueryResult;
import io.vertigo.dynamo.domain.model.DtListState;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.impl.store.util.DAO;
import io.vertigo.dynamo.search.SearchManager;
import io.vertigo.dynamo.search.metamodel.SearchIndexDefinition;
import io.vertigo.dynamo.search.model.SearchQuery;
import io.vertigo.dynamo.search.model.SearchQueryBuilder;
import io.vertigo.dynamo.store.StoreManager;
import io.vertigo.dynamo.store.StoreServices;
import io.vertigo.dynamo.task.TaskManager;
import io.vertigo.dynamo.task.metamodel.TaskDefinition;
import io.vertigo.dynamo.task.model.Task;
import io.vertigo.dynamo.task.model.TaskBuilder;
import lollipop.domain.movies.Movie;

/**
 * DAO : Accès à un object (DTO, DTC).
 * MovieDAO
 */
public final class MovieDAO extends DAO<Movie, java.lang.Long> implements StoreServices {
	private final SearchManager searchManager;

	/**
	 * Contructeur.
	 * @param storeManager Manager de persistance
	 * @param taskManager Manager de Task
	 * @param searchManager Manager de Search
	 */
	@Inject
	public MovieDAO(final StoreManager storeManager, final TaskManager taskManager, final SearchManager searchManager) {
		super(Movie.class, storeManager, taskManager);
		this.searchManager = searchManager;
	}

	/**
	 * Indique que le keyConcept associé à cette uri va être modifié.
	 * Techniquement cela interdit les opérations d'ecriture en concurrence
	 * et envoie un évenement de modification du keyConcept (à la fin de transaction eventuellement)
	 * @param uri URI du keyConcept modifié
	 * @return KeyConcept à modifier
	 */
	public Movie readForUpdate(final URI<Movie> uri) {
		return dataStore.readForUpdate(uri);
	}

	/**
	 * Indique que le keyConcept associé à cet id va être modifié.
	 * Techniquement cela interdit les opérations d'ecriture en concurrence
	 * et envoie un évenement de modification du keyConcept (à la fin de transaction eventuellement)
	 * @param id Clé du keyConcept modifié
	 * @return KeyConcept à modifier
	 */
	public Movie readForUpdate(final java.lang.Long id) {
		return readForUpdate(createDtObjectURI(id));
	}

	/**
	 * Création d'une SearchQuery de type : Movie.
	 * @param criteria Critères de recherche
	 * @param listFilters Liste des filtres à appliquer (notament les facettes sélectionnées)
	 * @return SearchQueryBuilder pour ce type de recherche
	 */
	public SearchQueryBuilder createSearchQueryBuilderMovie(final String criteria, final List<ListFilter> listFilters) {
		final FacetedQueryDefinition facetedQueryDefinition = Home.getApp().getDefinitionSpace().resolve("QRY_MOVIE", FacetedQueryDefinition.class);
		final ListFilterBuilder<String> listFilterBuilder = Injector.newInstance(facetedQueryDefinition.getListFilterBuilderClass(), Home.getApp().getComponentSpace());
		final ListFilter criteriaListFilter = listFilterBuilder.withBuildQuery(facetedQueryDefinition.getListFilterBuilderQuery()).withCriteria(criteria).build();
		return new SearchQueryBuilder(criteriaListFilter).withFacetStrategy(facetedQueryDefinition, listFilters);
	}

	/**
	 * Récupération du résultat issu d'une requête.
	 * @param searchQuery critères initiaux
	 * @param listState Etat de la liste (tri et pagination)
	 * @return Résultat correspondant à la requête (de type Movie)
	 */
	public FacetedQueryResult<Movie, SearchQuery> loadList(final SearchQuery searchQuery, final DtListState listState) {
		final SearchIndexDefinition indexDefinition = searchManager.findIndexDefinitionByKeyConcept(Movie.class);
		return searchManager.loadList(indexDefinition, searchQuery, listState);
	}

	/**
	 * Creates a taskBuilder.
	 * @param name  the name of the task
	 * @return the builder
	 */
	private static TaskBuilder createTaskBuilder(final String name) {
		final TaskDefinition taskDefinition = Home.getApp().getDefinitionSpace().resolve(name, TaskDefinition.class);
		return new TaskBuilder(taskDefinition);
	}

	/**
	 * Execute la tache TK_GET_MOVIE_INDEX.
	 * @param dtcMovieIds io.vertigo.dynamo.domain.model.DtList<lollipop.domain.search.Dummy>
	 * @return io.vertigo.dynamo.domain.model.DtList<lollipop.domain.movies.Movie> dtcMovie
	*/
	public io.vertigo.dynamo.domain.model.DtList<lollipop.domain.movies.Movie> getMovieIndex(final io.vertigo.dynamo.domain.model.DtList<lollipop.domain.search.Dummy> dtcMovieIds) {
		final Task task = createTaskBuilder("TK_GET_MOVIE_INDEX")
				.addValue("DTC_MOVIE_IDS", dtcMovieIds)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

}
