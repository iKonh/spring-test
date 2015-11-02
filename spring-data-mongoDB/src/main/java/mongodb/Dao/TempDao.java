package mongodb.Dao;

import java.util.List;
import java.util.Map;

public interface TempDao {

    public List find(String id);

    public void save(String id);
}
