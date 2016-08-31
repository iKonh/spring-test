package mvc.config;

import mvc.entity.SingletonObject;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 单例工厂
 */
@Component
public class SingletonFactoryBean implements FactoryBean<SingletonObject> {

    @Override
    public SingletonObject getObject() throws Exception {
        SingletonObject singletonObject = new SingletonObject();
        singletonObject.createDate = LocalDateTime.now();
        return singletonObject;
    }

    @Override
    public Class<?> getObjectType() {
        return SingletonObject.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
