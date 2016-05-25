package com.dao;

import com.model.GUserMedalClick;

public interface GUserMedalClickMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GUserMedalClick record);

    int insertSelective(GUserMedalClick record);

    GUserMedalClick selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GUserMedalClick record);

    int updateByPrimaryKey(GUserMedalClick record);
}