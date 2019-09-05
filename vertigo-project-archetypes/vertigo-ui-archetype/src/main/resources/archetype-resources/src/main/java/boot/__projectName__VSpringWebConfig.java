package ${package}.boot;


import org.springframework.context.annotation.ComponentScan;

import io.vertigo.ui.impl.springmvc.config.VSpringWebConfig;

@ComponentScan({
		"${package}.${businessModuleLowerCase}.controllers"})
public class ${projectName}VSpringWebConfig extends VSpringWebConfig {
	// nothing basic config is enough

	
}
