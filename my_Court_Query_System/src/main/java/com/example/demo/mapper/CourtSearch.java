package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Court;
import com.example.demo.entity.CourtOpenInfo;

@Mapper
public interface CourtSearch {
	@Select("SELECT * FROM courtopeninfo WHERE zhouji=#{zhouji} AND zhoushu=#{zhoushu} AND shijianduan=#{shijianduan}")
	List<Court> Search_court(Court court);

	@Select("SELECT * FROM courtopeninfo WHERE xmbianhao=#{xmbianhao} AND cdbianhao=#{cdbianhao}")
	ArrayList<CourtOpenInfo> Admin_Search_court(CourtOpenInfo courtopeninfo);

//	查询所有的场地及编号
	@Select("SELECT DISTINCT court_name, cdbianhao FROM courtinfo")
	ArrayList<Court> Search_courts();

	@Select("SELECT * FROM courtinfo WHERE cdbianhao=#{cdbianhao}")
	Court Search_court_name(Court court);
}
