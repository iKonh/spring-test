package mybatis.framework.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * java8的Json转换
 */
public class Jsr310ObjectMapperBuilder {

    public static ObjectMapper build() {
        return mapperBuilder().build();
    }

    /**
     * 创建Jackson2ObjectMapperBuilder。
     *
     * @return Jackson2ObjectMapperBuilder
     */
    public static Jackson2ObjectMapperBuilder mapperBuilder() {
        return Jackson2ObjectMapperBuilder.json()
                .indentOutput(true)
                .serializerByType(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                    @Override
                    public void serialize(LocalDateTime value, JsonGenerator jgen,
                                          SerializerProvider provider) throws IOException {
                        jgen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    }
                })
                .deserializerByType(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonParser jp,
                                                     DeserializationContext ctxt) throws IOException {
                        return LocalDateTime.parse(jp.getValueAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    }
                })
                .modules(new JavaTimeModule());
    }

    protected Jsr310ObjectMapperBuilder() {
        // Do nothing.
    }
}
