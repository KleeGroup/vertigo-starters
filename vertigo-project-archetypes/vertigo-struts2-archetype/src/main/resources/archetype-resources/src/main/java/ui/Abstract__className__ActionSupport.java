package ${package}.ui;

import javax.inject.Inject;

import org.apache.struts2.ServletActionContext;

import io.vertigo.persona.security.VSecurityManager;
import io.vertigo.struts2.core.AbstractActionSupport;
import io.vertigo.struts2.impl.MethodUtil;
import io.vertigo.struts2.impl.servlet.RequestContainerWrapper;

/**
 * Super class des Actions struts.
 *
 * @author npiedeloup
 * @version $Id: AbstractActionSupport.java,v 1.1 2013/07/18 17:36:33 npiedeloup Exp $
 */
public abstract class Abstract${className}ActionSupport extends AbstractActionSupport {

	/**
	 * "next" pour struts redirection.
	 */
	public static final String NEXT = "next";

	private static final long serialVersionUID = -1591995113242298266L;

	@Inject
	private VSecurityManager securityManager;

	/**
	 * Initialisation du context.
	 */
	@Override
	protected final void preInitContext() {
		super.preInitContext();

	}

	/** {@inheritDoc} */
	@Override
	protected void initContext() {
		final RequestContainerWrapper myContainer = new RequestContainerWrapper(ServletActionContext.getRequest());
		MethodUtil.invoke(this, "initContext", myContainer);
	}

	/**
	 * Retourne le nom de la page active. Cette information est utilis�e dans le chemin de fer.
	 *
	 * @return Nom de la page.
	 */
	public abstract String getPageName();

}
