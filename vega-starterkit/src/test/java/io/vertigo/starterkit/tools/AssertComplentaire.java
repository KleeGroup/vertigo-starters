package io.vertigo.starterkit.tools;


import java.io.Serializable;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.vertigo.core.locale.MessageKey;
import io.vertigo.core.locale.MessageText;
import io.vertigo.core.locale.MessageTextBuilder;
import io.vertigo.lang.VUserException;

/**
 * Classe d'assertion complémentaire.
 *
 * @author jmforhan
 *
 */
public interface AssertComplentaire {

	/**
	 * Vérification qu'une fonction lève une exception d'un type attendu
	 * 
	 * @param <D>
	 *            type de l'exception
	 * @param lambda
	 *            fonction
	 * @param exceptionClass
	 *            classe attendue
	 */
	default <D extends Exception> void checkExpectedException(final Runnable lambda, final Class<D> exceptionClass) {
		try {
			lambda.run();
			if (exceptionClass != null) {
				Assert.fail("Exception attendue");
			}
		} catch (final Exception e) {
			Assert.assertEquals(exceptionClass, e.getClass());
		}
	}

	/**
	 * Vérification qu'une fonction sans résultat lève ou ne lève pas une
	 * exception.
	 *
	 * @param lambda
	 *            fonction sans paramètre et sans retour
	 * @param key
	 *            clé du message attendu. Si non renseigné, alors on n'attend
	 *            aucune exception.
	 * @param params
	 *            paramètre du message
	 */
	default void checkExpectedVuser(final Runnable lambda, final MessageKey key, final Serializable... params) {
		try {
			lambda.run();
			failIfExpectedError(key, params);
		} catch (final VUserException e) {
			assertEqualsMessage(key, e, params);
		}
	}

	/**
	 * Vérification qu'une expection utilisateur correspond bien à un message
	 * donné.
	 *
	 * @param key
	 *            ressource du message
	 * @param e
	 *            exception à tester
	 * @param params
	 *            paramètre
	 */
	default void assertEqualsMessage(final MessageKey key, final VUserException e, final Serializable... params) {
		assertEqualsMessage(getMessage(key, params), e);
	}

	/**
	 * Vérification qu'une expection utilisateur correspond bien à un message
	 * donné.
	 *
	 * @param message
	 *            message attendu
	 * @param e
	 *            exception à tester
	 */
	default void assertEqualsMessage(final MessageText message, final VUserException e) {
		try {
			final MessageText actual = e.getMessageText();
			assertEqualsMessage(message, actual);
		} catch (final AssertionError c) {
			// On loggue l'erreur pour avoir la stacktrace puis on relance.
			getLogger().error("comparaison en erreur", e);
			throw c;
		}
	}

	/**
	 * Vérification que 2 messages sont identiques.
	 *
	 * @param expected
	 *            message attendu
	 * @param actual
	 *            message effectif
	 */
	default void assertEqualsMessage(final MessageText expected, final MessageText actual) {
		if (expected == null && actual == null) {
			// Les 2 sont nulls, tout va bien
			return;
		}
		if (expected != null && actual != null) {
			// On vérifie le message affiché
			Assert.assertEquals(expected.getDisplay(), actual.getDisplay());
			return;
		}
		// Vérification par défaut
		Assert.assertEquals(expected == null ? null : expected.toString(), actual == null ? null : actual.toString());
	}

	/**
	 * Message indiquant qu'une méthode devrait avoir levé une exception avec un
	 * message spécifique
	 *
	 * @param key
	 *            clé du message attendu. Si non renseigné, alors on n'attend
	 *            aucune exception.
	 * @param params
	 *            paramètres du message
	 */
	default void failIfExpectedError(final MessageKey key, final Serializable... params) {
		if (key != null) {
			Assert.fail("erreur attendue" + getMessage(key, params).getDisplay());
		}
	}

	/**
	 * Récupération d'un message associé à une clé et à ses paramètres. si la
	 * clé est null, on renvoie null
	 *
	 * @param key
	 *            clé du message
	 * @param params
	 *            paramètres du message
	 * @return MessageText
	 */
	default MessageText getMessage(final MessageKey key, final Serializable... params) {
		if (key == null) {
			return null;
		}
		if (params == null || params.length == 0) {
			return MessageText.of(key);
		}
		final MessageTextBuilder mb = MessageText.builder();
		mb.withKey(key);
		mb.withParams(params);
		return mb.build();
	}

	/**
	 * Logger à utiliser
	 *
	 * @return logger
	 */
	Logger getLogger();
}
