package redis.framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Huangyipeng on 2016/03/04.
 */
@Component
public class JsonRedisSerializer {

    ObjectMapper objectMapper = Jsr310ObjectMapperBuilder.build();

    public String serializerAsString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Could not write JSON: " + e.getMessage(), e);
        }
    }

    public <T> T deserializeAsObject(String str, Class<T> clazz) {
        try {
            return objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            throw new SerializationException("Could not write JSON: " + e.getMessage(), e);
        }
    }
}
