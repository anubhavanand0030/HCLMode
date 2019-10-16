package com.hcl.SpringData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployController {
	
	int pageSize=2;
	@Autowired
	EmployeeRepository dao;
	@RequestMapping("/")
	public ModelAndView getEmployees() {
		ModelAndView mv=new ModelAndView();
		List<Employ> empList=(List<Employ>) dao.findAll();
		mv.addObject("employeeList",empList);
		mv.addObject("pagesize",pageSize);
		mv.addObject("totalRecords",empList.size());
		mv.setViewName("home");
		return mv;
	}
//	@RequestMapping("/displayJavaContractors")
//	public ModelAndView getJavaContractors() {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("employeeList",dao.findByDeptAndDesig("Java", "Tester"));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayDotnetDeveloperBasicHigh")
//	public ModelAndView getDotnetDevelopers() {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("employeeList",dao.findByDeptAndDesigAndBasic("dotnet", "developer"));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayBySalaryAndStartA")
//	public ModelAndView getEmployeeWithSalAndStartA() {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("employeeList",dao.findBySalaryAndStartA());
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayAllSortByDesig")
//	public ModelAndView displayAllSortByDesig() {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("employeeList",dao.findAll(Sort.by("desig")));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayAllSortByDesigDesc")
//	public ModelAndView displayAllSortByDesigDesc() {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("employeeList",dao.findAll(Sort.by("desig").descending()));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayAllSortBySalaryAndDesigDesc")
//	public ModelAndView displayAllSortBySalaryAndDesigDesc() {
//		ModelAndView mv=new ModelAndView();
//		Sort sort = Sort.by(
//			    Sort.Order.desc("basic"),
//			    Sort.Order.desc("dept"));
//
//		mv.addObject("employeeList",dao.findAll(sort));
//		mv.setViewName("home");
//		return mv;
//		}
//	@RequestMapping("/displayByDeptDesigSalSort")
//	public ModelAndView displayByDeptDesigSalSort() {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("employeeList",dao.findByDeptAndDesig("dotnet","developer",Sort.by("basic").descending()));
//		mv.setViewName("home");
//		return mv;
//	}
	@RequestMapping("/displayAll/Page/{pageno}")
	public ModelAndView displayAllSortByDesig(@PathVariable("pageno")int pageno) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findAll(PageRequest.of(pageno,pageSize)).getContent());
		mv.addObject("pagesize",pageSize);
		mv.addObject("totalRecords",((List<Employ>) dao.findAll()).size());
		mv.setViewName("home");
		return mv;
	}
	
}
