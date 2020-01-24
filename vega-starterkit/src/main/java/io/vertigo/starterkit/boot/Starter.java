package io.vertigo.starterkit.boot;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public final class Starter {

	public static void main(final String[] args) throws Exception {
		final Server server = new Server(8080);

		final WebAppContext context = new WebAppContext();
		context.setResourceBase("src/main/webapp");
		context.setContextPath("/");
		context.setParentLoaderPriority(true);
		context.setThrowUnavailableOnStartupException(true);
		server.setHandler(context);

		try {
			server.start();
			server.join();
		} finally {
			server.stop();
		}
	}
}
