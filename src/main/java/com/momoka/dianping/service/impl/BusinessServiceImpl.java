package com.momoka.dianping.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.momoka.dianping.bean.Business;
import com.momoka.dianping.dao.BusinessDao;
import com.momoka.dianping.dto.BusinessDto;
import com.momoka.dianping.service.BusinessService;
@Service
public class BusinessServiceImpl implements BusinessService{

	@Resource
	private BusinessDao businessDao;
	
	//@Value("${businessImage.url}")
	//private String url;

	public BusinessDto getById(Long id) {
		BusinessDto result=new BusinessDto();
		Business business=businessDao.selectById(id);
		BeanUtils.copyProperties(business, result);
		result.setImg(business.getImgFileName());//
		
		result.setStar(this.getStar(business));
		return result;
	}
	
	private int getStar(Business business) {
		if(business.getStarTotalNum() != null && business.getCommentTotalNum() != null && business.getCommentTotalNum() != 0) {
			return (int)(business.getStarTotalNum() / business.getCommentTotalNum());
		} else {
			return 0;
		}
	}

	
	public List<BusinessDto> searchByPage(BusinessDto businessDto) {
		List<BusinessDto> result = new ArrayList<>();
		Business businessForSelect = new Business();
		BeanUtils.copyProperties(businessDto, businessForSelect);
		List<Business> list = businessDao.selectByPage(businessForSelect);
		for (Business business : list) {
			BusinessDto businessDtoTemp = new BusinessDto();
			result.add(businessDtoTemp);
			BeanUtils.copyProperties(business, businessDtoTemp);
			businessDtoTemp.setImg( business.getImgFileName());//
			businessDtoTemp.setStar(this.getStar(business));
		}
		return result;
	}

	

}
