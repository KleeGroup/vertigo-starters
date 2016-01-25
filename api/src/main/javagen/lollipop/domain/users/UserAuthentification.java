package lollipop.domain.users;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;
/**
 * Attention cette classe est générée automatiquement !
 * Objet de données UserAuthentification
 */
@DtDefinition
public final class UserAuthentification implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long authId;
	private String login;
	private String password;
	private Long usrId;
	private lollipop.domain.users.ApplicationUser applicationUser;

	/**
	 * Champ : ID.
	 * Récupère la valeur de la propriété 'AUTH_ID'. 
	 * @return Long authId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_ID", type = "ID", required = true, label = "AUTH_ID")
	public Long getAuthId() {
		return authId;
	}

	/**
	 * Champ : ID.
	 * Définit la valeur de la propriété 'AUTH_ID'.
	 * @param authId Long <b>Obligatoire</b>
	 */
	public void setAuthId(final Long authId) {
		this.authId = authId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Login'. 
	 * @return String login 
	 */
	@Field(domain = "DO_LABEL_SHORT", label = "Login")
	public String getLogin() {
		return login;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Login'.
	 * @param login String 
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Password'. 
	 * @return String password 
	 */
	@Field(domain = "DO_PASSWORD", label = "Password")
	public String getPassword() {
		return password;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Password'.
	 * @param password String 
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Application user'. 
	 * @return Long usrId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_ID", type = "FOREIGN_KEY", required = true, label = "Application user")
	public Long getUsrId() {
		return usrId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Application user'.
	 * @param usrId Long <b>Obligatoire</b>
	 */
	public void setUsrId(final Long usrId) {
		this.usrId = usrId;
	}

	/**
	 * Association : Application user.
	 * @return lollipop.domain.users.ApplicationUser
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_AUTH_USR",
    	fkFieldName = "USR_ID",
    	primaryDtDefinitionName = "DT_APPLICATION_USER",
    	primaryIsNavigable = true,
    	primaryRole = "ApplicationUser",
    	primaryLabel = "Application user",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_USER_AUTHENTIFICATION",
    	foreignIsNavigable = false,
    	foreignRole = "UserAuthentification",
    	foreignLabel = "User authentification",
    	foreignMultiplicity = "0..*"
    )
	public lollipop.domain.users.ApplicationUser getApplicationUser() {
		final io.vertigo.dynamo.domain.model.URI<lollipop.domain.users.ApplicationUser> fkURI = getApplicationUserURI();
		if (fkURI == null) {
			return null;
		}
		//On est toujours dans un mode lazy. On s'assure cependant que l'objet associé n'a pas changé
		if (applicationUser != null) {
			// On s'assure que l'objet correspond à la bonne clé
			final io.vertigo.dynamo.domain.model.URI<lollipop.domain.users.ApplicationUser> uri;
			uri = new io.vertigo.dynamo.domain.model.URI<>(io.vertigo.dynamo.domain.util.DtObjectUtil.findDtDefinition(applicationUser), io.vertigo.dynamo.domain.util.DtObjectUtil.getId(applicationUser));
			if (!fkURI.toURN().equals(uri.toURN())) {
				applicationUser = null;
			}
		}		
		if (applicationUser == null) {
			applicationUser = io.vertigo.app.Home.getApp().getComponentSpace().resolve(io.vertigo.dynamo.store.StoreManager.class).getDataStore().get(fkURI);
		}
		return applicationUser;
	}

	/**
	 * Retourne l'URI: Application user.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_AUTH_USR",
    	fkFieldName = "USR_ID",
    	primaryDtDefinitionName = "DT_APPLICATION_USER",
    	primaryIsNavigable = true,
    	primaryRole = "ApplicationUser",
    	primaryLabel = "Application user",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_USER_AUTHENTIFICATION",
    	foreignIsNavigable = false,
    	foreignRole = "UserAuthentification",
    	foreignLabel = "User authentification",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<lollipop.domain.users.ApplicationUser> getApplicationUserURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_AUTH_USR", lollipop.domain.users.ApplicationUser.class);
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
