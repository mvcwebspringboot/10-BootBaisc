package com.study.boot.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class MyBoardVO implements Serializable{
	private int seq;
	private String writer;
	private String title;
	private String content;
	private LocalDate regdate;
}
