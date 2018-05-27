package com.exam;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(User user) {
		
		System.out.println(user.toString());
		return "index";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST )
	public String delete(String id) {
		
		System.out.println(id);
		return "index";
	}
	
	@RequestMapping(value="/map",method=RequestMethod.POST)
	public String ex(@RequestParam Map<String ,String> map ) {
		System.out.println(map.toString());
		return "index";
	}
	
	@RequestMapping(value="/test3",method=RequestMethod.POST)
	public String test(Model model ,User user) {
		user.setName("张三");
		user.setArg(18);
		user.setSex("男");
		model.addAttribute("user", user);
		return "test";
	}
	
	@ResponseBody
	@RequestMapping(value="/test2",method=RequestMethod.POST)
	public String test1(HttpServletRequest req,final HttpServletResponse resp,User user) {
		user.setName("张三");
		user.setArg(18);
		user.setSex("男");
		req.setAttribute("name", user.getName());
		req.setAttribute("age", user.getArg());
		req.setAttribute("sex", user.getSex());
		return "test";
	}
	
	@ResponseBody
	@RequestMapping(value="/test1",method=RequestMethod.POST)
	public User jsonTest(HttpServletRequest req,Model model) {
		model.addAttribute("msg", "13");
		User user =new User();
		user.setName("张三");
		user.setArg(18);
		user.setSex("男");
		return user;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public User jsonTo(@RequestBody User user, HttpServletRequest req) {
		return user;
	}
	
	
	@RequestMapping(value="/file",method=RequestMethod.POST)
	public String upDown(@RequestParam(value = "file",required = false) MultipartFile file, Model model) {
		String path = "F:/data/";
		String fileName =file.getOriginalFilename();
	    File targetFile =  new File("F:/data/");
	    if (!targetFile.exists()) {
			System.out.println("创建"+ targetFile.isDirectory());
			System.out.println(targetFile.mkdirs());
		}
	    try {
	    	file.transferTo(new File("F:/data/"+fileName));
		    System.out.println(file.getSize());
		    model.addAttribute("msg", "操作成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "result";
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.POST)
	public @ResponseBody Managerg jsonTo2( @Valid  Managerg manager,BindingResult result, Model model) {
		if (result.hasErrors()) { 
			   List<ObjectError> list = result.getAllErrors(); 
			   for (ObjectError error : list) { 
			    System.out.println(error.getDefaultMessage()); 
			   } 
			   return null; 
			  }  
			  System.out.println("注册.."); 
		return manager;
	}
	@RequestMapping(value="/zuoye")
	public String jsonTo() {
		return "zuoye";
	}
	/*@RequestMapping(path = "/manager", params = {"save"}, method = RequestMethod.POST)  
    public String doAdd(Model model, Managerg managerg, BindingResult result){  
        System.out.println("名字：" + managerg.getName());  
        System.out.println("密码：" + managerg.getPass());  
        System.out.println("电话：" + managerg.getPhone());  
        if(result.hasErrors()){  
            model.addAttribute("MSG", "出错啦！");  
        }else{  
            model.addAttribute("MSG", "提交成功！");  
        }  
        return "manager";  
    }  */
}

