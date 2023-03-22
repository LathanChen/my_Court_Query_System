package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Court;
import com.example.demo.entity.Form;
import com.example.demo.mapper.CourtSearch;

@Service
public class Search {
	@Autowired
    private CourtSearch courtsearch;

//	根据前端页面用户选择的日期，判断当天是本周的第几天
	public List<Court> search_Court(Form form) {
//		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(form.getDate());
//		本周的第几天
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
//		如果是周日，则赋值为0
		if(week_index<0){
			week_index = 0;
		}
//		本月的第几周
		int weekNumbe = cal.get(Calendar.WEEK_OF_MONTH);
		if(week_index == 0){
			weekNumbe = weekNumbe-1;
		}

		Court court = new Court();
		if (week_index == 3 && form.getShijianduan() == 2) {
		    court.setZhouji(week_index);
		    court.setZhoushu(6);
		    court.setShijianduan(form.getShijianduan());
	    }
	    else if (week_index == 5 && form.getShijianduan() == 2){
		    court.setZhouji(week_index);
		    court.setZhoushu(6);
		    court.setShijianduan(form.getShijianduan());
	    }
	    else if (week_index == 3 && form.getShijianduan() == 2) {
		    court.setZhouji(week_index);
		    court.setZhoushu(6);
		    court.setShijianduan(form.getShijianduan());
	    }
	    else if (week_index == 4 && form.getShijianduan() == 2) {
		    court.setZhouji(week_index);
		    court.setZhoushu(6);
		    court.setShijianduan(form.getShijianduan());
	    }

//	    其他情况：将计算出的数据放入Time对象中
	    else {
	    	court.setZhouji(week_index);
	    	court.setZhoushu(weekNumbe);
	    	court.setShijianduan(form.getShijianduan());
	    }
//		System.out.println(court);
		List<Court> courtlist = courtsearch.Search_court(court);
//		System.out.println(courtlist);
		for(int i=0; i<courtlist.size();i++) {
	    	Court court1 = courtlist.get(i);
	    	Court court_search = courtsearch.Search_court_name(court1);
//	    	System.out.println(court_search);
	    	court1.setName(court_search.getName());
	    	court1.setDizhi(court_search.getDizhi());
	    	court1.setJuli(court_search.getJuli());
	    	System.out.println(courtlist);
	    }
		return courtlist;
	}

//	public String Search_basketball_court(String kyori) {
//		return basketball_court_search.SearchJyuusyo(kyori);
//	}
//
//	public List<Court> Search_court(Time time) {
//		Date date = time.getYearmonthday();
//		Calendar calendar = Calendar.getInstance();
//		calendar.setFirstDayOfWeek(Calendar.MONDAY);
//		calendar.setTime(date);
//
////		本月的第几周
//		Integer weekNumbe = calendar.get(Calendar.WEEK_OF_MONTH);
////		本周的第几天
//	    int week_index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
////	    用来作为查询场地结果列表的参数
//	    Time time1 = new Time();
//
////	    判断特殊情况：部分场地在部分时间段每周都开放，这时syuuusuu设置为6
//	    if (week_index == 3 && time.getJikantai() == 2) {
//		    court.setZhouji(week_index);
//		    court.setZhoushu(6);
//		    court.setShijianduan(time.getJikantai());
//	    }
//	    else if (week_index == 5 && time.getJikantai() == 2){
//		    court.setZhouji(week_index);
//		    court.setZhoushu(6);
//		    court.setShijianduan(time.getJikantai());
//	    }
//	    else if (week_index == 3 && time.getJikantai() == 2) {
//		    court.setZhouji(week_index);
//		    court.setZhoushu(6);
//		    court.setShijianduan(time.getJikantai());
//	    }
//	    else if (week_index == 4 && time.getJikantai() == 2) {
//		    court.setZhouji(week_index);
//		    court.setZhoushu(6);
//		    court.setShijianduan(time.getJikantai());
//	    }
//
////	    其他情况：将计算出的数据放入Time对象中
//	    else {
//	    	court.setZhouji(week_index);
//	    	court.setZhoushu(weekNumbe);
//	    	court.setShijianduan(time.getJikantai());
//	    }
//		/*
//		 * System.out.println(time1.getYoubi1());
//		 * System.out.println(weekNumbe);
//		 * System.out.println(time.getJikantai());
//		 */
//
////	    调用mapper中的方法，查询场地
//	    List<Court> court_list1 = basketball_court_search.Search_court(time1);
//
////	    遍历结果列表，根据场地编号在另一张表中查询场地名称，并添加到每个court元素的court_name属性中
//	    for(int i=0; i<court_list1.size();i++) {
//	    	Court court1 = court_list1.get(i);
//	    	String name = basketball_court_search.Search_court_name(court1);
//	    	court1.setCourt_name(name);
//	    }
//
////	    返回结果
//	    return court_list1;
//	}
}
