package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.Court;
import com.example.demo.entity.CourtOpenInfo;
import com.example.demo.entity.Form;
import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.entity.UserForm;
import com.example.demo.entity.Xiangmu;
import com.example.demo.service.Search;
import com.example.demo.util.JWTUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)

public class QueryController {
	@Autowired
	Search search;

//	@GetMapping("/api/login")
//	@ResponseBody
//	public User test1() {
//	    User user = new User();
//	    user.setId(1);
//	    return user;
//	}

@GetMapping("/api/inputdata")
@ResponseBody
//	Map定义为返回值，需要在<>输入两个参数，分别为键、值
	public Map<String, List<?>> findInputData() {
		ArrayList<Court> courtList1 = search.search_Court();
		ArrayList<Xiangmu> courtList2 = search.search_XmNames();
		Map<String, List<?>> inputDatas = new HashMap<>();
		inputDatas.put("courts", courtList1);
		inputDatas.put("xiangmunames", courtList2);
		System.out.println(courtList2);
		return inputDatas;
	}

//当首页信息选择完毕点击查询时
 @PostMapping("/api/form-data")
 @ResponseBody
    public Map<String, Object> handleFormData(@RequestBody Form formData) {
        // 处理 formData 对象
        Form form = new Form();
        form.setDate(formData.getDate());
        form.setShijianduan(formData.getShijianduan());
        form.setXmbianhao(formData.getXmbianhao());
        List<Court> courtList = search.search_Court(formData);
        int courtNums = courtList.size();
        Map<String, Object> Courtmap = new HashMap<>();
        Courtmap.put("courtList", courtList);
        Courtmap.put("courtNums", courtNums);
//        System.out.println(Courtmap);
        return Courtmap;
    }

 @PostMapping("/api/courts")
 @ResponseBody
 public Result<Court> getCourts(@RequestBody Form form) {
	 Result<Court> courtsResult = search.search_Court_Forpages(form);
	 System.out.println(courtsResult);
	 return courtsResult;
 }

// 当管理员登录时
 @PostMapping("/api/adminlogin")
 @ResponseBody
 	public Map<String,Object> adminLogin(@RequestBody User formdata) {
	 Map<String,Object> result = new HashMap<>();
	 try {
		 User userInfo = search.search_User(formdata);
		 Map<String, String> map = new HashMap<>();//用来存放payload
         map.put("id",userInfo.getId());
         map.put("username", userInfo.getUsername());
//         生成Token
         String token = JWTUtils.getToken(map);
//         记录状态为成功
         result.put("state",true);
//         登录成功的通知消息
         result.put("msg","登录成功!!!");
//         放入Token
         result.put("token",token); //成功返回token信息
	 }
	 catch (Exception e) {
         e.printStackTrace();
         result.put("state",false);
         result.put("msg",e.getMessage());
     }
	 return result;
 }

// 当管理员新增项目信息时
 @PostMapping("/api/insertinfo")
 @ResponseBody
 public boolean insertInfo(@RequestBody CourtOpenInfo courtopeninfo) {
	 boolean insertFLG = search.insertCourtInfo(courtopeninfo);
//	 System.out.println(courtopeninfo);
//	 System.out.println(insertFLG);
	 return insertFLG;
 }

// 当管理员更新项目时
 @PostMapping("/api/editinfo")
 @ResponseBody
 public boolean updateInfo(@RequestBody CourtOpenInfo courtopeninfo) {
	 boolean updateFLG = search.updateCourtInfo(courtopeninfo);
//	 System.out.println(courtopeninfo);
//	 System.out.println(updateFLG);
	 return updateFLG;
 }

// 当管理员搜索项目信息时
 @PostMapping("/api/editanddeleteinfo")
 @ResponseBody
 public Result<CourtOpenInfo> adminSearchInfo(@RequestBody CourtOpenInfo courtopeninfo) {
	 System.out.println("999999999999999999999999999");
	 System.out.println(courtopeninfo);
	 Result<CourtOpenInfo> courtlist = search.admin_Search_Court_Forpages(courtopeninfo);
	 System.out.println(courtlist);
	 return courtlist;
 }
//当管理员删除项目信息时
 @DeleteMapping("/api/deleteinfo/{bianhao}")
 @ResponseBody
// @PathVariable注解用于将URL中的{bianhao}参数与方法参数绑定。
 public boolean adminSearchInfo(@PathVariable int bianhao) {
	 return search.deleteCourtInfo(bianhao);
 }

// 当用户进入需要管理员权限的页面时，验证token
 @GetMapping("/api/token/{token}")
 @ResponseBody
 public boolean tokenAuth(@PathVariable String token) {
	 boolean tokenFlg = true;
	 System.out.println(token);
	 if (token == null) {
		 tokenFlg = false;
	 }
	 try {
	     JWTUtils.getToken(token); // 解析token
	    }
	 catch (Exception e){ // 如果出现JWTVerificationException异常
		 tokenFlg = false;
		 System.out.println(e);
	    }
	 System.out.println(tokenFlg);
	 return tokenFlg; // 返回true，表示token验证通过
}
}
