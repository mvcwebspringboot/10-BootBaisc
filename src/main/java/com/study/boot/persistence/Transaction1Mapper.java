package com.study.boot.persistence;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Transaction1Mapper {
	void buy(String customerid, int amount);
}
