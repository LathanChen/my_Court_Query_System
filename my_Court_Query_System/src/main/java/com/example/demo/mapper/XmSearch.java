package com.example.demo.mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.entity.User;
import com.example.demo.entity.Xiangmu;

@Mapper
public interface XmSearch {
	@Select("SELECT DISTINCT xmname,xmbianhao FROM xiangmuinfo")
	ArrayList<Xiangmu> Search_xmNames();

}
