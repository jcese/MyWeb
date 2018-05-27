package com.exam;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ForWard {
	@RequestMapping(value="/testa", method=RequestMethod.POST)
	public String inputData(){
	    return "testa"; 
	}

	@RequestMapping(value="/testa", method=RequestMethod.POST)
	public String outputData(HttpServletRequest request){
	    String userName = request.getParameter("name");
	    String password = request.getParameter("pwd");
	    request.setAttribute("name", userName);
	    request.setAttribute("pwd", password);
	    //转发到 /testb 的Controller方法(即outputDataX)上
	    return "forward:/testb"; 
	}

	@RequestMapping(value="/testb", method=RequestMethod.POST)
	public String outputDataX(HttpServletRequest request){
	    return "testb";
	}
	
}
