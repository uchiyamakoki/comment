package com.momoka.dianping.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.momoka.dianping.dto.BusinessDto;

@Controller
@RequestMapping("/businesses")
public class BusinessesController {
	
	/**
	 * 商户列表
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String search(BusinessDto dto) {
		return "/content/businessList";
	}
	
	/**
	 * 删除商户
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") Long id) {
		System.out.println(id);
		return "redirect:/businesses";
	}
	
	/**
	 * 商户新增页初始化
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addInit(Model model) {
		return "/content/businessAdd";
	}

	/**
	 * 商户新增
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String add(BusinessDto dto) {
		return "/content/businessAdd";
	}
	
	/**
	 * 商户修改页初始化
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String modifyInit(Model model, @PathVariable("id") Long id) {
		return "/content/businessModify";
	}

	/**
	 * 商户修改
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String modify(@PathVariable("id") Long id, BusinessDto dto) {
		return "/content/businessModify";
	}

}
