package com.dao;

import com.model.GMedal;

public interface GMedalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GMedal record);

    int insertSelective(GMedal record);

    GMedal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GMedal record);

    int updateByPrimaryKey(GMedal record);
}