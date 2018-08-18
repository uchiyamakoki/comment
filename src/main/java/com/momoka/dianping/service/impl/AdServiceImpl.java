package com.momoka.dianping.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.momoka.dianping.bean.Ad;
import com.momoka.dianping.dao.AdDao;
import com.momoka.dianping.dto.AdDto;
import com.momoka.dianping.service.AdService;

@Service
public class AdServiceImpl implements AdService{

	@Autowired
	private AdDao adDao;
	
	@Value("${adImage.savePath}")
	private String adImageSavePath;
	
	@Override
	public boolean add(AdDto adDto) {
		// TODO Auto-generated method stub
		Ad ad=new Ad();
		ad.setTitle(adDto.getTitle());
		ad.setLink(adDto.getLink());
		ad.setWeight(adDto.getWeight());
		if(adDto.getImgFile()!=null&&adDto.getImgFile().getSize()>0){
			String fileName=System.currentTimeMillis()+"_"+adDto.getImgFile().getOriginalFilename();
			File file=new File(adImageSavePath+fileName);
			File fileFolder=new File(adImageSavePath);
			if(!fileFolder.exists()){
				fileFolder.mkdirs();
			}
			try {
				adDto.getImgFile().transferTo(file);
				ad.setImgFileName(fileName);
				adDao.insert(ad);
				return true;
			} catch (IllegalStateException | IOException e) {
				return false;
			}
		}else {
			return false;
		}
	
	}

}
