package com.momoka.dianping.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mchange.v2.beans.BeansUtils;
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
		// TODO 可以获取失败详细原因
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

	
	public List<AdDto> searchByPage(AdDto adDto) {
		List<AdDto> result=new ArrayList<AdDto>();
		Ad condition=new Ad();
		BeanUtils.copyProperties(adDto, condition);
		List<Ad> adList=adDao.selectByPage(condition);
		for(Ad ad:adList){
			AdDto adDtoTemp=new AdDto();
			result.add(adDtoTemp);
			BeanUtils.copyProperties(ad, adDtoTemp);
		}
		
		return result;
	}

	

}
