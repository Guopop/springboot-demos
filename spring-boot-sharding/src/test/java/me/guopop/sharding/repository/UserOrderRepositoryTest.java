package me.guopop.sharding.repository;

import me.guopop.sharding.entity.UserOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserOrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void test1() {
        UserOrder order = new UserOrder();
        order.setUserId(123L);
        orderRepository.save(order);
    }
}