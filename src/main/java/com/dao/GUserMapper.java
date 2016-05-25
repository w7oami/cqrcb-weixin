package com.dao;

import com.model.GUser;

public interface GUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GUser record);

    int insertSelective(GUser record);

    GUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GUser record);

    int updateByPrimaryKey(GUser record);
}