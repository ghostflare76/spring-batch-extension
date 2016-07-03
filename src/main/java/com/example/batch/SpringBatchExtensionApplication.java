package com.example.batch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBatchExtensionApplication {

	public static void main(String[] args) {

		// 동일 Job Name과 Parameter로는 JobInstance 생성불가하므로 CI서버의 Build Number를 받도록
		// 함
		if (args.length == 0) {
			args = new String[] { "date=" + getCurrentDate() };
		}

		SpringApplication.run(SpringBatchExtensionApplication.class, args);
	}

	public static String getCurrentDate() {
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		format.setTimeZone(zone);

		Calendar calendar = Calendar.getInstance();
		return format.format(calendar.getTime());
	}
}
