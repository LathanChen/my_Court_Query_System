package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Court;
import com.example.demo.entity.Form;
import com.example.demo.entity.User;
import com.example.demo.service.Search;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)

public class QueryController {
	@Autowired
	Search search;

	@GetMapping("/api/login")
	@ResponseBody
	public User test1() {
	    User user = new User();
	    user.setId(1);
	    return user;
	}

 @PostMapping("/api/form-data")
 @ResponseBody
    public Map<String, Object> handleFormData(@RequestBody Form formData) {
        // 处理 formData 对象
        Form form = new Form();
        form.setDate(formData.getDate());
        form.setShijianduan(formData.getShijianduan());
        form.setXiangmu(formData.getXiangmu());
        List<Court> courtList = search.search_Court(formData);
        int courtNums = courtList.size();
        Map<String, Object> Courtmap = new HashMap<>();
        Courtmap.put("courtList", courtList);
        Courtmap.put("courtNums", courtNums);
        System.out.println(Courtmap);
        return Courtmap;
    }
}
