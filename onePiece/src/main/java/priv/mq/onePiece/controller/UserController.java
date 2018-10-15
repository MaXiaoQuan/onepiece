package priv.mq.onePiece.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.mq.onePiece.entities.User;
import priv.mq.onePiece.service.UserService;
import priv.mq.onePiece.utils.OutputUtil;

@Controller
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	/**
	 * @author MaQuan
	 * @time 2017年9月25日 下午8:34:47
	 * @description : 从前端获取用户名和密码，将其作为参数传递到业务层判断是否满足登录要求。
	 */
	@RequestMapping("userValidation")
	public void userValidation(String usernameOrPhone, String password, HttpServletResponse response, HttpSession session){
		
		Map<String, String> paramMap = new HashMap<>();
		if(usernameOrPhone.length() == 11 && StringUtils.isNumeric(usernameOrPhone)){
			paramMap.put("phone", usernameOrPhone);
		}else{
			paramMap.put("userName", usernameOrPhone);
		}
		paramMap.put("password", password);
		
		Map<String, Object> map = userService.userLogin(paramMap);
		if((int)map.get("errcode") == 0){
			//若登陆成功，则将登陆信息保存到Session中，用于在登陆拦截器中判断用户是否有登陆
			session.setAttribute("user", (User)map.get("user"));
			session.setMaxInactiveInterval(20*60);
			Cookie userCookie = null;
			try {
				userCookie = new Cookie("usernameOrPhone", URLEncoder.encode(usernameOrPhone, "UTF-8"));
				userCookie.setMaxAge(30*60);
				response.addCookie(userCookie);
			} catch (UnsupportedEncodingException e) {
				logger.error("信息编码失败！");
			}
		}
		OutputUtil.outputJson(response, map);
	}
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	/**
	 * @author MaQuan
	 * @time 2017年9月25日 下午8:36:44
	 * @description : 将页面跳转到用户注册界面。
	 */
	@RequestMapping("signUp")
	public String signUp(){
		return "User/signUp";
	}
	
	/**
	 * @author MaQuan
	 * @time 2017年9月25日 下午8:37:12
	 * @description : 从前端获取用户注册的信息，将其传递到业务层以保存到数据库。
	 */
	@RequestMapping("signUpDone")
	public String signUpDone(String realName, String userName, Integer age, Boolean gender, String password, String phone, String birthDate) throws ParseException{
		
		User user = new User();
		user.setRealName(realName);
		user.setUserName(userName);
		user.setAge(age);
		user.setGender(gender);
		user.setPassword(password);
		user.setPhone(phone);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = sdf.parse(birthDate);
		user.setBirthday(birthday);
		
		userService.save(user);
		
		return "User/signUpDone";
	}
}
