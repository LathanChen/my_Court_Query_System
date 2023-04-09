package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Court;
import com.example.demo.entity.CourtOpenInfo;
import com.example.demo.entity.Form;

@Mapper
public interface CourtSearch {
	@Select("SELECT * FROM courtopeninfo WHERE zhouji=#{zhouji} AND zhoushu=#{zhoushu} AND shijianduan=#{shijianduan} AND xmbianhao=#{xmbianhao}")
	List<Court> Search_court(Court court);

	@Select("SELECT * FROM courtopeninfo WHERE zhouji=#{court.zhouji} AND zhoushu IN (#{court.zhoushu},6) AND shijianduan=#{court.shijianduan} AND xmbianhao=#{court.xmbianhao} LIMIT #{form.pageNum},#{form.pageSize}")
	List<Court> Search_court_with_page(Court court,Form form);

	@Select("SELECT * FROM courtopeninfo WHERE xmbianhao=#{xmbianhao} AND cdbianhao=#{cdbianhao}")
	ArrayList<CourtOpenInfo> Admin_Search_court(CourtOpenInfo courtopeninfo);

//	查询所有的场地及编号
	@Select("SELECT DISTINCT court_name, cdbianhao FROM courtinfo")
	ArrayList<Court> Search_courts();

	@Select("SELECT * FROM courtinfo WHERE cdbianhao=#{cdbianhao}")
	Court Search_court_name(Court court);
}
