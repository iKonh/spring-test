package mongodb.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TempDaoImpl implements TempDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    public List find(String id){

        return mongoTemplate.findAll(Map.class, id);
    }

    public void save(String id){
        Map<String, String> data = new HashMap<>();
        data.put("dalian", "50");
        data.put("shenyang", "50");
        mongoTemplate.save(data, id);
    }
}
