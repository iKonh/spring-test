package redis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.Dao.UserDao;
import redis.entity.User;

/**
 * Created by Huangyipeng on 2016/03/03.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao dao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") String id){

       return dao.getUser(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void post(@PathVariable("id") String id, @RequestBody User user){
        user.id = "00001";
        dao.saveUser(user);
    }
}
