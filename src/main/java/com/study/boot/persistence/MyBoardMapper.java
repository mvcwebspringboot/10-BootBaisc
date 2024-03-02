package com.study.boot.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.boot.model.MyBoardVO;

@Mapper
public interface MyBoardMapper {
	List<MyBoardVO> findAll();
	MyBoardVO getOne(int seq);
	int save(MyBoardVO vo);
	int delete(int seq);
}
