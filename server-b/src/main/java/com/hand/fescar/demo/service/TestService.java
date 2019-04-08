package com.hand.fescar.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.fescar.demo.mapper.TestBMapper;
import com.hand.fescar.demo.model.AddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestBMapper testMapper;

    public String get(Long id) {
        return JSONObject.toJSONString(testMapper.selectOne(id));
    }

    public String list() {
        return JSONObject.toJSONString(testMapper.list());
    }

    /**
     * 添加一个记录
     *
     * @param dto 参数
     */
    public void add(AddDTO dto) {
        testMapper.insert(dto);
    }
}


