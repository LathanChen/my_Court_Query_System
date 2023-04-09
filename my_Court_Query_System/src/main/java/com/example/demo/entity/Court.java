package com.example.demo.entity;

import lombok.Data;

@Data
public class Court {

//	场地编号
	private int cdbianhao;
//	项目编号
	private int xmbianhao;
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
//	表格中的编号
	private String bianhao;

}
