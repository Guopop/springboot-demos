package me.guopop.springbootconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guopop
 * @date 2021/6/3 15:31
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "acme")
public class AcmeConfig {
    private List<MyPojo> list = new ArrayList<>();

    @Getter
    @Setter
    public static class MyPojo {
        private String name;
        private String desc;
    }
}
