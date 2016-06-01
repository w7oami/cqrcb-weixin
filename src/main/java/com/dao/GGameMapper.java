package com.dao;

import com.dao.common.MyBatisMapper;
import com.model.GGame;

@MyBatisMapper
public interface GGameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GGame record);

    int insertSelective(GGame record);

    GGame selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GGame record);

    int updateByPrimaryKey(GGame record);

    int getUserGameNumber(Long userid);
}