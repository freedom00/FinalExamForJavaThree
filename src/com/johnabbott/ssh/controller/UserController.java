package com.johnabbott.ssh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.ssh.entity.User;
import com.johnabbott.ssh.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("login");
		ModelAndView modelAndView = new ModelAndView("login_page");
		modelAndView.addObject("user", new User());

		return modelAndView;
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ModelAndView getUsers() {
		System.out.println("getUsers");
		ModelAndView modelAndView = new ModelAndView("get_users");

		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		modelAndView.addObject("user", new User());

		return modelAndView;
	}

	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable("eamil") String email) {
		ModelAndView modelAndView = new ModelAndView("user");
		modelAndView.addObject("email", email);

		return modelAndView;
	}

	@RequestMapping(value = "addUser")
	public ModelAndView addUser() {
		System.out.println("addUser");
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		System.out.println("saveUser");
		if (userService.addUser(user))
			return "home_page";
		else {
			return "redirect:/users/saveUser";
		}
	}

	@RequestMapping(value = "submitUser")
	public String submitUser(@ModelAttribute("user") User user) {
		System.out.println("submitUser" + user);
		if (null != userService.getUser(user.getEmail(), user.getPassword())) {
			return "home_page";
		} else {
			return "redirect:/users/addUser";
		}
	}

}
