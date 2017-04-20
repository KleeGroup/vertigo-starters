package ${package}.webservices.users;

import io.vertigo.vega.webservice.WebServices;
import io.vertigo.vega.webservice.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.webservice.stereotype.InnerBodyParam;
import io.vertigo.vega.webservice.stereotype.POST;
import io.vertigo.vega.webservice.stereotype.PathPrefix;

import javax.inject.Inject;

import ${package}.domain.users.ApplicationUser;
import ${package}.services.users.UserServices;

@PathPrefix("/users")
public class UserWebServices implements WebServices {
	@Inject
	private UserServices userServices;

	@POST("/login")
	@AnonymousAccessAllowed
	public ApplicationUser login(final @InnerBodyParam("login") String login, final @InnerBodyParam("password") String password) {
		return userServices.loginUser(login, password);
	}

}
