package com.momoka.dianping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.momoka.dianping.bean.Dic;
import com.momoka.dianping.dao.DicDao;
import com.momoka.dianping.service.DicService;
@Service
public class DicServiceImpl implements DicService{

	@Resource
	private DicDao dicDao;
	
	public List<Dic> getListByType(String type) {
		Dic dic=new Dic();
		dic.setType(type);
		return dicDao.select(dic);
	}

}
