package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.entity.User;

@Mapper
public interface UserSearch {
	@Select("SELECT * FROM userlist WHERE username=#{username} AND password=#{password}")
	User Search_user(User user);

	@Select("SELECT * FROM userlist WHERE username=#{username}")
	User Search_user_by_name(String username);

}
