package com.lipan.spring;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lipan.web.AuthPassport;

@Controller
@RequestMapping(value = "/auth")
public class AuthTest {
	@AuthPassport
    @RequestMapping(value="/index", method = {RequestMethod.GET})
    public ModelAndView index(){
        
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("message", "Hello World!");  
        modelAndView.setViewName("index");  
        return modelAndView;
    }
    @RequestMapping(value="/login", method = {RequestMethod.GET})
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("login");  
        return modelAndView;
	}
}