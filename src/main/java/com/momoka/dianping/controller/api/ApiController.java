package com.momoka.dianping.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.momoka.dianping.bean.Ad;
import com.momoka.dianping.dto.ApiCodeDto;
import com.momoka.dianping.dto.BusinessListDto;
/*
 * @RestController
 * 等价于@Controller+@Resp**body
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	
	//@RequestMapping(value="/homead",method=RequestMethod.GET)
	//public List<Ad> homead(){
		//ObjectMapper mapper=new ObjectMapper();
		//mapper.readValue(src, );
	//}
	
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
