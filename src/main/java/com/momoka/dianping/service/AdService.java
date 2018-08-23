package com.momoka.dianping.service;

import java.util.List;

import com.momoka.dianping.dto.AdDto;

public interface AdService {
	/*
	 * 新增广告
	 */
	boolean add(AdDto adDto);

	List<AdDto> searchByPage(AdDto adDto);

}
