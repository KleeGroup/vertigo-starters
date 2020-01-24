/**
 *
 */
package io.vertigo.starterkit;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.vertigo.core.analytics.AnalyticsManager;
import io.vertigo.core.analytics.health.HealthCheck;
import io.vertigo.core.analytics.health.HealthMeasure;
import io.vertigo.core.analytics.health.HealthStatus;
import io.vertigo.starterkit.tools.AbstractStarterKitTest;

/**
 * Classe de test vérifiant le bon démarrage de l'application.
 * @author jmforhan
 *
 */
public class ApplicationStartTest extends AbstractStarterKitTest {

	@Inject
	private AnalyticsManager analyticsManager;

	/**
	 * On vérifie le bon démarrage de l'application.
	 */
	@Test
	public void testStartApplication() {
		// On récupère l'état de santé globale et on le loggue
		final List<HealthCheck> lst = analyticsManager.getHealthChecks();
		String noPb = null;
		for (final HealthCheck health : lst) {
			final StringBuilder sb = new StringBuilder();
			sb.append(health.getModule());
			sb.append('|');
			sb.append(health.getFeature());
			sb.append('|');
			sb.append(health.getChecker());
			sb.append('|');
			sb.append(health.getName());
			final HealthMeasure measure = health.getMeasure();
			sb.append(" : ");
			sb.append(measure.getStatus());
			final String msg = sb.toString();
			getLogger().info(msg);
			if (noPb == null && measure.getStatus() != HealthStatus.GREEN) {
				noPb = msg;
			}
		}
		Assertions.assertNull(noPb);
	}
}
