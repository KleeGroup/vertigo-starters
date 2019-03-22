/**
 * vertigo - simple java starter
 *
 * Copyright (C) 2013-2018, KleeGroup, direction.technique@kleegroup.com (http://www.kleegroup.com)
 * KleeGroup, Centre d'affaire la Boursidiere - BP 159 - 92357 Le Plessis Robinson Cedex - France
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vertigo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;

import io.vertigo.app.App;
import io.vertigo.app.AutoCloseableApp;
import io.vertigo.app.config.NodeConfig;
import io.vertigo.app.config.xml.XMLNodeConfigBuilder;
import io.vertigo.core.component.di.injector.DIInjector;
import io.vertigo.lang.Assertion;
import io.vertigo.lang.WrappedException;
import io.vertigo.util.StringUtil;

/**
 * Classe parente de tous les TNR associés à vertigo avec partage possible de la home entre chaque test.
 *
 * @author jmforhan
 */
public abstract class AbstractSharedHomeTestCaseJU4 {

	private static final String BOOT_KEY = "boot.applicationConfiguration";

	private static Properties properties = new Properties();
	private static AutoCloseableApp app;

	private synchronized void startHome() {
		setProperties(loadProperties());
		app = new AutoCloseableApp(buildNodeConfig());
	}

	private synchronized void stopHome() {
		if (app != null)
			app.close();
		setProperties(new Properties());
	}

	private static synchronized boolean isHomeStarted() {
		return app != null;
	}

	private static final Properties getProperties() {
		return properties;
	}

	/**
	 * Doit-on redémarrer la home entre chaque test?
	 * @return true par defaut
	 */
	protected boolean cleanHomeForTest() {
		return true;
	}

	private static synchronized void setProperties(final Properties prop) {
		properties = prop;
	}

	/**
	 * Set up de l'environnement de test.
	 *
	 * @throws Exception
	 *             exception
	 */
	@Before
	public final void setUp() throws Exception {
		if (cleanHomeForTest() && isHomeStarted())
			stopHome();
		if (!isHomeStarted())
			startHome();
		// On injecte les comosants sur la classe de test.
		DIInjector.injectMembers(this, app.getComponentSpace());
		doSetUp();
	}

	protected final App getApp() {
		return app;
	}

	/**
	 * Tear down de l'environnement de test.
	 *
	 * @throws Exception
	 *             Exception
	 */
	@After
	public final void tearDown() throws Exception {
		try {
			doTearDown();
		} finally {
			if (cleanHomeForTest())
				stopHome();
		}
		doAfterTearDown();
	}

	/**
	 * Méthode ne faisant rien.
	 *
	 * @param o
	 *            object
	 */
	protected static final void nop(final Object o) {
		// rien
	}

	/**
	 * Initialisation du test pour implé spécifique.
	 *
	 * @throws Exception
	 *             Erreur
	 */
	protected void doSetUp() throws Exception {
		// pour implé spécifique
	}

	/**
	 * Finalisation du test pour implé spécifique.
	 *
	 * @throws Exception
	 *             Erreur
	 */
	protected void doTearDown() throws Exception {
		// pour implé spécifique
	}

	/**
	 * Finalisation du test pour implé spécifique après le tear down.
	 *
	 * @throws Exception
	 *             Erreur
	 */
	protected void doAfterTearDown() throws Exception {
		// pour implé spécifique
	}

	/**
	 * Tableau des fichiers managers.xml a prendre en compte.
	 *
	 * @return fichier managers.xml (par defaut managers-test.xml)
	 */
	protected String[] getManagersXmlFileName() {
		return new String[] { "./managers-test.xml", };
	}

	/**
	 * Configuration des tests.
	 * 
	 * @return App config
	 */
	protected NodeConfig buildNodeConfig() {
		final Properties prop = new Properties();
		prop.putAll(getProperties());
		final String[] managersXml;
		final XMLNodeConfigBuilder config = new XMLNodeConfigBuilder();
		final String value = prop.getProperty(BOOT_KEY);
		if (StringUtil.isEmpty(value))
			managersXml = getManagersXmlFileName();
		else {
			managersXml = prop.getProperty(BOOT_KEY).split(";");
			prop.remove(BOOT_KEY);
		}

		// si présent on récupère le paramétrage du fichier externe de
		// paramétrage log4j
		return config.withModules(getClass(), prop, managersXml).beginBoot().endBoot().build();
	}

	protected Optional<String> getPropertiesFileName() {
		return Optional.empty();
	}

	protected final URL createURL(final String fileName) {
		Assertion.checkArgNotEmpty(fileName);
		try {
			return new URL(fileName);
		} catch (final MalformedURLException e) {
			// si le filename n'est pas trouvé, on cherche dans le classpath
			final URL url = getClass().getResource(fileName);
			Assertion.checkNotNull(url, "Impossible de récupérer le fichier  {0} ", fileName);
			return url;
		}
	}

	private Properties loadProperties() {
		try {
			final Optional<String> propertiesName = getPropertiesFileName();
			final Properties prop = new Properties();
			if (propertiesName.isPresent())
				try (final InputStream in = createURL(propertiesName.get()).openStream()) {
					prop.load(in);
				}
			modifyProperties(prop);
			return prop;
		} catch (final IOException e) {
			throw WrappedException.wrap(e);
		}
	}

	private void modifyProperties(final Properties prop) {
		// RAF par défaut
	}
}
