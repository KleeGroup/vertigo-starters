package io.vertigo.starterkit;

import io.vertigo.core.node.config.DefinitionProviderConfig;
import io.vertigo.core.node.config.discovery.ModuleDiscoveryFeatures;
import io.vertigo.dynamo.ngdomain.NewModelDefinitionProvider;
import io.vertigo.starterkit.boot.VegaStarterKitSmartTypes;
import io.vertigo.starterkit.boot.VegaStarterMasterDataInitializer;

/**
 *
 * @author xdurand
 *
 */
public class VegaStarterkitModuleDiscoveryFeatures extends ModuleDiscoveryFeatures<VegaStarterkitModuleDiscoveryFeatures> {

	public VegaStarterkitModuleDiscoveryFeatures() {
		super("VegaStarterkitModuleDiscoveryFeatures");
	}

	@Override
	protected void buildFeatures() {
		super.buildFeatures();
		getModuleConfigBuilder()
				.addDefinitionProvider(DefinitionProviderConfig.builder(NewModelDefinitionProvider.class)
						.addDefinitionResource("smarttypes", VegaStarterKitSmartTypes.class.getName())
						.addDefinitionResource("classes", "io.vertigo.starterkit.domain.DtDefinitions")
						.build())
				.addDefinitionProvider(VegaStarterMasterDataInitializer.class);

	}

	@Override
	protected String getPackageRoot() {
		return "io.vertigo.starterkit";
	}

}
