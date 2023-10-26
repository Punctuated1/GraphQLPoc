package com.pd.graphql.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories("com.pd.graphql.jps")
//@EnableMongoRepositories("com.pd.graphql.demo")
//@EntityScan("com.pd.graphql.jpa")

public class GraphQLConfig {
	
	
	@Bean

	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString ("mongodb://root:example@127.0.0.1:27017/admin");
		MongoCredential credential = MongoCredential.createCredential("root", "admin", "example".toCharArray());
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	

	@Bean(name = "mongoTemplate")
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(),getDatabaseName());
	}

	private String getDatabaseName() {
		return "benchmark";
	}

	



//	@Bean
//	public RuntimeWiringConfigurer runtimeWiringConfigurer() {
//		return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Date);
//	}
//	@Bean
//	public RuntimeWiringConfigurer runtimeWiringConfigurers() {
//		return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.);
//	}
//	private final String PROPERTY_DRIVER = "driver";
//	private final String PROPERTY_URL = "url";
//	private final String PROPERTY_USERNAME = "user";
//	private final String PROPERTY_PASSWORD = "password";
//	private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
//	private final String PROPERTY_DIALECT = "hibernate.dialect";
//
//	@Autowired
//	Environment environment;
//
//	@Bean
//	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
//		lfb.setDataSource(dataSource());
//		lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//		lfb.setPackagesToScan("com.journaldev.spring.model");
//		lfb.setJpaProperties(hibernateProps());
//		return lfb;
//	}
//
//	@Bean
//	DataSource dataSource() {
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setUrl(environment.getProperty(PROPERTY_URL));
//		ds.setUsername(environment.getProperty(PROPERTY_USERNAME));
//		ds.setPassword(environment.getProperty(PROPERTY_PASSWORD));
//		ds.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
//		return ds;
//	}
//
//	Properties hibernateProps() {
//		Properties properties = new Properties();
//		properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
//		properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
//		return properties;
//	}
//
//	@Bean
//	JpaTransactionManager transactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//		return transactionManager;
//	}
}