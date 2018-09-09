package dwd.mybatisjdk10test.service;

import dwd.mybatisjdk10test.mapper.UserMapper;
import dwd.mybatisjdk10test.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
public class TestService {

    private static final Log log = LogFactory.getLog(TestService.class);

    private final UserMapper userMapper;

    public TestService(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @EventListener(value = ApplicationStartedEvent.class)
    public void runTests() {
        log.info(">>>>>> START");

        List<User> users = asList(createUser(), createUser());
        userMapper.saveAll(users);

        log.info("New users ids: " +
                users.stream()
                    .map(User::getId)
                    .collect(Collectors.toList())
        );

        List<User> allUsers = userMapper.getAllUsers();
        log.info("allUsers.size(): " + allUsers.size());

        log.info(">>>>>> END");
    }

    private User createUser() {
        User user = new User();
        user.setName("User " + UUID.randomUUID().toString());
        return user;
    }

}
