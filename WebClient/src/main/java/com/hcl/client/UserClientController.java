package com.hcl.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserClientController {
	@Autowired
	UserServiceClient userServiceClient;
	
	@Autowired
	AccountServiceClient accountServiceClient;
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView model){
		User user = new User();
		model.addObject("user", user);
		model.setViewName("login");
		return model;
	}
	@RequestMapping("/home")
	public ModelAndView  loginAccount(@ModelAttribute User user) {
		String passWord=userServiceClient.getUserByName(user.getUserName()).getPassWord();
		int id=userServiceClient.getUserByName(user.getUserName()).getId();
		if(user.getPassWord().equals(passWord)) {
			return new ModelAndView("redirect:/homePage1?id="+id);
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	@RequestMapping(value="/homePage1",  method = RequestMethod.GET)
	public ModelAndView  home1(ModelAndView model,HttpServletRequest req) {
		List<Account> listAccount = accountServiceClient.getAccountByUserId(Integer.parseInt(req.getParameter("id")));
		model.addObject("listAccount", listAccount);

		model.setViewName("homePage");
		return model;
	}
}
