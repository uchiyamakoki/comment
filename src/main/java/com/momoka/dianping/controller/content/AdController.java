package com.momoka.dianping.controller.content;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.momoka.dianping.constant.PageCodeEnum;
import com.momoka.dianping.dto.AdDto;
import com.momoka.dianping.service.AdService;

@Controller
@RequestMapping("/ad")
public class AdController {
	@Resource
	AdService adService;
	
	@RequestMapping("/remove")
	public String remove(@RequestParam("id")Long id,AdDto adDto){
		return "forward:/ad";
	}
	
	/**
	 * 广告管理页初始化(点广告管理菜单进入的第一个页面)
	 */
	@RequestMapping
	public String init(Model model, HttpServletRequest request) {
		AdDto adDto = new AdDto();
		model.addAttribute("list", adService.searchByPage(adDto));
		model.addAttribute("searchParam", adDto);
		return "/content/addList";
	}
	
	@RequestMapping("/addInit")
	public String addInit(){
		return "/content/adAdd";
	}
	
	@RequestMapping("/search")
	public String search(Model model,AdDto adDto){
		model.addAttribute("list",adService.searchByPage(adDto));
		return "/content/addList";
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
	
	/**
	 * 修改页初始化
	 */
	@RequestMapping("/modifyInit")
	public String modifyInit(Model model, @RequestParam("id") Long id) {
		model.addAttribute("modifyObj", adService.getById(id));
		return "/content/adModify";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/modify")
	public String modify(Model model, AdDto adDto) {
		model.addAttribute("modifyObj", adDto);
		if (adService.modify(adDto)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
		}
		return "/content/adModify";
	}
}
