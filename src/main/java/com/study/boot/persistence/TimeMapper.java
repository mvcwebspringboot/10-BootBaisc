package com.study.boot.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {

	//마이바티즈를 사용할 때 아래와 같이 @Select 어노테이션을 이용해서 사용하기도 한다. 보통은 XML사용
	@Select("select now()")
	String getTime();
}
