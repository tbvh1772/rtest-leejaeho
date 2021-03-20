package com.rtest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rtest.domain.UserVO;
import com.rtest.service.UserService;


@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/")
	public String home() {
		
		return "home";
	}
	
	//로그인 view
	@GetMapping(value = "/user/login")
	public void getLogin() {
		logger.info("get login");
	}
	
	// 로그인 처리
	@RequestMapping(value = "/user/login",method = RequestMethod.POST)
			public String postLogin(HttpServletRequest req, HttpServletResponse response,
				RedirectAttributes rttr,UserVO userVo , Model model) throws Exception {
				logger.info("로그인 처리 호출");
				
				HttpSession session = req.getSession();
				UserVO user = userService.login(userVo);
				
				if(user == null) {
					logger.info("로그인 처리안됨");
					session.setAttribute("member", null);
					rttr.addFlashAttribute("msg",false);
					return "redirect:/user/login";
					
				}else {
					logger.info("로그인 처리됨");
					session.setAttribute("member", user); 
					session.setAttribute("userId", user.getUser_id()); 
					return "redirect:../";
				}
			
			}
	
	//로그아웃 처리
	@GetMapping(value = "/logout")
	public String  getLogout(HttpSession session) {
		logger.info("로그아웃 처리 호출");
		String check = (String) session.getAttribute("userId");
		if(check != null) {
			logger.info("로그아웃 처리됨");
			session.invalidate();
			return "redirect:/";
		}else {
			logger.info("비정상적 로그아웃 접근됨");
			return "redirect:/login";
		}
		
	}
	
	
	
	
}
