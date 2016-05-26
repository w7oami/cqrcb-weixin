package com.service;

import com.dao.GUserMapper;
import com.model.GUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/5/26.
 */
@Service
public class GameUserService extends BaseService {

    @Autowired
    private GUserMapper gUserMapper;

    public GUser getUserByWX(String openID) {
        return gUserMapper.selectByOpenID(openID);
    }

    public void saveGameUser(GUser gUser) {
        gUserMapper.insert(gUser);
    }
}
