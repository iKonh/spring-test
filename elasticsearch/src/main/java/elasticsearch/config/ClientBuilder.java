package elasticsearch.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.node.Node;

import java.io.UncheckedIOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

public class ClientBuilder {

    /**
     * Transport Client Builder<br>
     * @param host host
     * @param port tcp port
     * @return Transport Client Builder
     */
    public static Client buildTransportClient(String host, Integer port) {
        TransportAddress transportAddress;
        try {
            transportAddress = new InetSocketTransportAddress(InetAddress.getByName(host), port);
        } catch (UnknownHostException e) {
            throw new UncheckedIOException("HostName Parse error", e);
        }
        return TransportClient.builder().build().addTransportAddress(transportAddress);
    }

    /**
     * Node Client Builder<br>
     * @param settings settings
     * @return Node Client Builder
     */
    public static Client buildNodeClient(Settings.Builder settings) {
        // TODO: "Caused by: java.lang.IllegalStateException: jar hell! class: org.apache.juli.AsyncFileHandler$LogEntry"対応
        String originalClassPath = System.getProperty("java.class.path");
        String[] classPathEntries = originalClassPath.split(";");
        StringBuilder esClasspath = new StringBuilder();
        for (String entry : classPathEntries) {
            if (entry.contains("elasticsearch") || entry.contains("lucene")) {
                esClasspath.append(entry);
                esClasspath.append(";");
            }
        }
        System.setProperty("java.class.path", esClasspath.toString());
        Node node = nodeBuilder().settings(settings).node();
        System.setProperty("java.class.path", originalClassPath);

        return node.client();
    }
}
