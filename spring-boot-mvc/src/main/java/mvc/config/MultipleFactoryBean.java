package mvc.config;

import mvc.entity.MultipleObject;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 多例工厂
 */
@Component
public class MultipleFactoryBean implements FactoryBean<MultipleObject> {

    @Override
    public MultipleObject getObject() throws Exception {
        MultipleObject multipleObject = new MultipleObject();
        multipleObject.createDate = LocalDateTime.now();
        return multipleObject;
    }

    @Override
    public Class<?> getObjectType() {
        return MultipleObject.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
