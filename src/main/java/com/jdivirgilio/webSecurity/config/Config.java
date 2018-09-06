package com.jdivirgilio.webSecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.jdivirgilio.webSecurity")
@PropertySource("classpath:mysql.properties") // New properties file for JDBC/Connection pool
public class Config {
	
	@Autowired
	private Environment env; // Reads and holds the properties from the prop file
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public DataSource securityDataSource() throws RuntimeException {
		
		logger.info(">>>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		// create connection pool
		ComboPooledDataSource ds = new ComboPooledDataSource();

		// set the jdbc driver
		try {
			ds.setDriverClass(env.getProperty("jdbc.driver"));
		}
		catch( PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		// set the db connx properties
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		ds.setUser(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		ds.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		ds.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		ds.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		ds.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		return ds;
	}
	
	/* Here is the equivalent XML version
	*
	*	<bean
	*		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	*		<property name="prefix" value="/WEB-INF/view/" />
	*		<property name="suffix" value=".jsp" />
	*	</bean
	*/
	
	// Define a bean for the ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		
		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".jsp");
		
		return view;
	}
	
}
