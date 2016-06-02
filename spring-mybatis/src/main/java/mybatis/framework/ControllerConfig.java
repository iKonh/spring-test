package mybatis.framework;

import mybatis.framework.json.Jsr310ObjectMapperBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by Huangyipeng on 2016/06/02.
 */
@ControllerAdvice
public class ControllerConfig {

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return Jsr310ObjectMapperBuilder.mapperBuilder();
    }
}
