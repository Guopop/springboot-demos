package me.guopop.springbooteasyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;

@SpringBootTest
class SpringBootEasyexcelApplicationTests {

	@Test
	void contextLoads() {
		String fileName = "D:/user.xlsx";
		EasyExcel.read(fileName, User.class, new UserListener()).sheet().doRead();
	}

}
