package io.vertigo.starterkit.services.sample;

import io.vertigo.starterkit.util.SampleUtil;

/**
 * 
 * @author xdurand
 *
 */
public class SampleServicesImpl implements SampleServices {

	@Override
	public String hello(final String name) {
		return SampleUtil.hello() + " " + name;
	}

}
