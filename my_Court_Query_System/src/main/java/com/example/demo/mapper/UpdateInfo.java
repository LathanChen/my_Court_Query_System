package com.example.demo.mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.CourtOpenInfo;
import com.example.demo.entity.User;

@Mapper
public interface UpdateInfo {

	@Update("UPDATE courtopeninfo SET "
			+ "zhoushu=#{zhoushu}, "
			+ "zhouji=#{zhouji}, "
			+ "shijian=#{shijian} WHERE "
			+ "bianhao=#{bianhao} AND "
			+ "xmbianhao=#{xmbianhao} AND "
			+ "cdbianhao=#{cdbianhao}")
	boolean UpdateInfo(CourtOpenInfo court);
}
