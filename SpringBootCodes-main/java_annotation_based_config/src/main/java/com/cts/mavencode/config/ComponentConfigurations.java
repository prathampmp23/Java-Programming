package com.cts.mavencode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this class as a configuration class
@ComponentScan(basePackages={"com.cts.mavencode.model"}) // Tells Spring where to look for @Component classes
public class ComponentConfigurations {
	
}
