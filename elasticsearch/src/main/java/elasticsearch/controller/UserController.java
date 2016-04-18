package elasticsearch.controller;

import elasticsearch.entity.UserInfo;
import elasticsearch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public void addUser(UserInfo userInfo) {
        repository.bulk(userInfo);
    }

    @RequestMapping(value = "addUsers", method = RequestMethod.POST)
    public void addUsers(List<UserInfo> userInfoList) {
        repository.bulk(userInfoList);
    }
}
