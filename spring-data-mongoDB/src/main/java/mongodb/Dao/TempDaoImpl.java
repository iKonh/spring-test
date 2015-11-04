package mongodb.Dao;

import com.mongodb.DBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TempDaoImpl implements TempDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * id:集合名
     */

    public List find(String id){
//      return  mongoTemplate.find(Map.class, id);
        return mongoTemplate.find(Query.query(Criteria.where("dalian").is("50")), Map.class, id);
    }

    // save:_id存在->update,_id不存在->insert(_id: mongodb默认主键,_id可自定义)
    public void save(String id){
        Map<String, String> data = new HashMap<>();
        data.put("dalian", "50");
        data.put("shenyang", "50");
        data.put("_id", "5550");
        mongoTemplate.save(data, id);


        // 同一集合放置同种类型数据(List数据不能和map数据混存)
        // 数据类型不能是string,integer
        List<Map<String, String>> list = new ArrayList<>();
        data = new HashMap<>();
        data.put("a", "1");
        data.put("b", "2");
        list.add(data);
        mongoTemplate.insert(list, id + "1");
    }

    // update:_id存在->不动作,_id不存在->insert(_id: mongodb默认主键)
    public void insert(String id){
        Map<String, String> data = new HashMap<>();
        data.put("dalian", "50");
        data.put("shenyang", "50");
        mongoTemplate.save(data, id);
    }


    public void update(String id){
        Update update = Update.update("dalian", "40");
        // 更新1条
//        mongoTemplate.updateFirst(new Query(Criteria.where("shenyang").is("50")), update, id);
        // 更新全部
        mongoTemplate.updateMulti(new Query(Criteria.where("shenyang").is("50")), update, id);
        System.out.println(mongoTemplate.findAll( Map.class, id));
    }

    // 删除集合
    public void drop(String id){

        // 手动删除索引
        mongoTemplate.indexOps(id).dropAllIndexes();

        mongoTemplate.dropCollection(id);
        mongoTemplate.dropCollection(id +"1");
    }

    public void createCollection(String id){
        mongoTemplate.createCollection(id);
    }
}
