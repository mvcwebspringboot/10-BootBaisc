package com.study.boot;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.boot.autowired_DI.SampleService;
import com.study.boot.persistence.TimeMapper;

import jakarta.activation.DataSource;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class SampleTests {


	@Autowired //만일 해당 타입의 Bean이 존재하면 여기에 주입해 주기를 원한다. 
	private SampleService sampleService;
	

	@Test
	public void testService() {
		log.info("★★★★★ "+sampleService);
		assertNotNull(sampleService);
	}
	
	//마이바티즈 테스트
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testMyBatis() {
		log.info("★★★★★ " + timeMapper.getTime());
	}
	
}
