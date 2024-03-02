package com.study.boot.autowired_DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

//test의 SampleTests 에서 테스트 함

@Service
@ToString
@RequiredArgsConstructor //생성자함수를 이용한 DI (그런데 이 방식은 p240에서 @Qualifier를 적용했을때 lombok.config 를 설정해도 잘 작동되지 않는 문제가 있어서 사용하기 어려움. 2024-03-01
public class SampleService {

	//@Autowired
	//private SampleDAO sampleDAO;
	
	@Qualifier("event")
	private final SampleDAO sampleDAO; //생성자함수를 이용한 DI p236
	
}
