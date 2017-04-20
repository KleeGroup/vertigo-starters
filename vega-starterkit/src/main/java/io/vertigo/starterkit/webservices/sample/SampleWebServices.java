package io.vertigo.starterkit.webservices.sample;

import javax.inject.Inject;

import io.vertigo.starterkit.services.sample.SampleServices;
import io.vertigo.vega.webservice.WebServices;
import io.vertigo.vega.webservice.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.webservice.stereotype.GET;
import io.vertigo.vega.webservice.stereotype.PathParam;
import io.vertigo.vega.webservice.stereotype.PathPrefix;

/**
 * Sample WebService
 * @author dt
 *
 */
@PathPrefix("/sample")
public class SampleWebServices implements WebServices {

	@Inject
	private SampleServices sampleServices;

	/**
	 * Hello WebService
	 * @param name
	 * @return Hello {name}
	 */
	@AnonymousAccessAllowed
	@GET("/hello/{name}")
	public String getHello(@PathParam("name") final String name) {
		return sampleServices.hello(name);
	}

}
