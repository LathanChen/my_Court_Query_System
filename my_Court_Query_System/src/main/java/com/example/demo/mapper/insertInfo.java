package com.example.demo.mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.CourtOpenInfo;
import com.example.demo.entity.User;

@Mapper
public interface insertInfo {

	@Insert({
		"INSERT INTO courtopeninfo (",
//		项目编号，来自于表单
		"xmbianhao,",
//		场地编号，来自于表单
		"cdbianhao,",
//		一周的第几天，来自于表单
		"zhouji,",
//		第几周，来自于表单
		"zhoushu,",
//		时间段（上午、下午、晚上），来自于表单
		"shijianduan,",
//		开放的时间段，来自于表单，字符串拼接
		"shijian,",
//		数据录入的时间，来自于Java后端
		"dltime)",
		"VALUES (",
		"#{xmbianhao},",
		"#{cdbianhao},",
		"#{zhouji},",
		"#{zhoushu},",
		"#{shijianduan},",
		"#{shijian},",
		"#{dltime})"
		})
	boolean insertInfo(CourtOpenInfo court);
}
