package com.example.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Form {
	@DateTimeFormat(pattern ="yyyy-MM-dd")
//	前端输入的日期值
	private Date date;
//	前端输入的时间段
	private int shijianduan;
//	前端输入的运动项目编号
	private int xmbianhao;
//	分页功能-当前页码数
	private int pageNum;
//	分页功能-每页记录数
	private int pageSize;

}
