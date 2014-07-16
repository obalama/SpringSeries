package com.lipan.spring;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lipan.DO.AccountModel;

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
    public ModelAndView dataBind(HttpServletRequest httpServletRequest,@RequestParam("urlParam")String urlParam,@RequestParam("formParam")String formParam,@RequestParam("formFile")MultipartFile formFile) {
        
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("urlParam", urlParam);  
        modelAndView.addObject("formParam",formParam);
        modelAndView.addObject("formFile",formFile.getOriginalFilename());
       
        String urlParam1 = ServletRequestUtils.getStringParameter(httpServletRequest, urlParam,null);
        String formParam1 = ServletRequestUtils.getStringParameter(httpServletRequest, formParam,null);
        MultipartFile formFile1 = ((MultipartHttpServletRequest)httpServletRequest).getFile("formFile");
        modelAndView.addObject("urlParam1", urlParam1);  
        modelAndView.addObject("formParam1",formParam1);
        modelAndView.addObject("formFile1",formFile1.getOriginalFilename());
        modelAndView.setViewName("showParam");  
        return modelAndView;
    }
    
    @RequestMapping(value="/autoBind", method={RequestMethod.GET})
    public String autoBindLogin(Model model){
    	model.addAttribute("accountmodel", new AccountModel());
    	return "login";
    }
    
    @RequestMapping(value="/autoBind", method={RequestMethod.POST})
    public String autoBindResult(Model model,AccountModel am){
    	/*am.setPassword("lipantestpw");
    	am.setUsername("lipan");*/
    	model.addAttribute("accountmodel",am );
    	return "autoBindResult";
    }
    
    @RequestMapping(value="/header", method={RequestMethod.GET})
    public String headerBind(HttpServletRequest request,Model model,@RequestHeader(value="User-Agent",defaultValue="")String userAgent){
    	model.addAttribute("userAgent", userAgent);
    	return "showHeaderInfo";
    }
    
    @RequestMapping(value="/cookie", method={RequestMethod.GET})
    public String cookieBind(HttpServletRequest request,Model model,@CookieValue(value="JSESSIONID",defaultValue="")String jsessionId){
    	model.addAttribute("jsessionId", jsessionId);
    	return "showCookieInfo";
    }
}