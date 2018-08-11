package com.momoka.dianping.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momoka.dianping.bean.Ad;
import com.momoka.dianping.dao.AdDao;
import com.momoka.dianping.dto.AdDto;
import com.momoka.dianping.service.AdService;

@Service
public class AdServiceImpl implements AdService{

	@Autowired
	private AdDao adDao;
	
	@Override
	public boolean add(AdDto adDto) {
		// TODO Auto-generated method stub
		Ad ad=new Ad();
		ad.setTitle(adDto.getTitle());
		ad.setLink(adDto.getLink());
		ad.setWeight(adDto.getWeight());
		File file=new File("");
		try {
			adDto.getImgFile().transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
