package com.pinming.wk.service.impl;

import com.pinming.wk.mapper.t0Mapper;
import com.pinming.wk.model.t0;
import com.pinming.wk.model.t0Example;
import com.pinming.wk.service.T0Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： wangkai
 * @date： 2021-09-01 09:30:30
 */
@Service
public class T0ServiceImpl implements T0Service {
    @Resource
    private t0Mapper t0Mapper;
    @Override
    public void add(t0 t) {
        t0Mapper.insert(t);
    }

    @Override
    public void delete(int id) {
        t0Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<t0> query() {
        t0Example example =new t0Example();
        example.createCriteria();
        List<t0> t0List = t0Mapper.selectByExample(example);
        return t0List;
    }
}
