package it.euris.fullstack.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;

import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;

@Configuration
@Profile("dev")
public class MongoInMemoryConfiguration extends AbstractMongoConfiguration {
    
    private static final Logger log = LoggerFactory.getLogger(MongoInMemoryConfiguration.class);

    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
	return env.getRequiredProperty("mongo.db.name");
    }

    @Override
    public Mongo mongo() throws Exception {
	log.debug("Returning EmbeddedMongo with MongoInMemoryConfiguration bean");
	return new EmbeddedMongoBuilder().version("2.6.1").bindIp("127.0.0.1").port(12345).build();
    }
}
