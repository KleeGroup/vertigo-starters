package ${package}.${businessModuleLowerCase}.services;

import javax.inject.Inject;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListState;
import io.vertigo.dynamo.criteria.Criterions;
import io.vertigo.commons.transaction.Transactional;
import ${package}.${businessModuleLowerCase}.dao.MovieDAO;
import ${package}.${businessModuleLowerCase}.domain.Movie;

@Transactional
public class MovieServicesImpl implements MovieServices {

	@Inject
	private MovieDAO movieDAO;

	@Override
	public Movie get(final Long movId) {
		return movieDAO.get(movId);
	}

	@Override
	public void save(final Movie movie) {
		movieDAO.save(movie);
	}

	@Override
	public DtList<Movie> getMovies(final DtListState dtListState) {
		return movieDAO.findAll(Criterions.alwaysTrue(), dtListState);
	}
}
