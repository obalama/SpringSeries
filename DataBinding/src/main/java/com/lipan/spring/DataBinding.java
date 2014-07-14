package com.lipan.spring;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/dataBinding")
public class DataBinding {
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("index");
		return modelAndView;
	}
    @RequestMapping(value="/paramBind", method = {RequestMethod.POST})
    public ModelAndView dataBind(HttpServletRequest httpServletRequest,@RequestParam("urlParam")String urlParam,@RequestParam("formParam")String formParam,@RequestParam("formFile")MultipartFile formFile) throws ServletRequestBindingException{
        
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("urlParam", urlParam);  
        modelAndView.addObject("formParam",formParam);
        modelAndView.addObject("fromFile",formFile);
        
        String urlParam1 = ServletRequestUtils.getStringParameter(httpServletRequest, urlParam);
        String formParam1 = ServletRequestUtils.getStringParameter(httpServletRequest, formParam);
        MultipartFile formFile1 = ((MultipartHttpServletRequest)httpServletRequest).getFile("formFile");
        modelAndView.addObject("urlParam1", urlParam1);  
        modelAndView.addObject("formParam1",formParam1);
        modelAndView.addObject("fromFile1",formFile1);
        modelAndView.setViewName("showParam");  
        return modelAndView;
    }
    
}