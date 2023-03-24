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
import com.example.demo.entity.User;
import com.example.demo.entity.UserForm;
import com.example.demo.mapper.CourtSearch;
import com.example.demo.mapper.UserSearch;

@Service
public class Search {
	@Autowired
    private CourtSearch courtsearch;
	@Autowired
	private UserSearch usersearch;

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
	    	court1.setCourt_name(court_search.getCourt_name());
	    	court1.setDizhi(court_search.getDizhi());
	    	court1.setJuli(court_search.getJuli());
	    	System.out.println(courtlist);
	    }
		return courtlist;
	}

	public ArrayList<String> search_Court(){
		ArrayList<String> courtNameArr = courtsearch.Search_court_names();
		System.out.println(courtNameArr);
		return courtNameArr;
	}



	public boolean search_User(User userfind) {
		User user = usersearch.Search_user(userfind);
		if (user != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
