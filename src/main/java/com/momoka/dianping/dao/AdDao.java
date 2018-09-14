package com.momoka.dianping.dao;

import java.util.List;

import com.momoka.dianping.bean.Ad;

public interface AdDao {
	int insert(Ad ad);

	List<Ad> selectByPage(Ad condition);

	int update(Ad ad);

	Ad selectById(Long id);

}
