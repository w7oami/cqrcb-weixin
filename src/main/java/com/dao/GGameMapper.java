package com.dao;

import com.model.GGame;

public interface GGameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GGame record);

    int insertSelective(GGame record);

    GGame selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GGame record);

    int updateByPrimaryKey(GGame record);
}