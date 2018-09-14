package com.momoka.dianping.service;

import java.util.List;

import com.momoka.dianping.dto.AdDto;

public interface AdService {
	/*
	 * 新增广告
	 */
	boolean add(AdDto adDto);

	List<AdDto> searchByPage(AdDto adDto);
	
	 /**
     * 修改广告
     * @param adDto
     * @return 是否修改成功：true-成功;fale-失败
     */
    boolean modify(AdDto adDto);

	Object getById(Long id);

}
