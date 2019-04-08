package com.hand.fescar.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.hand.fescar.demo.client.ServiceBClient;
import com.hand.fescar.demo.mapper.TestAMapper;
import com.hand.fescar.demo.model.AddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    @Autowired
    private TestAMapper testMapper;
    @Autowired
    private ServiceBClient serviceBClient;

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

    /**
     * 添加记录到A和B
     *
     * @param dto 参数
     */
    @Transactional(rollbackFor = Exception.class)
    public void addToABS(AddDTO dto) {
        testMapper.insert(dto);
        serviceBClient.add(dto);
    }

    /**
     * 添加记录到A和B，最后回退
     *
     * @param dto 参数
     */
    @GlobalTransactional(name = "fescar-test-tx")
    public void addToABF(AddDTO dto) {
        testMapper.insert(dto);
        serviceBClient.add(dto);
        throw new RuntimeException("mock exception");
    }
}
