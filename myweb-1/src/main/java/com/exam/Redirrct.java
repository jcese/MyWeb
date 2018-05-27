package com.exam;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class Redirrct {
	@RequestMapping(value="/testa", method=RequestMethod.GET)
	public String inputData(){
	    return "testa"; //Spring框架找到对应的View并渲染
	}

	@RequestMapping(value="/testa", method=RequestMethod.POST)
	public String outputData(HttpServletRequest request){
	    String userName = request.getParameter("name");
	    String password = request.getParameter("pwd");
	    request.setAttribute("name", userName);
	    request.setAttribute("pwd", password);
	    //重定向到 /testb 的Controller方法(即outputDataY)上
	    return "redirect:/testb"; 
	}

	@RequestMapping(value="/testb", method=RequestMethod.POST)
	public String outputDataX(HttpServletRequest request){
	    return "testb";
	}

	@RequestMapping(value="/testb", method=RequestMethod.GET)
	public String outputDataY(HttpServletRequest request){
	    return "testb";
	}
}
