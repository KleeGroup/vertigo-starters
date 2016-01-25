package lollipop.dao.people;

import javax.inject.Inject;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.impl.store.util.DAOBroker;
import io.vertigo.dynamo.store.StoreManager;
import io.vertigo.dynamo.store.StoreServices;
import io.vertigo.dynamo.task.TaskManager;
import lollipop.domain.people.People;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * PeopleDAO
 */
public final class PeopleDAO extends DAOBroker<People, java.lang.Long> implements StoreServices {
	 
	/**
	 * Contructeur.
	 * @param storeManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public PeopleDAO(final StoreManager storeManager, final TaskManager taskManager) {
		super(People.class, storeManager, taskManager);
	}
	
	/**
	 * Indique que le keyConcept associé à cette uri va être modifié.
	 * Techniquement cela interdit les opérations d'ecriture en concurrence 
	 * et envoie un évenement de modification du keyConcept (à la fin de transaction eventuellement) 
	 * @param uri URI du keyConcept modifié
	 * @return KeyConcept à modifier
	 */
	 public People loadForUpdate(final URI<People> uri) {
		return dataStore.loadForUpdate(uri);
	}

	/**
	 * Indique que le keyConcept associé à cet id va être modifié.
	 * Techniquement cela interdit les opérations d'ecriture en concurrence 
	 * et envoie un évenement de modification du keyConcept (à la fin de transaction eventuellement) 
	 * @param id Clé du keyConcept modifié
	 * @return KeyConcept à modifier
	 */
	 public People loadForUpdate(final java.lang.Long id) {
		return loadForUpdate(createDtObjectURI(id));
	}
	

}
