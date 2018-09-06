package com.momoka.dianping.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.momoka.dianping.bean.Ad;
import com.momoka.dianping.dto.AdDto;
import com.momoka.dianping.dto.ApiCodeDto;
import com.momoka.dianping.dto.BusinessListDto;
import com.momoka.dianping.service.AdService;
/*
 * @RestController
 * 等价于@Controller+@Resp**body
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private AdService adService;
	
	@Value("${ad.number}")
	private int adNumber;
	
	
	@RequestMapping(value="/homead",method=RequestMethod.GET)
	public List<AdDto> homead(){
		AdDto adDto=new AdDto();
		adDto.getPage().setPageNumber(adNumber);
		return adService.searchByPage(adDto);
	}
	
	//@RequestMapping(value="/homelist/{city}/{page}",method=RequestMethod.GET)
	//public BusinessListDto homelist(){
		
	//}
	
	@RequestMapping(value="/submitComment",method=RequestMethod.GET)
	public Map<String, Object> submitComment(){
		Map<String, Object> result=new HashMap<>();
		result.put("errno", 0);
		result.put("msg", "ok");
		return result;
	}
}
