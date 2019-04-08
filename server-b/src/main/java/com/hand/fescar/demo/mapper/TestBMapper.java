package com.hand.fescar.demo.mapper;

import com.hand.fescar.demo.model.AddDTO;
import com.hand.fescar.demo.model.TestB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestBMapper {
    List<TestB> list();

    TestB selectOne(Long id);

    /**
     * 插入一个记录
     *
     * @param dto 记录参数
     * @return 插入记录数
     */
    int insert(AddDTO dto);
}
