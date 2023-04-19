package com.example.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class CourtOpenInfo {

//	编号（每条记录的唯一识别号）
	private int bianhao;
//	场地编号
	private int cdbianhao;
//	项目编号
	private String xmbianhao;
//	一周的第几天
	private int zhouji;
//	一周的第几天（中文）
	private String zhouji_zw;
//	场地名称
	private String court_name;
//	一个月的第几周
	private int zhoushu;
//	一个月的第几周(中文）
	private String zhoushu_zw;
//	距离
	private float juli;
//	开放的时间段（上午、下午、晚上）
	private int shijianduan;
//	开放的开始时间
	private String ks_shijian;
//	开放的结束时间
	private String js_shijian;
//	开放的具体时间
	private String shijian;
//	场馆的地址
	private String dizhi;
//	信息被录入的日期
//	使用java.sql.Date只能精确到天
//	java.sql.Timestamp可以精确到毫秒
	private Timestamp dltime;
}
