package lollipop.services;

import io.vertigo.util.ListBuilder;

import java.util.List;

import lollipop.domain.Flower;

public final class FlowerServicesImpl implements FlowerServices {

	@Override
	public List<Flower> getFlowers() {
		return new ListBuilder<Flower>()
				.add(new Flower(1, "tulip"))
				.add(new Flower(2, "rose"))
				.add(new Flower(3, "lily"))
				.build();
	}
}
