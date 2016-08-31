package mvc.controller;

import mvc.entity.MultipleObject;
import mvc.entity.SingletonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * FactoryBean使用：singleton模式下 /mode1与/mode2的/singleton返回值相同
 *                  multiple模式下  /mode1与/mode2的/multiple返回值不同
 */
@RestController
@RequestMapping("/mode1")
public class FactoryBeanTestController {

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
