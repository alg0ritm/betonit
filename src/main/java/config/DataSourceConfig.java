package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ImportResource("classpath:root-context.xml")
@PropertySource("classpath:database.properties")
public class DataSourceConfig {
	
	public DataSourceConfig() {}

}
