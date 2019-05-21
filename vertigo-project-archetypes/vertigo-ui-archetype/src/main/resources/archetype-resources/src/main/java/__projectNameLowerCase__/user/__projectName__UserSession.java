package ${package}.${projectNameLowerCase}.user;

import io.vertigo.account.security.UserSession;

import java.util.Locale;

public final class ${projectName}UserSession extends UserSession {
	private static final long serialVersionUID = 3522402730076977461L;

	/**
	 * @return Default Locale.
	 */
	@Override
	public Locale getLocale() {
		return Locale.FRANCE;
	}

}
