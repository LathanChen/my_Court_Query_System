//package com.example.demo.service;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.LoginUser;
//import com.example.demo.entity.ResponseResult;
//import com.example.demo.entity.User;
//import com.example.demo.util.JwtUtil;
//
//@Service
//public class LoginServiceImpl implements LoginService{
//	@Autowired
//    AuthenticationManager authenticationManager;
//
//	@Override
//    public ResponseResult login(User user) {
//        //3使用ProviderManager auth方法进行验证
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
//        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//        if(Objects.isNull(authenticate)){
//            throw new RuntimeException("用户名或密码错误！");
//        }
//
//        //4自己生成jwt给前端
//        LoginUser loginUser= (LoginUser)(authenticate.getPrincipal());
//        String userId = loginUser.getUser().getId().toString();
//        String jwt = JwtUtil.createJWT(userId);
//        Map<String,String> map=new HashMap();
//        map.put("token",jwt);
//        return new ResponseResult(200,"登陆成功",map);
//	}
//}
