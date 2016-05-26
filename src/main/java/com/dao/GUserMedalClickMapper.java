package com.dao;

import com.dao.common.MyBatisMapper;
import com.model.GUserMedalClick;
import java.math.BigDecimal;

@MyBatisMapper
public interface GUserMedalClickMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(GUserMedalClick record);

    int insertSelective(GUserMedalClick record);

    GUserMedalClick selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(GUserMedalClick record);

    int updateByPrimaryKey(GUserMedalClick record);
}