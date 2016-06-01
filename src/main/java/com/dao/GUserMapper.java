package com.dao;

import com.dao.common.MyBatisMapper;
import com.model.GUser;

@MyBatisMapper
public interface GUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GUser record);

    int insertSelective(GUser record);

    GUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GUser record);

    int updateByPrimaryKey(GUser record);

    GUser selectByOpenID(String wxId);

    int countUserByPhone(String phone);
}