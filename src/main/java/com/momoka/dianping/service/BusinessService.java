package com.momoka.dianping.service;

import java.util.List;

import com.momoka.dianping.dto.BusinessDto;

public interface BusinessService {
	 /**
     * 根据主键获取商户dto
     * @param id 主键
     * @return 商户dto
     */
    BusinessDto getById(Long id);

    List<BusinessDto> searchByPage(BusinessDto businessDto);
}
