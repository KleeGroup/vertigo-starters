package io.vertigo.starterkit.mda;

import javax.inject.Inject;

import io.vertigo.commons.CommonsFeatures;
import io.vertigo.core.node.AutoCloseableApp;
import io.vertigo.core.node.config.DefinitionProviderConfig;
import io.vertigo.core.node.config.ModuleConfig;
import io.vertigo.core.node.config.NodeConfig;
import io.vertigo.core.param.Param;
import io.vertigo.core.plugins.resource.classpath.ClassPathResourceResolverPlugin;
import io.vertigo.core.util.InjectorUtil;
import io.vertigo.dynamo.plugins.environment.StudioModelDefinitionProvider;
import io.vertigo.studio.StudioFeatures;
import io.vertigo.studio.mda.MdaManager;

public class Studio {

	private static NodeConfig buildNodeConfig() {
		return NodeConfig.builder()
				.beginBoot()
				.withLocales("fr_FR")
				.addPlugin(ClassPathResourceResolverPlugin.class)
				.endBoot()
				.addModule(new CommonsFeatures()
						.withCache()
						.withMemoryCache()
						.withScript()
						.withJaninoScript()
						.build())
				//----Definitions
				.addModule(ModuleConfig.builder("ressources")
						.addDefinitionProvider(DefinitionProviderConfig.builder(StudioModelDefinitionProvider.class)
								.addDefinitionResource("kpr", "boot/definitions/application.kpr")
								//.addDefinitionResource("oom", "database/model/vega-starterkit.oom")
								.addDefinitionResource("oom", "database/model/lollipop.oom")
								.build())
						.build())
				// ---StudioFeature
				.addModule(new StudioFeatures()
						.withMasterData()
						.withMda(
								Param.of("projectPackageName", "lollipop"))
						.withJavaDomainGenerator(
								Param.of("generateDtResources", "false"))
						.withTaskGenerator()
						.withSearchGenerator()
						.withSqlDomainGenerator(
								Param.of("targetSubDir", "javagen/sqlgen"),
								Param.of("baseCible", "H2"),
								Param.of("generateDrop", "true"),
								Param.of("generateMasterData", "true"))
						.withTsDomainGenerator(Param.of("targetSubDir", "javagen/ts"))
						.build())
				.build();

	}

	@Inject
	private MdaManager mdaManager;

	public static void main(final String[] args) {
		try (final AutoCloseableApp app = new AutoCloseableApp(buildNodeConfig())) {
			final Studio sample = new Studio();
			InjectorUtil.injectMembers(sample);
			//-----
			sample.cleanGenerate();
		}
	}

	void cleanGenerate() {
		mdaManager.clean();
		mdaManager.generate().displayResultMessage(System.out);
	}
}
