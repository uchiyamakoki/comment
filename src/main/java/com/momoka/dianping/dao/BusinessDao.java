package com.momoka.dianping.dao;

import java.util.List;

import com.momoka.dianping.bean.Business;

public interface BusinessDao {
	 
    /**
     *  根据主键查询商户
     * @param id 主键
     * @return 商户对象
     */
    Business selectById(Long id);

	List<Business> selectByPage(Business businessForSelect);

}
