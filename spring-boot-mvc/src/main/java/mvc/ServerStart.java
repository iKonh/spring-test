package mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ServerStart {

    protected ServerStart() {
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerStart.class, args);
    }
}
