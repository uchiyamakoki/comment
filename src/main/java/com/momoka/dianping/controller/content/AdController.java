package com.momoka.dianping.controller.content;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momoka.dianping.constant.PageCodeEnum;
import com.momoka.dianping.dto.AdDto;
import com.momoka.dianping.service.AdService;

@Controller
@RequestMapping("/ad")
public class AdController {
	@Resource
	AdService adService;
	
	@RequestMapping
	public String init(){
		return "/content/addList";
	}
	@RequestMapping("/addInit")
	public String addInit(){
		return "/content/adAdd";
	}
	
	@RequestMapping("/add")
	public String add(AdDto adDto,Model model){
		if(adService.add(adDto)){
			model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_SUCCESS);
		}else{
			model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_FAIL);
		}
		
		return "/content/adAdd";
	}
}
