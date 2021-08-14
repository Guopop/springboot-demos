package me.guopop.springbootactuatordemo;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootTest
class SpringBootActuatorDemoApplicationTests {

	@Test
	void contextLoads() {

		JSONObject requestData = new JSONObject();
		requestData.set("akc190", "aaaa");
		requestData.set("aac002", "aaaa");
		requestData.set("aac003", "aaaa");
		requestData.set("yka103", "aaaa");
		requestData.set("aae013", "aaaa");
		requestData.set("aac131", "aaaa");
		requestData.set("bcc002", "aaaa");
		requestData.set("yae140", "aaaa");
		requestData.set("akb020", "aaaa");

		JSONObject requestBody = new JSONObject();
		requestBody.set("access_key", "aaaaaaaa");
		requestBody.set("format", "json");
		requestBody.set("request_id", "bbbbbbbbb");
		requestBody.set("timestamp", "ccccccccccc");
		requestBody.set("version", "");
		requestBody.set("sign", "aaaa11");
//		requestBody.set("biz_content", JSONUtil.toJsonStr(requestData));

		String body = requestBody.keySet().stream()
				.sorted(Comparator.naturalOrder())
				.map(key -> key + "=" + requestBody.get(key))
				.collect(Collectors.joining("&"));
		String s = body + "&" + "biz_content" + "=" + JSONUtil.toJsonStr(requestData);

		System.out.println(s);
	}

	@Test
	void test1() {
		int i = RandomUtil.randomInt(100, 1000);
		System.out.println(i);
	}

	@Test
	void test2() {
		String s = HttpUtil.get("http://localhost:8080/hello");
		System.out.println(s);
	}

}
