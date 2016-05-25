package com.dao;

import com.model.GUserMedal;

public interface GUserMedalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GUserMedal record);

    int insertSelective(GUserMedal record);

    GUserMedal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GUserMedal record);

    int updateByPrimaryKey(GUserMedal record);
}