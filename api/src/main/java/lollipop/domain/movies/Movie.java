package lollipop.domain.movies;

import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;

@DtDefinition
public final class Movie implements DtObject {
	private static final long serialVersionUID = -5975848806293357234L;
	private final Long id;
	private final String title;
	private final int year;

	public Movie(final long id, final String name, final int year) {
		this.id = id;
		this.title = name;
		this.year = year;
	}

	@Field(domain = "DO_IDENTITY", type = "PRIMARY_KEY", required = true, label = "id")
	public final Long getId() {
		return id;
	}

	@Field(domain = "DO_NAME", label = "name")
	public String getName() {
		return title;
	}

	@Field(domain = "DO_YEAR", label = "name")
	public int getYear() {
		return year;
	}
}