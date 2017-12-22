package lollipop.services.users;

import io.vertigo.core.component.Component;
import lollipop.domain.users.ApplicationUser;

public interface UserServices extends Component {

	ApplicationUser loginUser(final String login, final String password);

}
