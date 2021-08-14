package me.guopop.springbootredisson;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRedissonApplication {

	@Autowired
	private RedissonClient redisson;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedissonApplication.class, args);
	}

	@Bean
	public void init() {
		RMap<String, SomeObject> map = redisson.getMap("anyMap");

		map.put("111", SomeObject.builder().name("aaa").price(10).build());
	}
}
