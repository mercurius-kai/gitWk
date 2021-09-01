package com.pinming.wk.controller;

import com.pinming.wk.model.t0;
import com.pinming.wk.service.T0Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author： wangkai
 * @date： 2021-09-01 09:16:42
 */
@Api(tags = "demo")
@RestController
@RequestMapping("/api/wk/test")
public class T0Controller {

    @Resource
    private T0Service t0Service;

    @ApiOperation("新增数据")
    @PostMapping("/add")
    public void add(@RequestBody t0 t) {
        t0Service.add(t);
    }

    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public void delete(int id) {
        t0Service.delete(id);
    }

    @ApiOperation("查询数据")
    @GetMapping("/query")
    public List<t0> query() {
        return t0Service.query();
    }

}
