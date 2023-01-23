package com.emp.login.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emp.login.model.Login;
import com.emp.login.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private LoginService userService;
	String status = "";

	@GetMapping("/")
	public String ModelAndView(Model mav) {
		mav.addAttribute("user", new Login());

		return "login";
	}

	@PostMapping("/index")
	public String login(@ModelAttribute("user") Login user, Model m) {

		Login oauthUser = userService.login(user.getUsername(), user.getPassword());

		if (Objects.nonNull(oauthUser)) {
			System.out.println("success");
			return "index";

		} else {
			m.addAttribute("error", "Invalid Username or Password");
			System.out.println("failed");
			return "login";

		}

	}

	@PostMapping("/logout")
	public String logoutDo(Model mav2) {
		mav2.addAttribute("user", new Login());
		return "login";
	}

}
