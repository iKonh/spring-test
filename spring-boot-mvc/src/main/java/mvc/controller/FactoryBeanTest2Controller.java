package mvc.controller;

import mvc.entity.MultipleObject;
import mvc.entity.SingletonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Huangyipeng on 2016/08/31.
 */
@RestController
@RequestMapping("/mode2")
public class FactoryBeanTest2Controller {

    @Autowired
    SingletonObject singletonObject;

    @Autowired
    MultipleObject multipleObject;

    @RequestMapping("/singleton")
    public String testSingleton() {
        return singletonObject.createDate.toString();
    }

    @RequestMapping("/multiple")
    public String testMultiple() {
        return multipleObject.createDate.toString();
    }
}
