package mybatis.controller;

import mybatis.dao.BookDao;
import mybatis.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Huangyipeng on 2016/06/02.
 */
@RestController
public class BookController {

    @Autowired
    protected BookDao bookDao;

    @RequestMapping(value = "/book/{id}")
    public Book getBook(@PathVariable("id") int id) {
        Book book = bookDao.getBookById(id);
        return book;
    }
}
