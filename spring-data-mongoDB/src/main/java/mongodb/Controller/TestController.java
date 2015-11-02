package mongodb.Controller;

import mongodb.Dao.TempDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Huangyipeng on 2015/11/02.
 */
@RestController
public class TestController {

    @Autowired
    protected TempDao tempDao;

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public void getData(@RequestParam("id") String id){
        List result = tempDao.find(id);
        System.out.println(result);
    }

    @RequestMapping(value = "/saveData", method = RequestMethod.GET)
    public void saveData(@RequestParam("id") String id){
        tempDao.save(id);
    }
}
