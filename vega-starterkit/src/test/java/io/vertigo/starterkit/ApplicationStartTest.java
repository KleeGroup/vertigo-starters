/**
 * 
 */
package io.vertigo.starterkit;

import io.vertigo.starterkit.tools.AbstractStarterKitTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import io.vertigo.commons.analytics.health.HealthCheck;
import io.vertigo.commons.analytics.health.HealthMeasure;
import io.vertigo.commons.analytics.health.HealthStatus;
import io.vertigo.commons.impl.analytics.health.HealthAnalyticsUtil;


/**
 * Classe de test vérifiant le bon démarrage de l'application.
 * @author jmforhan
 *
 */
public class ApplicationStartTest extends AbstractStarterKitTest {

	/**
	 * On vérifie le bon démarrage de l'application.
	 */
	@Test
	public void testStartApplication() {
		// On récupère l'état de santé globale et on le loggue
		final List<HealthCheck> lst = HealthAnalyticsUtil.getHealthChecks();
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
		Assert.assertNull(noPb);
	}
}
