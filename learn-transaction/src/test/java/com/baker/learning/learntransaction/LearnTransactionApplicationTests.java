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
     * desc link： https://segmentfault.com/a/1190000013341344
     *
     * REQUIRED
     * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
     * REQUIRES_NEW
     * 新建事务，如果当前存在事务，把当前事务挂起。
     * MANDATORY
     * 使用当前的事务，如果当前没有事务，就抛出异常。
     * SUPPORTS
     * 支持当前事务，如果当前没有事务，就以非事务方式执行。
     *
     *
     * NOT_SUPPORTED
     * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     * NEVER
     * 以非事务方式执行，如果当前存在事务，则抛出异常。
     * NESTED
     * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     *
     */
    @Test
    public void testTransaction1() {
        userService.save1(false);
    }


}
