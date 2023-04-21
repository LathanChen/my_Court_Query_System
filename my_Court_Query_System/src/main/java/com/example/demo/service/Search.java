package com.example.demo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Court;
import com.example.demo.entity.CourtOpenInfo;
import com.example.demo.entity.CourtsResult;
import com.example.demo.entity.Form;
import com.example.demo.entity.User;
import com.example.demo.entity.UserForm;
import com.example.demo.entity.Xiangmu;
import com.example.demo.mapper.CourtSearch;
import com.example.demo.mapper.DeleteInfo;
import com.example.demo.mapper.UpdateInfo;
import com.example.demo.mapper.UserSearch;
import com.example.demo.mapper.XmSearch;
import com.example.demo.mapper.insertInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
//在Spring Boot中，事务是指对数据访问操作进行管理的机制，它确保对数据的修改操作要么全部成功要么全部失败，从而保证数据的一致性和完整性。
//Spring Boot中的事务可以通过注解@Transactional来声明和控制。
@Transactional
public class Search {
	@Autowired
    private CourtSearch courtsearch;
	@Autowired
	private UserSearch usersearch;
	@Autowired
	private XmSearch xmsearch;
	@Autowired
	private insertInfo insertinfo;
	@Autowired
	private UpdateInfo updateinfo;
	@Autowired
	private DeleteInfo deleteinfo;

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
//		----------------4.5修改开始----------------

//		1、取得周几、第几周和时间段后，先搜索一次
		Court court1 = new Court();
		court1.setZhouji(week_index);
	    court1.setZhoushu(weekNumbe);
	    court1.setShijianduan(form.getShijianduan());
	    court1.setXmbianhao(form.getXmbianhao());
	    List<Court> courtlist1 = courtsearch.Search_court(court1);

//		2、用周几、时间段及周数=每周为key再搜索一次
	    Court court2 = new Court();
		court2.setZhouji(week_index);
	    court2.setZhoushu(6);
	    court2.setShijianduan(form.getShijianduan());
	    court2.setXmbianhao(form.getXmbianhao());
	    List<Court> courtlist2 = courtsearch.Search_court(court2);

//		3、将两次搜索得到的数据合并
	    courtlist1.addAll(courtlist2);
//	    System.out.println(courtlist1);

//	    4、取得每个场地的名称、距离、地址等信息
		for(int i=0; i<courtlist1.size();i++) {
	    	Court court3 = courtlist1.get(i);
	    	Court court_search = courtsearch.Search_court_name(court3);
//	    	System.out.println(court_search);
	    	court3.setCourt_name(court_search.getCourt_name());
	    	court3.setDizhi(court_search.getDizhi());
	    	court3.setJuli(court_search.getJuli());
//	    	System.out.println(courtlist1);
//	    ----------------4.5修改结束----------------
//		Court court = new Court();
//		if (week_index == 3 && form.getShijianduan() == 2) {
//		    court.setZhouji(week_index);
//		    court.setZhoushu(6);
//		    court.setShijianduan(form.getShijianduan());
//	    }
//	    else if (week_index == 5 && form.getShijianduan() == 2){
//		    court.setZhouji(week_index);
//		    court.setZhoushu(6);
//		    court.setShijianduan(form.getShijianduan());
//	    }
//	    else if (week_index == 3 && form.getShijianduan() == 2) {
//		    court.setZhouji(week_index);
//		    court.setZhoushu(6);
//		    court.setShijianduan(form.getShijianduan());
//	    }
//	    else if (week_index == 4 && form.getShijianduan() == 2) {
//		    court.setZhouji(week_index);
//		    court.setZhoushu(6);
//		    court.setShijianduan(form.getShijianduan());
//	    }
//
////	    其他情况：将计算出的数据放入Time对象中
//	    else {
//	    	court.setZhouji(week_index);
//	    	court.setZhoushu(weekNumbe);
//	    	court.setShijianduan(form.getShijianduan());
//	    }
//		System.out.println(court);
//		List<Court> courtlist = courtsearch.Search_court(court);
////		System.out.println(courtlist);

	    }
		return courtlist1;
	}

	public List<Court> search_Court_with_page(Form form) {
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
//		----------------4.5修改开始----------------

//		1、取得周几、第几周和时间段后，先搜索一次
		Court court1 = new Court();
		court1.setZhouji(week_index);
	    court1.setZhoushu(weekNumbe);
	    court1.setShijianduan(form.getShijianduan());
	    court1.setXmbianhao(form.getXmbianhao());
//	    新的SQL查询，可以查询满足前面算出的周数及每周这两个任意条件的记录
	    List<Court> courtlist1 = courtsearch.Search_court_with_page(court1,form);

//	    2、取得每个场地的名称、距离、地址等信息
		for(int i=0; i<courtlist1.size();i++) {
	    	Court court3 = courtlist1.get(i);
	    	Court court_search = courtsearch.Search_court_name(court3);
//	    	System.out.println(court_search);
	    	court3.setCourt_name(court_search.getCourt_name());
	    	court3.setDizhi(court_search.getDizhi());
	    	court3.setJuli(court_search.getJuli());
	    }
		return courtlist1;
	}

	public CourtsResult<Court> search_Court_Forpages(Form form) {
//		System.out.println(form.getPageNum());
//		System.out.println(form.getPageSize());
		int PageNum = form.getPageNum();
		int PageSize = form.getPageSize();
		PageHelper.startPage(PageNum, PageSize);     // 使用PageHelper进行分页查询获得场地查询结果
		List<Court> courtList = search_Court(form);
	    PageInfo<Court> pageInfo = new PageInfo<>(courtList);

	    CourtsResult<Court> courtsResult = new CourtsResult<>();
	    courtsResult.setList(pageInfo.getList());
	    courtsResult.setTotal(pageInfo.getTotal());
	    courtsResult.setPageNum(pageInfo.getPageNum());
	    courtsResult.setPageSize(pageInfo.getPageSize());
	    courtsResult.setPages(pageInfo.getPages());
	    courtsResult.setCount(pageInfo.getList().size());
        return courtsResult;
	}

	public ArrayList<Court> search_Court(){
		ArrayList<Court> courtNameAndNumarr = courtsearch.Search_courts();
//		System.out.println(courtNameAndNumarr);
		return courtNameAndNumarr;
	}

	public ArrayList<CourtOpenInfo> Admin_Search_court(CourtOpenInfo courtopeninfo){
		ArrayList<CourtOpenInfo> adminSearchList = courtsearch.Admin_Search_court(courtopeninfo);
		for(CourtOpenInfo info : adminSearchList) {
			String[] shijian = info.getShijian().split("-");
			info.setKs_shijian(shijian[0]);
			info.setJs_shijian(shijian[1]);
		}
		System.out.println(adminSearchList);
		return adminSearchList;
	}

	public ArrayList<Xiangmu> search_XmNames(){
		ArrayList<Xiangmu> xmNameArr = xmsearch.Search_xmNames();
		return xmNameArr;
	}

	public User search_User(User userfind) {
		User user = usersearch.Search_user(userfind);
		if(user!=null){
            return user;
        }
        throw  new RuntimeException("登录失败~~");
    }


	public boolean insertCourtInfo(CourtOpenInfo court){
		Timestamp dltime = new Timestamp(System.currentTimeMillis());
		court.setDltime(dltime);
		String shijian = court.getKs_shijian()+"-"+court.getJs_shijian();
		court.setShijian(shijian);
		return insertinfo.insertInfo(court);
	}

	public boolean updateCourtInfo(CourtOpenInfo court){
//		System.out.println(court);
		court.setShijian(court.getKs_shijian()+"-"+court.getJs_shijian());
		return updateinfo.UpdateInfo(court);
	}

	public boolean deleteCourtInfo(int bianhao){
		return deleteinfo.DeleteInfo(bianhao);
	}
}
