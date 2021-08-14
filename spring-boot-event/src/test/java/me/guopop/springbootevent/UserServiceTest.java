package me.guopop.springbootevent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void register() {
        User user = User.builder().name("guopop").age(27).build();
        userService.register(user);
    }
}