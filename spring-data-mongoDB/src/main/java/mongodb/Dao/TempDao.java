package mongodb.Dao;

import java.util.List;
import java.util.Map;

public interface TempDao {

    public List find(String id);

    public void save(String id);

    public void drop(String id);

    public void createCollection(String id);
}
