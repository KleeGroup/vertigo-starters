package io.vertigo.starterkit.services.sample;

import io.vertigo.lang.Component;

/**
 * @author xdurand
 *
 */
public interface SampleServices extends Component {

	/**
	 * 
	 * @param name
	 * @return Hello {name}
	 */
	public String hello(final String name);

}
