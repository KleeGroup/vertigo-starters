package io.vertigo.starterkit.boot;

import io.vertigo.app.config.discovery.ModuleDiscoveryFeatures;

/**
 * 
 * @author xdurand
 *
 */
public class VegaStarterkitModuleDiscoveryFeatures extends ModuleDiscoveryFeatures {

	public VegaStarterkitModuleDiscoveryFeatures() {
		super("VegaStarterkitModuleDiscoveryFeatures");
	}

	@Override
	protected String getPackageRoot() {
		return "io.vertigo.starterkit";
	}

}
