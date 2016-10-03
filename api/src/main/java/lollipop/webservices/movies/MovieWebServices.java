package lollipop.webservices.movies;

import java.util.List;

import javax.inject.Inject;

import io.vertigo.dynamo.collections.model.FacetedQueryResult;
import io.vertigo.vega.engines.webservice.json.UiSelectedFacets;
import io.vertigo.vega.webservice.WebServices;
import io.vertigo.vega.webservice.model.UiListState;
import io.vertigo.vega.webservice.stereotype.GET;
import io.vertigo.vega.webservice.stereotype.InnerBodyParam;
import io.vertigo.vega.webservice.stereotype.POST;
import io.vertigo.vega.webservice.stereotype.PathParam;
import io.vertigo.vega.webservice.stereotype.PathPrefix;
import lollipop.domain.movies.Movie;
import lollipop.services.movies.MovieServices;

@PathPrefix("/movies")
public class MovieWebServices implements WebServices {
	@Inject
	private MovieServices movieServices;

	@GET("/{id}")
	public Movie getMovie(@PathParam("id") final long id) {
		return movieServices.get(id);
	}

	@GET("/")
	public List<Movie> getMovies(final UiListState uiListState) {
		return movieServices.getMovies(uiListState.toDtListState());
	}

	@POST("/search")
	public FacetedQueryResult search(@InnerBodyParam("criteria") final String criteria,
			@InnerBodyParam("facets") final UiSelectedFacets uiSelectedFacets, final UiListState uiListState) {
		return movieServices.searchMovies(criteria, uiSelectedFacets.toListFilters(), uiListState.toDtListState());
	}

}
