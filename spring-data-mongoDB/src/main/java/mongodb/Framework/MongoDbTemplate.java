package mongodb.Framework;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbTemplate {

    @Bean
    MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory){
        return new MongoTemplate(mongoDbFactory);
    }
}
