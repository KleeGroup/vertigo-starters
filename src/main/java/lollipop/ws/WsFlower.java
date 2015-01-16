package lollipop.ws;

import io.vertigo.vega.rest.RestfulService;
import io.vertigo.vega.rest.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.rest.stereotype.GET;
import io.vertigo.vega.rest.stereotype.PathParam;
import io.vertigo.vega.rest.stereotype.PathPrefix;

import java.util.List;

import javax.inject.Inject;

import lollipop.domain.Flower;
import lollipop.services.FlowerServices;

@PathPrefix("/flowers")
public class WsFlower implements RestfulService {
	@Inject
	private FlowerServices flowerServices;

	@GET("/{id}")
	@AnonymousAccessAllowed
	public String helloWorldWithNumber(@PathParam("id") final int id) {
		return flowerServices.getFlowers().get(id).getName();
	}

	//
	//	@GET("/index")
	//	@AnonymousAccessAllowed
	//	public String helloWorld() {
	//		return "Hello world";
	//	}

	@AnonymousAccessAllowed
	@GET("/")
	public List<Flower> getFlowers() {
		return flowerServices.getFlowers();
	}

}