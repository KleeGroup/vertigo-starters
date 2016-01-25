/**
 *
 */
package lollipop.boot;

import io.vertigo.core.locale.LocaleManager;
import io.vertigo.core.spaces.component.ComponentInitializer;

import javax.inject.Inject;

import lollipop.services.users.UserRessources;

/**
 * Init ressources.
 * @author npiedeloup
 */
public class I18nRessourcesInitializer implements ComponentInitializer {

	@Inject
	private LocaleManager localeManager;

	/** {@inheritDoc} */
	@Override
	public void init() {
		localeManager.add(UserRessources.class.getName(), UserRessources.values());
	}

}
