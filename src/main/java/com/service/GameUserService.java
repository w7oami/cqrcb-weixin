package com.service;

import com.dao.GUserMapper;
import com.model.GUser;
import com.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int countUserByPhone(String phone) {
        return gUserMapper.countUserByPhone(phone);
    }

    public void saveGameUser(GUser gUser) {
        gUserMapper.insert(gUser);
    }

    public List<Map<String, Object>> getRandomPoint(String openID) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        int max=20;
        int min=5;

        int count = 35;
        int sum = 500;

        int _s = 0;

        BigDecimal bc = new BigDecimal(count);
        BigDecimal bs = new BigDecimal(sum);
        BigDecimal bf = bs.divide(bc, BigDecimal.ROUND_UP);
        int f = bf.intValue();
        for(int i=0; i < count; i++) {
            int rl  = NumberUtils.randomInt(min, max);
            if(i % 2 == 0) {
                if(rl + _s > min && rl + _s <= max) {
                    rl += _s / 2;
                }
                _s += f - rl;
            } else {
                if(rl + _s > min && rl + _s <= max) {
                    rl += _s;
                    _s = 0;
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(openID + "_" + i, rl);
            list.add(map);
        }

        return list;
    }
}
