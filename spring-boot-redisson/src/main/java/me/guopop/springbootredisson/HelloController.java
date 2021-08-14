package me.guopop.springbootredisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author guopop
 * @date 2021/7/14 14:15
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private RedissonClient redisson;

    @GetMapping("/put")
    public void put() {
        log.info("开始添加缓存");
        RMap<String, SomeObject> map = redisson.getMap("anyMap");
        map.put("222", SomeObject.builder().name("ccc").price(30).build());
    }

    @GetMapping("/get")
    public void get() {
        log.info("获取缓存");
        RMap<String, SomeObject> map = redisson.getMap("anyMap");
        SomeObject o1 = map.get("111");
        if (Objects.nonNull(o1)) {
            log.info("name:{}, price:{}", o1.getName(), o1.getPrice());
        }
        SomeObject o2 = map.get("222");
        if (Objects.nonNull(o2)) {
            log.info("name:{}, price:{}", o2.getName(), o2.getPrice());
        }
        SomeObject o3 = map.get("333");
        log.info("o3:{}", o3);
    }
}
