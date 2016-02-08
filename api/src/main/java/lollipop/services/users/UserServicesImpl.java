package lollipop.services.users;

import io.vertigo.dynamo.transaction.Transactional;
import io.vertigo.lang.MessageText;
import io.vertigo.lang.VUserException;
import io.vertigo.persona.security.VSecurityManager;

import javax.inject.Inject;

import lollipop.domain.users.ApplicationUser;
import lollipop.user.LollipopUserSession;

@Transactional
public class UserServicesImpl implements UserServices {
	private long usrIdSeq = 1;

	@Inject
	private VSecurityManager securityManager;

	@Override
	public ApplicationUser loginUser(final String login, final String password) {
		//mock login User
		if (login.isEmpty() || password.isEmpty() || login.startsWith(password) || password.startsWith(login)) {
			throw new VUserException(new MessageText(UserResources.INVALID_CREDENTIALS));
		}

		final ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setFirstName(password);
		applicationUser.setLastName(login);
		applicationUser.setEmail(password + "." + login + "@kleegroup.com");
		applicationUser.setUsrId(usrIdSeq++);

		final LollipopUserSession userSession = securityManager.<LollipopUserSession> getCurrentUserSession().get();
		userSession.setApplicationUser(applicationUser);
		userSession.authenticate();

		return applicationUser;
	}

}
