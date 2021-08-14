package me.guopop.springbootmybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("me.guopop.springbootmybatisplusdemo.mapper")
@SpringBootApplication
public class SpringBootMybatisPlusDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisPlusDemoApplication.class, args);
	}

}
