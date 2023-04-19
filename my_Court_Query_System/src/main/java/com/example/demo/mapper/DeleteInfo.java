package com.example.demo.mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.CourtOpenInfo;
import com.example.demo.entity.User;

@Mapper
public interface DeleteInfo {

	@Delete("DELETE FROM courtopeninfo WHERE "
			+ "bianhao = #{bianhao}")
	boolean DeleteInfo(int bianhao);
}
