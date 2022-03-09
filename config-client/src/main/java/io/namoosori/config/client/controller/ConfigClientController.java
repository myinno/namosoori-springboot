package io.namoosori.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${test.str}")  //application yaml의 값을 읽어온다
	private String configStr;

	@GetMapping("/test")
	public String test() {
		return configStr;
	}

	@Value("${namoosori.value}")  //application yaml의 값을 읽어온다
	private String configStrName;
/*
 * application.yaml에 정의한 내용
  spring:
    application:
      name: configtest-dev
    config:
      import: optional:configserver:http://localhost:9900
 * configtest-dev의 파일 내용
   namoosori:
     value: dev-test-valeu(MYINNO)
 */
	
	
	@GetMapping("/testName")
	public String testName() {
		return configStrName;  //configtest-dev의 값이 오는지 혹인
	}


}
