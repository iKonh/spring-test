package redis.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import redis.entity.User;
import redis.framework.JsonRedisSerializer;

/**
 * Created by Huangyipeng on 2016/03/03.
 */
@Component
public class UserDao {

    @Autowired
    StringRedisTemplate template;

    @Autowired
    JsonRedisSerializer serializer;

    public void saveUser(User user){
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set(user.id, serializer.serializerAsString(user));
    }

    public User getUser(String id) {

        ValueOperations<String, String> operations = template.opsForValue();
        return serializer.deserializeAsObject(operations.get(id), User.class);
    }
}
