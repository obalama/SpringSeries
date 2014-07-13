/*
 * @author:lipan
 * */
package com.lipan.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/actionUrlMapping")
public class HelloWorld {
	
    @RequestMapping(value="/index", method = {RequestMethod.GET})
    public ModelAndView index(){
        
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("message", "Hello World!");  
        modelAndView.setViewName("index");  
        return modelAndView;
    }
    

	//测试接受多个路径的请求
	@RequestMapping(value={"/path1","/path2"})
	public ModelAndView multiPathTest(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","You enter /path1 or /path2");
		modelAndView.setViewName("path");
		return modelAndView;
	}
	
	//测试URL占位符功能
	@RequestMapping(value="occupied/{id}")
	public ModelAndView occupiedTest(@PathVariable("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id",id);
		modelAndView.setViewName("occupiedTest");
		return modelAndView;
	}
    
	//测试通配符功能
    @RequestMapping(value="/index*", method = {RequestMethod.GET})
    public ModelAndView wildCardTest(){
        
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("message", "wildCard!");       
        modelAndView.setViewName("wildCard");
        return modelAndView;
    }
    
    //测试url的正则功能
    @RequestMapping(value="/reg/{name:\\w+}-{age:\\d+}",method={RequestMethod.GET})
    public ModelAndView regTest(@PathVariable("name")String name,@PathVariable("age")Integer age){
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("name",name);
    	modelAndView.addObject("age",age);
    	modelAndView.setViewName("regTest");
    	return modelAndView;
    }
	
    //测试url参数限定功能
    @RequestMapping(value="/paramLimit", params={"p1=aa","p2!=aa"}, method = {RequestMethod.GET})
    public ModelAndView urlLimitTest(@RequestParam("p1") String p1,@RequestParam("p2")String p2){
        
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("p1", p1);        
        modelAndView.addObject("p2", p2); 
        modelAndView.setViewName("paramLimit");
        return modelAndView;
    }
    
}