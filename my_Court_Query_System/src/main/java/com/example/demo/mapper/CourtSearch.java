package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Court;

@Mapper
public interface CourtSearch {
	@Select("SELECT * FROM basketballcourt WHERE zhouji=#{zhouji} AND zhoushu=#{zhoushu} AND shijianduan=#{shijianduan}")
	List<Court> Search_court(Court court);

	@Select("SELECT DISTINCT court_name FROM courtinfo;")
	ArrayList<String> Search_court_names();

	@Select("SELECT * FROM courtinfo WHERE bianhao=#{bianhao}")
	Court Search_court_name(Court court);
}
