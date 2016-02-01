package lollipop.dao.movies;

import javax.inject.Inject;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.impl.store.util.DAOBroker;
import io.vertigo.dynamo.store.StoreManager;
import io.vertigo.dynamo.store.StoreServices;
import io.vertigo.dynamo.task.TaskManager;
import lollipop.domain.movies.Movie;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * MovieDAO
 */
public final class MovieDAO extends DAOBroker<Movie, java.lang.Long> implements StoreServices {
	 
	/**
	 * Contructeur.
	 * @param storeManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public MovieDAO(final StoreManager storeManager, final TaskManager taskManager) {
		super(Movie.class, storeManager, taskManager);
	}
	
	/**
	 * Indique que le keyConcept associé à cette uri va être modifié.
	 * Techniquement cela interdit les opérations d'ecriture en concurrence 
	 * et envoie un évenement de modification du keyConcept (à la fin de transaction eventuellement) 
	 * @param uri URI du keyConcept modifié
	 * @return KeyConcept à modifier
	 */
	 public Movie loadForUpdate(final URI<Movie> uri) {
		return dataStore.readForUpdate(uri);
	}

	/**
	 * Indique que le keyConcept associé à cet id va être modifié.
	 * Techniquement cela interdit les opérations d'ecriture en concurrence 
	 * et envoie un évenement de modification du keyConcept (à la fin de transaction eventuellement) 
	 * @param id Clé du keyConcept modifié
	 * @return KeyConcept à modifier
	 */
	 public Movie loadForUpdate(final java.lang.Long id) {
		return loadForUpdate(createDtObjectURI(id));
	}
	

}
