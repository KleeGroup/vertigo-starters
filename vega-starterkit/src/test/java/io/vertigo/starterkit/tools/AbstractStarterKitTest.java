/**
 *
 */
package io.vertigo.starterkit.tools;

import java.util.Optional;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import io.vertigo.AbstractSharedHomeTestCaseJU5;
import io.vertigo.account.security.VSecurityManager;
import io.vertigo.commons.transaction.VTransactionManager;
import io.vertigo.commons.transaction.VTransactionWritable;
import io.vertigo.starterkit.user.VegaStartkitUserSession;

/**
 * Classe parente de tous les tests de non régression.
 * @author jmforhan
 *
 */
public class AbstractStarterKitTest extends AbstractSharedHomeTestCaseJU5 implements AssertComplentaire {

	private final Logger logger = LogManager.getLogger(getClass());

	@Inject
	private VTransactionManager transactionManager;
	@Inject
	private VSecurityManager securityManager;
	// current transaction
	private VTransactionWritable transaction;
	// Session courante pour éviter de la perdre dans les weakref
	private VegaStartkitUserSession session;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean cleanHomeForTest() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Optional<String> getPropertiesFileName() {
		return Optional.of("/test.properties");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doSetUp() throws Exception {
		Assertions.assertFalse(transactionManager.hasCurrentTransaction(), "le test précédent n'a pas fermé correctement sa transaction");
		transaction = transactionManager.createCurrentTransaction();
		// s'il y a une session utilisateur, il faut l'arrêter pour en créer une
		// nouvelle
		if (securityManager.getCurrentUserSession().isPresent()) {
			securityManager.stopCurrentUserSession();
		}
		session = (VegaStartkitUserSession) securityManager.createUserSession();
		securityManager.startCurrentUserSession(session);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doTearDown() throws Exception {
		Assertions.assertTrue(transactionManager.hasCurrentTransaction(), "Tous les test doivent annuler leur transaction");
		transaction.rollback();
		transaction.close();
		if (securityManager.getCurrentUserSession().isPresent()) {
			securityManager.stopCurrentUserSession();
			if (session != null) {
				session = null;
			}
		}
	}

	/**
	 * @return the logger
	 */
	@Override
	public Logger getLogger() {
		return logger;
	}

}
