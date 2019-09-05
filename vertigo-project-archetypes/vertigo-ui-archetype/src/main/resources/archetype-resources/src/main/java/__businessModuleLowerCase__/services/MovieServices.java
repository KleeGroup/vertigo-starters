package ${package}.${businessModuleLowerCase}.services;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListState;
import io.vertigo.core.component.Component;
import ${package}.${businessModuleLowerCase}.domain.Movie;

public interface MovieServices extends Component {

	DtList<Movie> getMovies(DtListState dtListState);

	void save(Movie movie);

	Movie get(Long movId);
}
