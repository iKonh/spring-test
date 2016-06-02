package mybatis.dao;

import mybatis.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Huangyipeng on 2016/06/02.
 */
@Mapper
public interface BookDao {

    Book getBookById(int id);
}
