package com.hand.fescar.demo.client;

import com.hand.fescar.demo.model.AddDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 调用service-b的客户端
 *
 * @author zhentao.zhang@hand-china.com
 * @date 2019-4-8 19:00:00
 */
@FeignClient(name = "server-b")
@RequestMapping("/b")
public interface ServiceBClient {

    /**
     * 根据id查询记录
     *
     * @param id id
     * @return 记录
     */
    @GetMapping("/{id}")
    String get(@PathVariable(value = "id") Long id);

    /**
     * 查询所有记录
     *
     * @return 所有记录
     */
    @GetMapping("/list")
    String list();

    /**
     * 添加一个记录
     *
     * @param dto 参数
     * @return 是否成功
     */
    @PostMapping("/add")
    String add(@RequestBody AddDTO dto);
}
