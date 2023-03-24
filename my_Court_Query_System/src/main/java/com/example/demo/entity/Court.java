package com.example.demo.entity;

import lombok.Data;

@Data
public class Court {

//	场地编号
	private int bianhao;
//	一周的第几天
	private int zhouji;
//	场地名称
	private String court_name;
//	一个月的第几周
	private int zhoushu;
//	距离
	private float juli;
//	开放的时间段（上午、下午、晚上）
	private int shijianduan;
//	开放的具体时间
	private String shijian;
//	场馆的地址
	private String dizhi;
}
