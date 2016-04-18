package elasticsearch.repository;

import elasticsearch.entity.UserInfo;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {

    @Autowired
    @Qualifier("tcpClient")
    protected Client client;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public void bulk(List<UserInfo> userInfoList){
        BulkRequestBuilder builder = client.prepareBulk();
        for (UserInfo userInfo : userInfoList) {
            builder.add(client.prepareIndex("userInfo", "basic").setSource(userInfo));
        }
        BulkResponse bulkResponse = builder.get();
        if (bulkResponse.hasFailures()) {
            logger.error(bulkResponse.buildFailureMessage());
        }
    }

    public void bulk(UserInfo userInfo){
        IndexRequestBuilder builder = client.prepareIndex();
        builder.setIndex("userInfo");
        builder.setType("basic");
        builder.setSource(userInfo);
        IndexResponse indexResponse = builder.get();
        if (!indexResponse.isCreated()) {
            logger.error("fail");
        }
    }
}
