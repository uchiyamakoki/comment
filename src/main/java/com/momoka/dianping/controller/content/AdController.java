package com.momoka.dianping.controller.content;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momoka.dianping.dto.AdDto;
import com.momoka.dianping.service.AdService;

@Controller
@RequestMapping("/ad")
public class AdController {
	@Resource
	AdService adService;
	
	@RequestMapping
	public String init(){
		return "/content/adList";
	}
	@RequestMapping("/addInit")
	public String addInit(){
		return "/content/adAdd";
	}
	
	@RequestMapping("/add")
	public String add(AdDto adDto){
		adService.add(adDto);
		return "/content/adAdd";
	}
}
