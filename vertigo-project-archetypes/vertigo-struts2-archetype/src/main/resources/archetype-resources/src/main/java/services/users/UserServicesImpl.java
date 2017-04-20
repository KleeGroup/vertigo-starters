package ${package}.services.users;

import io.vertigo.dynamo.transaction.Transactional;
import io.vertigo.lang.MessageText;
import io.vertigo.lang.VUserException;
import io.vertigo.persona.security.VSecurityManager;

import javax.inject.Inject;

import ${package}.domain.users.ApplicationUser;
import ${package}.user.${className}UserSession;

@Transactional
public class UserServicesImpl implements UserServices {
	private long usrIdSeq = 1;

	@Inject
	private VSecurityManager securityManager;

	@Override
	public ApplicationUser loginUser(final String login, final String password) {
		//mock login User
		if (login.isEmpty() || password.isEmpty() || login.startsWith(password) || password.startsWith(login)) {
			throw new VUserException(new MessageText("Échec de la connexion : nom d'utilisateur inconnu ou mot de passe incorrect.", null));
		}

		final ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setFirstName(password);
		applicationUser.setLastName(login);
		applicationUser.setEmail(password + "." + login + "@kleegroup.com");
		applicationUser.setUsrId(usrIdSeq++);

		final ${className}UserSession userSession = securityManager.<${className}UserSession> getCurrentUserSession().get();
		userSession.setApplicationUser(applicationUser);
		userSession.authenticate();

		return applicationUser;
	}

}
