package com.hand.fescar.demo.controller;

import com.hand.fescar.demo.model.AddDTO;
import com.hand.fescar.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/b")
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
}
