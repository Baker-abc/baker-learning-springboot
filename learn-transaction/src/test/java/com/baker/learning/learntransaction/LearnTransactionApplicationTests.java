package com.baker.learning.learntransaction;

import com.baker.learning.learntransaction.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class LearnTransactionApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    /**
     * 发生异常，事务回滚
     */
    @Test
    public void testTransaction() {
        userService.save(false);
    }

}
