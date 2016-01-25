package lollipop.dao.users;

import javax.inject.Inject;
import io.vertigo.dynamo.impl.store.util.DAOBroker;
import io.vertigo.dynamo.store.StoreManager;
import io.vertigo.dynamo.store.StoreServices;
import io.vertigo.dynamo.task.TaskManager;
import lollipop.domain.users.SecurityRole;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * SecurityRoleDAO
 */
public final class SecurityRoleDAO extends DAOBroker<SecurityRole, java.lang.String> implements StoreServices {
	 
	/**
	 * Contructeur.
	 * @param storeManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public SecurityRoleDAO(final StoreManager storeManager, final TaskManager taskManager) {
		super(SecurityRole.class, storeManager, taskManager);
	}
	

}
