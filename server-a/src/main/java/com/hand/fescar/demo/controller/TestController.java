package com.hand.fescar.demo.controller;

import com.hand.fescar.demo.model.AddDTO;
import com.hand.fescar.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/a")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/{id}")
    public String get(@PathVariable(value = "id") Long id) {
        return testService.get(id);
    }

    @GetMapping("/list")
    public String list() {
        return testService.list();
    }

    /**
     * 添加一个记录
     *
     * @param dto 参数
     * @return 是否成功
     */
    @PostMapping("/add")
    public String add(@RequestBody AddDTO dto) {
        testService.add(dto);
        return "success";
    }

    /**
     * 添加相同的记录到A库和B库（结果成功）
     *
     * @param dto 参数
     * @return 是否成功
     */
    @PostMapping("/addToABS")
    public String addToABS(@RequestBody AddDTO dto) {
        testService.addToABS(dto);
        return "success";
    }

    /**
     * 添加相同的记录到A库和B库（结果失败）
     * 先在A表中插入记录，再调用B服务，插入记录到B，然后A服务出现异常，B表应该回退
     *
     * @param dto 参数
     * @return 是否调用成功
     */
    @PostMapping("/addToABF")
    public String addToABF(@RequestBody AddDTO dto) {
        testService.addToABF(dto);
        return "success";
    }
}
