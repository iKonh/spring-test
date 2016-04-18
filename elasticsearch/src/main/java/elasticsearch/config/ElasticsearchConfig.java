package elasticsearch.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Value("${elasticsearch.ip}")
    protected String ip;

    @Value("${elasticsearch.port.tcp}")
    protected Integer tcpPort;

    @Value("${elasticsearch.path}")
    protected String path;

    @Bean(name = "tcpClient")
    public Client getTcpClient() {
        return ClientBuilder.buildTransportClient(ip, tcpPort);
    }

    @Bean(name = "nodeClient")
    public Client getNodeClient() {
        Settings.Builder settings = Settings.builder().put("path.home", path).put("transport.tcp.port", tcpPort);
        return ClientBuilder.buildNodeClient(settings);
    }
}
