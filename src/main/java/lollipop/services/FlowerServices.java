package lollipop.services;

import io.vertigo.lang.Component;

import java.util.List;

import lollipop.domain.Flower;

public interface FlowerServices extends Component {
	List<Flower> getFlowers();
}
