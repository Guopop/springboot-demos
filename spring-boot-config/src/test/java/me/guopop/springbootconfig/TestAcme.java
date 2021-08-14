package me.guopop.springbootconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author guopop
 * @date 2021/6/3 15:35
 */
@SpringBootTest
public class TestAcme {

    @Autowired
    private AcmeConfig acmeConfig;

    @Test
    void test1() {
        String desc = acmeConfig.getList().get(0).getDesc();
        System.out.println(desc);
    }

    @Autowired
    private NameConfig nameConfig;

    @Test
    void test2() {
        String firstname = nameConfig.getFirstname();
        System.out.println(firstname);
    }
}
