package ${package}.services.users;

import io.vertigo.lang.Component;
import ${package}.domain.users.ApplicationUser;

public interface UserServices extends Component {

	ApplicationUser loginUser(final String login, final String password);

}
