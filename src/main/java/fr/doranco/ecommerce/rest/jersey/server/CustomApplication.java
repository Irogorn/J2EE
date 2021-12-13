package fr.doranco.ecommerce.rest.jersey.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import fr.doranco.ecommerce.rest.jersey.server.provider.AuthenticationFilter;


public class CustomApplication extends ResourceConfig {
	public CustomApplication() {
		packages("fr.doranco.ecommerce.rest.jersey.server.service");
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.LOGGING_FEATURE_LOGGER_NAME), 
				Level.INFO,LoggingFeature.Verbosity.PAYLOAD_ANY,10000));
		register(AuthenticationFilter.class);
	}
}