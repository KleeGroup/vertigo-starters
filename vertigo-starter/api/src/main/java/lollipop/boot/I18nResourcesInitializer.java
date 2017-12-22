/**
 *
 */
package lollipop.boot;

import javax.inject.Inject;

import io.vertigo.core.component.ComponentInitializer;
import io.vertigo.core.locale.LocaleManager;
import lollipop.services.users.UserResources;

/**
 * Init ressources.
 * @author npiedeloup
 */
public class I18nResourcesInitializer implements ComponentInitializer {

	@Inject
	private LocaleManager localeManager;

	/** {@inheritDoc} */
	@Override
	public void init() {
		localeManager.add(UserResources.class.getName(), UserResources.values());
	}

}
