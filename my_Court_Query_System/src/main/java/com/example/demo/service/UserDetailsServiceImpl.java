//package com.example.demo.service;
//
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.LoginUser;
//import com.example.demo.entity.User;
//import com.example.demo.mapper.UserSearch;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	UserSearch usersearch;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	User user = usersearch.Search_user_by_name(username);
//    	System.out.println(user);
//        //如果查询不到数据就通过抛出异常来给出提示
//        if(Objects.isNull(user)){
//            throw new RuntimeException("用户名错误");
//        }
//        //TODO 根据用户查询权限信息 添加到LoginUser中
//
//
//        //封装成UserDetails对象返回
//        return new LoginUser(user);
//    }
//}